package io.github.samsalmag.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserObjectInstantiationsTest {

    private static Parser parser;
    private static String stubPath;

    @BeforeAll
    public static void init() {
        parser = new Parser(Integer.MAX_VALUE,
                "src\\main\\java\\",
                "src\\test\\java\\",
                "",
                new File("src\\main\\java"),
                new File("src\\test\\java"));

        File stub = new File("src/test/java/io/github/samsalmag/benchmarkheuristics/parser/stubs/ObjectInstantiationsStub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void objectInstantiationsTest_shouldBeZeroUniqueAndZeroTotal() {
        String methodName = "empty";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 0;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 0;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeOneUniqueAndOneTotal_1() {
        String methodName = "oneInst_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 1;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 1;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeOneUniqueAndOneTotal_2() {
        String methodName = "oneInst_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 1;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 1;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeOneUniqueAndOneTotal_3() {
        String methodName = "oneInst_3";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 1;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 1;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeOneUniqueAndTwoTotal_1() {
        String methodName = "twoInst_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 1;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 2;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeOneUniqueAndTwoTotal_2() {
        String methodName = "twoInst_5";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 1;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 2;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeTwoUniqueAndTwoTotal_1() {
        String methodName = "twoInst_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 2;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 2;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeTwoUniqueAndTwoTotal_2() {
        String methodName = "twoInst_3";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 2;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 2;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeTwoUniqueAndTwoTotal_3() {
        String methodName = "twoInst_4";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 2;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 2;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeTwoUniqueAndThreeTotal() {
        String methodName = "threeInst_2";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 2;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 3;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeThreeUniqueAndThreeTotal_1() {
        String methodName = "threeInst_1";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 3;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 3;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }

    @Test
    public void objectInstantiationsTest_shouldBeThreeUniqueAndThreeTotal_2() {
        String methodName = "threeInst_3";
        parser.parseMethod(stubPath, methodName);

        Map<String, Integer> objectInstantiations = parser.getParsedMethod().getObjectInstantiations();

        int expectedUniqueInstantiations = 3;
        int actualUniqueInstantiations = objectInstantiations.keySet().size();
        assertEquals(expectedUniqueInstantiations, actualUniqueInstantiations);

        int expectedTotalInstantiations = 3;
        int actualTotalInstantiations = objectInstantiations.values().stream().mapToInt(Integer::intValue).sum();
        assertEquals(expectedTotalInstantiations, actualTotalInstantiations);
    }
}
