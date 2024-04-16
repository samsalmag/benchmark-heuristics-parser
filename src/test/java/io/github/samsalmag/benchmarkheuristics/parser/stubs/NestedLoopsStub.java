package io.github.samsalmag.benchmarkheuristics.parser.stubs;

public class NestedLoopsStub {

    public void empty() { }

    // region For

    public void oneNestedLoop_for_1() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) { }
        }
    }

    public void oneNestedLoop_for_2() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) { }

            for (int j = 0; j < 1; j++) { }
        }
    }

    public void twoNestedLoop_for_1() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 1; k++) { }
            }
        }
    }

    public void twoNestedLoop_for_2() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 1; k++) { }

                for (int k = 0; k < 1; k++) { }
            }
        }
    }

    public void threeNestedLoop_for_1() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 1; k++) {
                    for (int l = 0; l < 1; l++) { }
                }
            }
        }
    }

    public void threeNestedLoop_for_2() {
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 1; k++) {
                    for (int l = 0; l < 1; l++) { }

                    for (int l = 0; l < 1; l++) { }
                }
            }
        }
    }

    // endregion For

    // region For-each

    public void oneNestedLoop_foreach_1() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) { }
        }
    }

    public void oneNestedLoop_foreach_2() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) { }

            for (int j : new int[]{}) { }
        }
    }

    public void twoNestedLoop_foreach_1() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) {
                for (int k : new int[]{}) { }
            }
        }
    }

    public void twoNestedLoop_foreach_2() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) {
                for (int k : new int[]{}) { }

                for (int k : new int[]{}) { }
            }
        }
    }

    public void threeNestedLoop_foreach_1() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) {
                for (int k : new int[]{}) {
                    for (int l : new int[]{}) { }
                }
            }
        }
    }

    public void threeNestedLoop_foreach_2() {
        for (int i : new int[]{}) {
            for (int j : new int[]{}) {
                for (int k : new int[]{}) {
                    for (int l : new int[]{}) { }

                    for (int l : new int[]{}) { }
                }
            }
        }
    }

    // endregion For-each

    // region While

    public void oneNestedLoop_while_1() {
        while (true) {
            while (true) { }
        }
    }

    public void oneNestedLoop_while_2() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        while (true) {
            while (bool) { }

            while (bool) { }
        }
    }

    public void twoNestedLoop_while_1() {
        while (true) {
            while (true) {
                while (true) { }
            }
        }
    }

    public void twoNestedLoop_while_2() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        while (true) {
            while (true) {
                while (bool) { }

                while (bool) { }
            }
        }
    }

    public void threeNestedLoop_while_1() {
        while (true) {
            while (true) {
                while (true) {
                    while (true) { }
                }
            }
        }
    }

    public void threeNestedLoop_while_2() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        while (true) {
            while (true) {
                while (true) {
                    while (bool) { }

                    while (bool) { }
                }
            }
        }
    }

    // endregion While

    // region Do-while

    public void oneNestedLoop_dowhile_1() {
        do {
            do { } while (true);
        } while (true);
    }

    public void oneNestedLoop_dowhile_2() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        do {
            do { } while (bool);

            do { } while (bool);
        } while (true);
    }

    public void twoNestedLoop_dowhile_1() {
        do {
            do {
                do { } while (true);
            } while (true);
        } while (true);
    }

    public void twoNestedLoop_dowhile_2() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        do {
            do {
                do { } while (bool);

                do { } while (bool);
            } while (true);
        } while (true);
    }

    public void threeNestedLoop_dowhile_1() {
        do {
            do {
                do {
                    do { } while (true);
                } while (true);
            } while (true);
        } while (true);
    }

    public void threeNestedLoop_dowhile_2() {
        // Compile error if 'true' or 'false' is used directly in while-statement, because code becomes unreachable.
        // Use variable to avoid error.
        boolean bool = true;

        do {
            do {
                do {
                    do { } while (bool);

                    do { } while (bool);
                } while (true);
            } while (true);
        } while (true);
    }

    // endregion Do-while
}
