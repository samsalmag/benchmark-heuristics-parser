package io.github.samsalmag.benchmarkheuristics.parser.stubs;

public class LoopsStub {

    public void empty() { }

    // region For

    public void oneLoop_for() {
        for (int i = 0; i < 1; i++) { }
    }

    public void twoLoop_for_1() {
        for (int i = 0; i < 1; i++) { }

        for (int j = 0; j < 1; j++) { }
    }

    public void twoLoop_for_2() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) { }
        }
    }

    public void threeLoop_for_1() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) { }

            for (int j = 0; j < 1; j++) { }
        }
    }

    public void threeLoop_for_2() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 1; k++) { }
            }
        }
    }

    public void fourLoop_for_1() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) { }

            for (int j = 0; j < 1; j++) { }

            for (int j = 0; j < 1; j++) { }
        }
    }

    public void fourLoop_for_2() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 1; k++) {
                    for (int l = 0; l < 1; l++) { }
                }
            }
        }
    }

    // endregion For

    // region For-each

    public void oneLoop_foreach() {
        for (int i : new int[]{}) { }
    }

    public void twoLoop_foreach_1() {
        for (int i : new int[]{}) { }

        for (int i : new int[]{}) { }
    }

    public void twoLoop_foreach_2() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) { }
        }
    }

    public void threeLoop_foreach_1() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) { }

            for (int j : new int[]{}) { }
        }
    }

    public void threeLoop_foreach_2() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) {
                for (int k : new int[]{}) { }
            }
        }
    }

    public void fourLoop_foreach_1() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) { }

            for (int j : new int[]{}) { }

            for (int j : new int[]{}) { }
        }
    }

    public void fourLoop_foreach_2() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) {
                for (int k : new int[]{}) {
                    for (int l : new int[]{}) { }
                }
            }
        }
    }

    // endregion For-each

    // region While

    public void oneLoop_while() {
        while (true) { }
    }

    public void twoLoop_while_1() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        while (bool) { }

        while (bool) { }
    }

    public void twoLoop_while_2() {
        while (true) {
            while (true) { }
        }
    }

    public void threeLoop_while_1() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        while (true) {
            while (bool) { }

            while (bool) { }
        }
    }

    public void threeLoop_while_2() {
        while (true) {
            while (true) {
                while (true) { }
            }
        }
    }

    public void fourLoop_while_1() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        while (true) {
            while (bool) { }

            while (bool) { }

            while (bool) { }
        }
    }

    public void fourLoop_while_2() {
        while (true) {
            while (true) {
                while (true) {
                    while (true) { }
                }
            }
        }
    }

    // endregion While

    // region Do-while

    public void oneLoop_dowhile() {
        do { } while (true);
    }

    public void twoLoop_dowhile_1() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        do { } while (bool);

        do { } while (bool);
    }

    public void twoLoop_dowhile_2() {
        do {
            do { } while (true);
        } while (true);
    }

    public void threeLoop_dowhile_1() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        do {
            do { } while (bool);

            do { } while (bool);
        } while (true);
    }

    public void threeLoop_dowhile_2() {
        do {
            do {
                do { } while (true);
            } while (true);
        } while (true);
    }

    public void fourLoop_dowhile_1() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        do {
            do { } while (bool);

            do { } while (bool);

            do { } while (bool);
        } while (true);
    }

    public void fourLoop_dowhile_2() {
        do {
            do {
                do {
                    do { } while (true);
                } while (true);
            } while (true);
        } while (true);
    }

    // endregion Do-while
}
