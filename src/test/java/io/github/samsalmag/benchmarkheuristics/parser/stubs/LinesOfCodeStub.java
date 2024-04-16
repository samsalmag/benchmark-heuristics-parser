package io.github.samsalmag.benchmarkheuristics.parser.stubs;

import java.util.Collections;
import java.util.List;

public class LinesOfCodeStub {

    public void empty() { }

    public void zeroLOC_1() {
        // Comment
    }

    public void zeroLOC_2() {
        // Comment
        // Comment
    }

    public void zeroLOC_3() {
        /*
        Comment
         */
    }

    public void zeroLOC_4() {
        /*

        Comment

         */

        /* Comment      */

        // Comment
    }

    public void oneLOC_1() {
        empty();
    }

    public void oneLOC_2() {
        // Comment
        empty();
    }

    public void oneLOC_3() {
        /* Comment
         */

        empty();
    }

    public void oneLOC_4() {
        /*

        Comment

         */


        // Comment


        empty();
    }

    public void oneLOC_5() {
        // Each statement counts as one line, even if the line is split into multiple lines

        Collections.sort(
                null
        );

    }

    public void twoLOC_1() {
        Collections.sort(null);
        empty();
    }

    public void twoLOC_2() {



        Collections.sort(null);


        empty();


        // Comment
    }

    public void twoLOC_3() {
        // Each statement counts as one line, even if the line is split into multiple lines

        Collections.sort(
                null);

        /* Comment */

        empty();
    }

    public void threeLOC_1() {

        // Comment
        // Comment
        int i = 0;
        empty();
        String string = new String();

        // Comment
    }

    public void threeLOC_2() {
        /* Comment */

        /*


         */

        String string =
                new String();
        int
                i = 0;
        string.
                length();
    }

    public void twelveLOC_1() {
        // 6 LOC inside methods below
        // PLUS 6 LOC inside this method
        threeLOC_1();
        threeLOC_2();

        int i
                = 0;
        empty();

        /* Comment
         */


        empty();

        String string =
                new
                        String();

        // */  /*

        /*
         //
         /*
         */

    }

    public void twelveLOC_2() {
        // 9 LOC inside methods below
        // PLUS 3 LOC inside this method

        threeLOC_1();
        threeLOC_2();
        threeLOC_1();

        /*

        Comment */


    }

    public void thirtyEightLOC() {
        // 32 LOC inside methods below
        // PLUS 6 LOC inside this method

        // Comment

        twelveLOC_1();
        twelveLOC_2();

        /*

        Comment
         */
        // Comment

        threeLOC_1();
        List<String> list;
        threeLOC_2();
        // Comment
        twoLOC_2();


        /*



         */

    }
}
