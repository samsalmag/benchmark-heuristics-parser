package io.github.samsalmag.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserMethodCallsTest {

    private static Parser parser;
    private static String stubPath;

    @BeforeAll
    public static void init() {
        parser = new Parser(Integer.MAX_VALUE,
                "src\\main\\java\\",
                "src\\test\\java\\",
                "testing",
                new File("src\\main\\java"),
                new File("src\\test\\java"));

        File stub = new File("src/test/java/io/github/samsalmag/benchmarkheuristics/parser/stubs/MethodCallsStub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void numMethodCallsTest_shouldBeZero() {
        String methodName = "empty";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeOne_1() {
        String methodName = "oneMethodCall_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeOne_2() {
        String methodName = "oneMethodCall_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeTwo_1() {
        String methodName = "twoMethodCall_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeTwo_2() {
        String methodName = "twoMethodCall_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeThree_1() {
        String methodName = "threeMethodCall_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeThree_2() {
        String methodName = "threeMethodCall_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeFour() {
        String methodName = "fourMethodCall";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeEight() {
        String methodName = "eightMethodCall";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 8;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeNine() {
        String methodName = "nineMethodCall";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 9;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeSixteen() {
        String methodName = "sixteenMethodCall";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 16;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numMethodCallsTest_shouldBeThirty() {
        String methodName = "thirtyMethodCall";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 30;
        int actualValue = parser.getParsedMethod().getNumMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numRecursiveMethodCallsTest_shouldBeZero() {
        String methodName = "oneMethodCall_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getNumRecursiveMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numRecursiveMethodCallsTest_shouldBeOne() {
        String methodName = "twoMethodCall_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumRecursiveMethodCalls();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numRecursiveMethodCallsTest_shouldBeEleven() {
        String methodName = "sixteenMethodCall";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 11;
        int actualValue = parser.getParsedMethod().getNumRecursiveMethodCalls();

        assertEquals(expectedValue, actualValue);
    }
}
