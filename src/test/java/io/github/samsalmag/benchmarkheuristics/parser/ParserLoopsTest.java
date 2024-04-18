package io.github.samsalmag.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserLoopsTest {

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

        File stub = new File("src/test/java/io/github/samsalmag/benchmarkheuristics/parser/stubs/LoopsStub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void numLoopsTest_shouldBeZero() {
        String methodName = "empty";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_for_shouldBeOne() {
        String methodName = "oneLoop_for";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_for_shouldBeTwo_1() {
        String methodName = "twoLoop_for_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_for_shouldBeTwo_2() {
        String methodName = "twoLoop_for_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_for_shouldBeThree_1() {
        String methodName = "threeLoop_for_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_for_shouldBeThree_2() {
        String methodName = "threeLoop_for_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_for_shouldBeFour_1() {
        String methodName = "fourLoop_for_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_for_shouldBeFour_2() {
        String methodName = "fourLoop_for_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_foreach_shouldBeOne() {
        String methodName = "oneLoop_foreach";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_foreach_shouldBeTwo_1() {
        String methodName = "twoLoop_foreach_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_foreach_shouldBeTwo_2() {
        String methodName = "twoLoop_foreach_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_foreach_shouldBeThree_1() {
        String methodName = "threeLoop_foreach_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_foreach_shouldBeThree_2() {
        String methodName = "threeLoop_foreach_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_foreach_shouldBeFour_1() {
        String methodName = "fourLoop_foreach_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_foreach_shouldBeFour_2() {
        String methodName = "fourLoop_foreach_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_while_shouldBeOne() {
        String methodName = "oneLoop_while";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_while_shouldBeTwo_1() {
        String methodName = "twoLoop_while_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_while_shouldBeTwo_2() {
        String methodName = "twoLoop_while_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_while_shouldBeThree_1() {
        String methodName = "threeLoop_while_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_while_shouldBeThree_2() {
        String methodName = "threeLoop_while_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_while_shouldBeFour_1() {
        String methodName = "fourLoop_while_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_while_shouldBeFour_2() {
        String methodName = "fourLoop_while_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_dowhile_shouldBeOne() {
        String methodName = "oneLoop_dowhile";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_dowhile_shouldBeTwo_1() {
        String methodName = "twoLoop_dowhile_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_dowhile_shouldBeTwo_2() {
        String methodName = "twoLoop_dowhile_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_dowhile_shouldBeThree_1() {
        String methodName = "threeLoop_dowhile_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_dowhile_shouldBeThree_2() {
        String methodName = "threeLoop_dowhile_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_dowhile_shouldBeFour_1() {
        String methodName = "fourLoop_dowhile_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLoopsTest_dowhile_shouldBeFour_2() {
        String methodName = "fourLoop_dowhile_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 4;
        int actualValue = parser.getParsedMethod().getNumLoops();

        assertEquals(expectedValue, actualValue);
    }
}
