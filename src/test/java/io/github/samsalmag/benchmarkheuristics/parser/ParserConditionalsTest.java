package io.github.samsalmag.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserConditionalsTest {

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

        File stub = new File("src/test/java/io/github/samsalmag/benchmarkheuristics/parser/stubs/ConditionalsStub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void numConditionalsTest_shouldBeZero() {
        String methodName = "empty";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_if_shouldBeOne_1() {
        String methodName = "oneIf_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_if_shouldBeOne_2() {
        String methodName = "oneIf_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_if_shouldBeTwo_1() {
        String methodName = "twoIf_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_if_shouldBeTwo_2() {
        String methodName = "twoIf_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_if_shouldBeTwo_3() {
        String methodName = "twoIf_3";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_if_shouldBeThree_1() {
        String methodName = "threeIf_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_if_shouldBeThree_2() {
        String methodName = "threeIf_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_switch_shouldBeOne_3() {
        String methodName = "oneSwitchCase";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_switch_shouldBeTwo_4() {
        String methodName = "twoSwitchCase";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numConditionalsTest_switch_shouldBeThree_3() {
        String methodName = "threeSwitchCase";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumConditionals();

        assertEquals(expectedValue, actualValue);
    }
}
