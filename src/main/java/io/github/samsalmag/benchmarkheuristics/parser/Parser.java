package io.github.samsalmag.benchmarkheuristics.parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.JavaParserAdapter;
import com.github.javaparser.ParserConfiguration;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.resolution.declarations.ResolvedConstructorDeclaration;
import com.github.javaparser.resolution.declarations.ResolvedMethodDeclaration;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserAnonymousClassDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.declarations.JavaParserMethodDeclaration;
import com.github.javaparser.symbolsolver.reflectionmodel.ReflectionMethodDeclaration;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class that parses a method recursively. The parser goes through all methods within the provided method as well, etc...
 * Is able to find method invocations, object instantiations, and package accesses.
 * Use MethodParser.parse() to first parse a method, then use getters to retrieve the information about it.
 *
 * @author Sam Salek
 */
public class Parser {

    private final boolean debug = false;    // Display debug prints.

    private final ParserConfiguration PARSER_CONFIG;
    private final CombinedTypeSolver TYPE_SOLVER;
    private final JavaParserAdapter PARSER;

    private final int maxDepth;           // Maximum recursion depth. Default is at most 1000 recursions if no other value is provided.
    private final String baseMainPath;
    private final String baseTestPath;
    private final String projectTerm;     // This is used to figure out of method is within source code or a java lib.
                                          // Should reflect a unique package name within the project, e.g., "rxjava" for project RxJava.

    private ParsedMethod parsedMethod;
    private Map<String, Integer> methodCalls = new HashMap<>();
    private Map<String, Integer> objectInstantiations = new HashMap<>();
    private Map<String, Integer> packageAccesses = new HashMap<>();

    private boolean parsingComplete;
    private boolean parsingSuccessful;
    private Exception thrownException;

    public Parser(int maxDepth, String baseMainPath, String baseTestPath, String projectTerm, File... typeSolverPaths) {
        this.maxDepth = maxDepth;
        this.baseMainPath = baseMainPath;
        this.baseTestPath = baseTestPath;
        this.projectTerm = projectTerm;

        TYPE_SOLVER = new CombinedTypeSolver();
        PARSER_CONFIG = new ParserConfiguration().setSymbolResolver(new JavaSymbolSolver(TYPE_SOLVER));

        TYPE_SOLVER.add(new ReflectionTypeSolver(false));
        Arrays.stream(typeSolverPaths).forEach(t -> TYPE_SOLVER.add(new JavaParserTypeSolver(t, PARSER_CONFIG)));

        PARSER = JavaParserAdapter.of(new JavaParser(PARSER_CONFIG));
    }

    public Parser(int maxDepth, String baseMainPath, String baseTestPath, String projectTerm) {
        this(maxDepth, baseMainPath, baseTestPath, projectTerm,
                new File(baseMainPath).getAbsoluteFile(),
                new File(baseTestPath).getAbsoluteFile());
    }

    public Parser(String baseMainPath, String baseTestPath, String projectTerm) {
        // Defaults to at most 1000 recursions.
        this(1000, baseMainPath, baseTestPath, projectTerm,
                new File(baseMainPath).getAbsoluteFile(),
                new File(baseTestPath).getAbsoluteFile());
    }

    /**
     * Runs the parser for a method in a file.
     *
     * @param filePath File where the method is located.
     * @param methodName Name of the method to parse.
     * @return If successful, a ParsedMethod instance with all the parsed data.
     *         Returns null if an exception was thrown during parsing.
     */
    public ParsedMethod parseMethod(String filePath, String methodName) {
        reset();

        // Add to ParsedMethod
        String formattedPath = filePath.substring(filePath.indexOf("java\\") + "java\\".length()).trim();
        parsedMethod.setFilePath(formattedPath);
        parsedMethod.setMethodName(methodName);

        // Parse the Java file
        try {
            CompilationUnit cu = PARSER.parse(new File(filePath));

            // Find the method to start from
            MethodDeclaration startMethod = cu.findAll(MethodDeclaration.class)
                    .stream()
                    .filter(method -> method.getNameAsString().equals(methodName))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("ERROR: Method not found \"" + methodName + "\""));

            parseMethod(startMethod, 0);
        }
        catch (Exception e) {
            parsingSuccessful = false;
            thrownException = e;
            return null;
        }

        // Add last bits to ParsedMethod
        parsedMethod.setMethodCalls(new HashMap<>(methodCalls));
        parsedMethod.setObjectInstantiations(new HashMap<>(objectInstantiations));
        parsedMethod.setPackageAccesses(new HashMap<>(packageAccesses));

        parsingComplete = true;
        parsingSuccessful = true;

        if (debug) {
            System.out.println("\n" + sortMapOutOfPlace(methodCalls));
            System.out.println("\n" + sortMapOutOfPlace(objectInstantiations));
            System.out.println("\n" + sortMapOutOfPlace(packageAccesses));
        }

        return parsedMethod;
    }

    /**
     * Resets the parser to default values.
     */
    private void reset() {
        this.parsedMethod = new ParsedMethod();
        this.methodCalls = new HashMap<>();
        this.objectInstantiations = new HashMap<>();
        this.packageAccesses = new HashMap<>();
        parsingComplete = false;
        parsingSuccessful = false;
    }

    /**
     * Increments the value of a key inside a map by 1.
     *
     * @param map The map where the key to increment resides.
     * @param keyName Name of the key to increment.
     */
    private void incrementMapValue(Map<String, Integer> map, String keyName) {
        map.put(keyName, map.getOrDefault(keyName, 0) + 1);
    }

    /**
     * Sorts the provided map based on key.
     * Does it out of place (returns sorted map), so remember to save the return value.
     *
     * @param map The map to sort.
     * @return The sorted map.
     */
    private Map<String, Integer> sortMapOutOfPlace(Map<String, Integer> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a,b)->b, LinkedHashMap::new));
    }

    /**
     * Finds all objects instantiations within a method.
     *
     * @param methodDeclaration The method to search object instantiations in.
     */
    private void findObjectInstantiations(MethodDeclaration methodDeclaration) {
        // Loop through all object instantiations...
        List<ObjectCreationExpr> objectCreationExprList = methodDeclaration.findAll(ObjectCreationExpr.class);
        for (ObjectCreationExpr creationExpr : objectCreationExprList) {
            ResolvedConstructorDeclaration resolvedConstructorDeclaration = creationExpr.resolve();
            String classPath;
            String packageName;

            // If the object instantiation is an anonymous class, then the package name is not readily available...
            // Do some magic to get package name of the class.
            if (resolvedConstructorDeclaration.declaringType() instanceof JavaParserAnonymousClassDeclaration) {
                JavaParserAnonymousClassDeclaration anonymousClassDeclaration = (JavaParserAnonymousClassDeclaration) resolvedConstructorDeclaration.declaringType();
                classPath = anonymousClassDeclaration.getSuperTypeDeclaration().getQualifiedName();
                packageName = anonymousClassDeclaration.getSuperTypeDeclaration().getPackageName();
            }
            // Else, do it very simply.
            else {
                classPath = resolvedConstructorDeclaration.declaringType().asReferenceType().getQualifiedName();
                packageName = resolvedConstructorDeclaration.declaringType().asReferenceType().getPackageName();
            }

            // Add to object instantiation map and package accesses map.
            incrementMapValue(objectInstantiations, classPath);
            incrementMapValue(packageAccesses, packageName);
        }
    }

    /**
     * Finds all non-primitive variable declarations within a method.
     *
     * @param methodDeclaration The method to search variable declarations in.
     */
    private void findNonPrimitiveVariableDeclarations(MethodDeclaration methodDeclaration) {
        // Loop through all variable declarations...
        List<VariableDeclarator> variableDeclaratorListList = methodDeclaration.findAll(VariableDeclarator.class);
        for (VariableDeclarator variableDeclarator : variableDeclaratorListList) {

            // Check if it is a non-primitive type
            if (!(variableDeclarator.getType() instanceof PrimitiveType)) {
                ResolvedType resolvedType = variableDeclarator.getType().resolve();
                if (!resolvedType.isPrimitive()) {

                    // Skip this type if it isn't a reference type (this is done to avoid exceptions from generic variable types)
                    if (!resolvedType.isReferenceType()) continue;

                    String qualifiedName = resolvedType.asReferenceType().getQualifiedName();
                    String packageName;

                    int lastDotIndex = qualifiedName.lastIndexOf('.');
                    if (lastDotIndex != -1) {
                        packageName = qualifiedName.substring(0, lastDotIndex);
                    }
                    else {
                        packageName = ""; // No package name (can it even happen?), return empty string
                    }

                    incrementMapValue(packageAccesses, packageName);
                }
            }
        }
    }

    /**
     * Parses a MethodDeclaration. Collects all parsed data and stores it in a ParsedMethod instance.
     *
     * @param methodDeclaration The method to parse.
     * @param depth The current depth of the parsing, since this method can be used recursively.
     *              Will not exceed MAX_DEPTH.
     */
    private void parseMethod(MethodDeclaration methodDeclaration, int depth) {
        if (depth >= maxDepth) {
            System.out.println("MAXIMUM DEPTH REACHED FOR METHOD \"" + methodDeclaration.getNameAsString() + "\"");
            throw new IllegalArgumentException("Depth exceeded max value.");
        }

        MethodFeatureExtractor methodFeatureExtractor = new MethodFeatureExtractor(methodDeclaration);

        if (depth == 0) { // is JUnit test if depth is 0
            parsedMethod.incrementLinesOfCodeJunitTest(methodFeatureExtractor.countLinesOfCode());
            parsedMethod.incrementLogicalLinesOfCodeJunitTest(methodFeatureExtractor.countLogicalLinesOfCode());
        }

        findObjectInstantiations(methodDeclaration);                // Find any object instantiations inside the method
        findNonPrimitiveVariableDeclarations(methodDeclaration);    // Find any non-primitive variable declarations inside the method (used for package accesses)

        // Count stats of method
        parsedMethod.incrementNumConditionals(methodFeatureExtractor.countConditionals());
        parsedMethod.incrementNumLoops(methodFeatureExtractor.countLoops());
        parsedMethod.incrementNumNestedLoops(methodFeatureExtractor.countNestedLoops());
        parsedMethod.incrementLinesOfCode(methodFeatureExtractor.countLinesOfCode());
        parsedMethod.incrementLogicalLinesOfCode(methodFeatureExtractor.countLogicalLinesOfCode());

        // Loop through all method calls in the provided methodDeclaration variable.
        List<MethodCallExpr> methodCallExprList = methodDeclaration.findAll(MethodCallExpr.class);
        parsedMethod.incrementNumMethodCalls(methodCallExprList.size());  // Add stat to parsed method
        for (MethodCallExpr callExpr : methodCallExprList) {
            boolean javaLibFile = false;

            ResolvedMethodDeclaration resolvedMethodDeclaration = null;
            try {
                resolvedMethodDeclaration = callExpr.resolve();
            }
            catch (NoClassDefFoundError | Exception e) {
                continue;
            }


            MethodDeclaration calledMethodDeclaration = null;
            // If method call is from source code, we can get its method declaration directly.
            if (resolvedMethodDeclaration instanceof JavaParserMethodDeclaration) {
                JavaParserMethodDeclaration javaParserMethodDeclaration = (JavaParserMethodDeclaration) resolvedMethodDeclaration;
                calledMethodDeclaration = javaParserMethodDeclaration.getWrappedNode();
            }

            // If the method call is from a library (such as JRE), we cannot get its method declaration directly.
            // We need to jump through some hoops...
            else if (resolvedMethodDeclaration instanceof ReflectionMethodDeclaration) {
                ReflectionMethodDeclaration reflectionMethodDeclaration = (ReflectionMethodDeclaration) resolvedMethodDeclaration;

                // Check if the called method is located in a RxJava package.
                // If true, get full path for the class that holds the called method. Then create a new compilation unit that parses that path.
                // The parser finds and provides us the method declaration for the called method.
                if (reflectionMethodDeclaration.toString().contains(projectTerm) && !projectTerm.equals("")) {
                    String packageName = reflectionMethodDeclaration.getPackageName();
                    String className = reflectionMethodDeclaration.getClassName();

                    // If there are dots in the class name, assume the last part is the nested class name and ignore it for the path
                    String[] classNameParts = className.split("\\.");
                    if (classNameParts.length > 1) {
                        className = classNameParts[0]; // Use only the top-level class name
                    }

                    String classPath = (packageName + "." + className).replace(".", "\\");
                    String fullPath = baseMainPath + classPath + ".java";
                    CompilationUnit methodCu = null;
                    try {
                        methodCu = PARSER.parse(new File(fullPath).getAbsoluteFile());
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                    calledMethodDeclaration = methodCu
                            .findAll(MethodDeclaration.class)
                            .stream()
                            .filter(m -> m.getNameAsString()
                                    .equals(reflectionMethodDeclaration.getName()))
                            .findFirst()
                            .get();
                }

                // If not true, then called method is probably from a file in some java library.
                else {
                    javaLibFile = true;
                }
            }

            // Add method call and package access to respective map.
            incrementMapValue(methodCalls, resolvedMethodDeclaration.getQualifiedName());
            incrementMapValue(packageAccesses, resolvedMethodDeclaration.getPackageName());

            // Continue finding method calls recursively if the called method is not from a java library.
            if (!javaLibFile) {
                if (debug) System.out.println("METHOD INVOCATION: " + resolvedMethodDeclaration.getQualifiedName());
                parsedMethod.incrementNumRecursiveMethodCalls(1); // increase non java lib method call stats
                parseMethod(calledMethodDeclaration, depth + 1);
            }
            else {
                if (debug) System.out.println("JAVA LIB FILE (STOPPING RECURSION): " + resolvedMethodDeclaration.getQualifiedName());
            }

            // Separate each recursion section, so it is easier to distinguish and read the debug print.
            if (debug && depth == 0) System.out.println();
        }
    }

    public ParsedMethod getParsedMethod() {
        if (!parsingComplete) {
            if (!parsingSuccessful) throw new IllegalStateException("ERROR: The parsing failed and threw and exception! Exception: " + thrownException.getMessage());
            else throw new IllegalStateException("ERROR: The parsing has not been performed or is not complete yet!");
        }
        return parsedMethod;
    }

    public void printException() {
        if (thrownException == null) {
            System.out.println("No exception has been thrown!");
            return;
        }

        for (StackTraceElement stackTraceElement : thrownException.getStackTrace()) {
            System.out.println(stackTraceElement.toString());
        }
    }
}
