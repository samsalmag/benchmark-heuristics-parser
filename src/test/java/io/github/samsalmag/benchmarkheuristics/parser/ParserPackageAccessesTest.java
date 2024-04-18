package io.github.samsalmag.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserPackageAccessesTest {

    private static Parser parser;
    private static String stubPath;

    @BeforeAll
    public static void init() {
        parser = new Parser(Integer.MAX_VALUE,
                "src\\main\\java\\",
                "src\\test\\java\\",
                Arrays.asList(""),
                Arrays.asList(
                        new File("src\\main\\java"),
                        new File("src\\test\\java")),
                null);

        File stub = new File("src/test/java/io/github/samsalmag/benchmarkheuristics/parser/stubs/PackageAccessesStub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void packageAccessesTest_shouldBeZeroUniqueAndZeroTotal() {
        String methodName = "empty";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 0;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 0;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeOneUniqueAndOneTotal_1() {
        String methodName = "oneAccesses_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 1;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 1;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeOneUniqueAndOneTotal_2() {
        String methodName = "oneAccesses_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 1;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 1;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeOneUniqueAndTwoTotal_1() {
        String methodName = "twoAccesses_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 1;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 2;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeOneUniqueAndTwoTotal_2() {
        String methodName = "twoAccesses_4";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 1;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 2;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeTwoUniqueAndTwoTotal_1() {
        String methodName = "twoAccesses_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 2;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 2;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeTwoUniqueAndTwoTotal_2() {
        String methodName = "twoAccesses_3";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 2;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 2;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeOneUniqueAndThreeTotal() {
        String methodName = "threeAccesses_3";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 1;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 3;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeTwoUniqueAndThreeTotal_1() {
        String methodName = "threeAccesses_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 2;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 3;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeTwoUniqueAndThreeTotal_2() {
        String methodName = "threeAccesses_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 2;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 3;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeOneUniqueAndFourTotal() {
        String methodName = "fourAccesses_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 1;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 4;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeTwoUniqueAndFourTotal() {
        String methodName = "fourAccesses_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 2;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 4;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeFourUniqueAndFourTotal() {
        String methodName = "fourAccesses_3";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 4;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 4;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeOneUniqueAndFiveTotal() {
        String methodName = "fiveAccesses_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 1;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 5;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }

    @Test
    public void packageAccessesTest_shouldBeThreeUniqueAndFiveTotal() {
        String methodName = "fiveAccesses_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> packageAccesses = parser.getParsedMethod().getPackageAccesses();

        int expectedUniqueAccesses = 3;
        int actualUniqueAccesses = packageAccesses.keySet().size();
        assertEquals(expectedUniqueAccesses, actualUniqueAccesses);

        int expectedTotalAccesses = 5;
        int actualTotalAccesses = packageAccesses.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalAccesses, actualTotalAccesses);
    }
}
