package io.github.samsalmag.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserNestedLoopsTest {

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

        File stub = new File("src/test/java/io/github/samsalmag/benchmarkheuristics/parser/stubs/NestedLoopsStub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void numNestedLoopsTest_shouldBeZero() {
        String methodName = "empty";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_for_shouldBeOne_1() {
        String methodName = "oneNestedLoop_for_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_for_shouldBeOne_2() {
        String methodName = "oneNestedLoop_for_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_for_shouldBeTwo_1() {
        String methodName = "twoNestedLoop_for_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_for_shouldBeTwo_2() {
        String methodName = "twoNestedLoop_for_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_for_shouldBeThree_1() {
        String methodName = "threeNestedLoop_for_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_for_shouldBeThree_2() {
        String methodName = "threeNestedLoop_for_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_foreach_shouldBeOne_1() {
        String methodName = "oneNestedLoop_foreach_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_foreach_shouldBeOne_2() {
        String methodName = "oneNestedLoop_foreach_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_foreach_shouldBeTwo_1() {
        String methodName = "twoNestedLoop_foreach_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_foreach_shouldBeTwo_2() {
        String methodName = "twoNestedLoop_foreach_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_foreach_shouldBeThree_1() {
        String methodName = "threeNestedLoop_foreach_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_foreach_shouldBeThree_2() {
        String methodName = "threeNestedLoop_foreach_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_while_shouldBeOne_1() {
        String methodName = "oneNestedLoop_while_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_while_shouldBeOne_2() {
        String methodName = "oneNestedLoop_while_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_while_shouldBeTwo_1() {
        String methodName = "twoNestedLoop_while_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_while_shouldBeTwo_2() {
        String methodName = "twoNestedLoop_while_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_while_shouldBeThree_1() {
        String methodName = "threeNestedLoop_while_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_while_shouldBeThree_2() {
        String methodName = "threeNestedLoop_while_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_dowhile_shouldBeOne_1() {
        String methodName = "oneNestedLoop_dowhile_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_dowhile_shouldBeOne_2() {
        String methodName = "oneNestedLoop_dowhile_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_dowhile_shouldBeTwo_1() {
        String methodName = "twoNestedLoop_dowhile_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_dowhile_shouldBeTwo_2() {
        String methodName = "twoNestedLoop_dowhile_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_dowhile_shouldBeThree_1() {
        String methodName = "threeNestedLoop_dowhile_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numNestedLoopsTest_dowhile_shouldBeThree_2() {
        String methodName = "threeNestedLoop_dowhile_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumNestedLoops();

        assertEquals(expectedValue, actualValue);
    }
}
