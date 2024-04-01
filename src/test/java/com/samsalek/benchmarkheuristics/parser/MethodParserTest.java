package com.samsalek.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MethodParserTest {

    private static MethodParser parser;
    private static String stubPath;

    @BeforeAll
    public static void init() {
        parser = new MethodParser(Integer.MAX_VALUE, "src\\main\\java\\", "src\\test\\java\\", "",
                new File("src\\main\\java"),
                new File("src\\test\\java"));

        File stub = new File("src/test/java/com/samsalek/benchmarkheuristics/parser/Stub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void numLoopsTest_shouldBeZero() {
        String methodName = "empty";
        parser.parse(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_shouldBeOne() {
        String methodName = "oneLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_shouldBeTwo_1() {
        String methodName = "twoLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_shouldBeTwo_2() {
        String methodName = "twoLoop_oneNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_shouldBeThree_1() {
        String methodName = "threeLoop_oneNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_shouldBeThree_2() {
        String methodName = "threeLoop_twoNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_shouldBeFour_1() {
        String methodName = "fourLoop_oneNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_shouldBeFour_2() {
        String methodName = "fourLoop_threeNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_shouldBeOne_1() {
        String methodName = "twoLoop_oneNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_shouldBeOne_2() {
        String methodName = "threeLoop_oneNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_shouldBeOne_3() {
        String methodName = "fourLoop_oneNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_shouldBeTwo() {
        String methodName = "threeLoop_twoNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_shouldBeThree() {
        String methodName = "fourLoop_threeNestedLoop";
        parser.parse(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeOne() {
        String methodName = "oneMethodCall";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeTwo() {
        String methodName = "twoMethodCall";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeThree() {
        String methodName = "threeMethodCall";
        parser.parse(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeFour() {
        String methodName = "fourMethodCall";
        parser.parse(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeEight() {
        String methodName = "eightMethodCall";
        parser.parse(stubPath, methodName);

        int expectedValue = 8;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeNine() {
        String methodName = "nineMethodCall";
        parser.parse(stubPath, methodName);

        int expectedValue = 9;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeThirty() {
        String methodName = "thirtyMethodCall";
        parser.parse(stubPath, methodName);

        int expectedValue = 30;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeOne_1() {
        String methodName = "oneIf_1";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeOne_2() {
        String methodName = "oneIf_2";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeOne_3() {
        String methodName = "oneSwitchCase";
        parser.parse(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeTwo_1() {
        String methodName = "twoIf_1";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeTwo_2() {
        String methodName = "twoIf_2";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeTwo_3() {
        String methodName = "twoIf_3";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeTwo_4() {
        String methodName = "twoSwitchCase";
        parser.parse(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeThree_1() {
        String methodName = "threeIf_1";
        parser.parse(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeThree_2() {
        String methodName = "threeIf_2";
        parser.parse(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_shouldBeThree_3() {
        String methodName = "threeSwitchCase";
        parser.parse(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }
}
