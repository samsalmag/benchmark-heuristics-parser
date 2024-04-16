package io.github.samsalmag.benchmarkheuristics.parser;

import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.Node;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Counts the code features of a method.
 *
 * @author Malte Åkvist
 */
public class MethodFeatureExtractor {

    private final MethodDeclaration methodDeclaration;

    public MethodFeatureExtractor(MethodDeclaration methodDeclaration) {
        this.methodDeclaration = methodDeclaration;
    }

    /**
     * Counts conditionals in the method.
     *
     * @return Number of conditionals.
     */
    public int countConditionals() {
        int ifCount = methodDeclaration.findAll(IfStmt.class).size(); // Count if and else if statements

        // Count switch case statements, excludes default case
        int switchCaseCount = methodDeclaration.findAll(SwitchStmt.class).stream()
                .flatMap(switchStmt -> switchStmt.getEntries().stream())
                .filter(switchEntry -> switchEntry.getLabels().isNonEmpty()) // Filter out default cases
                .mapToInt(switchEntry -> 1)
                .sum();

        return ifCount + switchCaseCount;
    }

    /**
     * Counts loops in the method.
     *
     * @return Number of loops.
     */
    public int countLoops() {
        List<Node> loops = methodDeclaration.findAll(Node.class, n ->
                n instanceof ForStmt || n instanceof ForEachStmt || n instanceof WhileStmt || n instanceof DoStmt);
        return loops.size();
    }

    /**
     * Counts nested loops in the method.
     *
     * @return Number of nested loops.
     */
    public int countNestedLoops() {
        int depth = calculateDepth(methodDeclaration, 0);
        return (depth > 0) ? depth - 1 : 0;
    }

    /**
     * Counts lines of code in the method.
     *
     * @return Lines of code.
     */
    public int countLinesOfCode() {
        int lines = 0;
        if (methodDeclaration.getBegin().isPresent()) {
            int startLine = methodDeclaration.getBegin().get().line;
            int endLine = methodDeclaration.getEnd().get().line;

            if (startLine != endLine) {
                BlockStmt body = methodDeclaration.getBody().orElse(null);
                if (body == null) return 0;
                String[] bodyLines = body.toString().split("\\r?\\n");

                boolean insideMultilineComment = false;
                for (String bodyLine : bodyLines) {

                    // Check if row begins and ends multiline comment. Don't count.
                    if (containsStartMultilineComment(bodyLine) && containsEndMultilineComment(bodyLine)) continue;
                    // Checks if row starts a multiline comment. Don't count.
                    else if (containsStartMultilineComment(bodyLine)) {
                        insideMultilineComment = true;
                        continue;
                    }
                    // Checks if row ends a multiline comment. Don't count.
                    else if (containsEndMultilineComment(bodyLine)) {
                        insideMultilineComment = false;
                        continue;
                    }

                    // Skip row if inside a multiline comment
                    if (insideMultilineComment) continue;

                    // Don't count:
                    // * If method body is empty
                    // * If row only contains a '{'
                    // * If row only contains a '}'
                    // * If row contains single line comment
                    if (bodyLine.trim().isEmpty() ||
                        bodyLine.trim().equals("{") ||
                        bodyLine.trim().equals("}") ||
                        containsSingleComment(bodyLine)) continue;

                    // All checks passed, is a regular row. Count it.
                    lines++;
                }
            }
        }
        return lines;
    }

    /**
     * Counts logical lines of code in the method.
     *
     * @return Logical lines of code.
     */
    public int countLogicalLinesOfCode() {
        if (!methodDeclaration.getBody().isPresent()) {
               return 0;
            }
        BlockStmt body = methodDeclaration.getBody().get();
        return countStatementsInBlock(body);
    }

    // Counts depth of nested loops in a method
    private int calculateDepth(Node node, int depth) {
        int maxDepth = depth;
        for (Node child : node.getChildNodes()) {
            int childDepth;
            if (child instanceof ForStmt || child instanceof ForEachStmt || child instanceof WhileStmt || child instanceof DoStmt) {
                childDepth = calculateDepth(child, depth + 1);
            } else {
                childDepth = calculateDepth(child, depth);
            }
            maxDepth = Math.max(maxDepth, childDepth);
        }
        return maxDepth;
    }

    private int countStatementsInBlock(Node node) {
        int count = 0;
        for (Node child : node.getChildNodes()) {
                if (child instanceof com.github.javaparser.ast.stmt.Statement) {
                        count++;
                    }
                count += countStatementsInBlock(child);
            }
        return count;
    }

    private boolean containsStartMultilineComment(String line) {
        String regex = "((.*\\/\\*.*))";
        return Pattern.matches(regex, line.trim());
    }

    private boolean containsEndMultilineComment(String line) {
        String regex = "((.*\\*\\/.*))";
        return Pattern.matches(regex, line.trim());
    }

    private boolean containsSingleComment(String line) {
        String regex = "(//.*$)";
        return Pattern.matches(regex, line.trim());
    }
}
