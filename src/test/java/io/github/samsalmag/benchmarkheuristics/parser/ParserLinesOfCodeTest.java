package io.github.samsalmag.benchmarkheuristics.parser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserLinesOfCodeTest {

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

        File stub = new File("src/test/java/io/github/samsalmag/benchmarkheuristics/parser/stubs/LinesOfCodeStub.java");
        stubPath = stub.getAbsolutePath();
    }

    @Test
    public void numLinesOfCodeTest_shouldBeZero_1() {
        String methodName = "empty";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeZero_2() {
        String methodName = "zeroLOC_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeZero_3() {
        String methodName = "zeroLOC_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeZero_4() {
        String methodName = "zeroLOC_3";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeZero_5() {
        String methodName = "zeroLOC_4";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 0;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeOne_1() {
        String methodName = "oneLOC_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeOne_2() {
        String methodName = "oneLOC_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeOne_3() {
        String methodName = "oneLOC_3";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeOne_4() {
        String methodName = "oneLOC_4";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeOne_5() {
        String methodName = "oneLOC_5";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 1;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeTwo_1() {
        String methodName = "twoLOC_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeTwo_2() {
        String methodName = "twoLOC_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeTwo_3() {
        String methodName = "twoLOC_3";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 2;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeThree_1() {
        String methodName = "threeLOC_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeThree_2() {
        String methodName = "threeLOC_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 3;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeTwelve_1() {
        String methodName = "twelveLOC_1";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 12;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeTwelve_2() {
        String methodName = "twelveLOC_2";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 12;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void numLinesOfCodeTest_shouldBeThirtyEight() {
        String methodName = "thirtyEightLOC";
        parser.parseMethod(stubPath, methodName);

        int expectedValue = 38;
        int actualValue = parser.getParsedMethod().getLinesOfCode();

        assertEquals(expectedValue, actualValue);
    }
}
