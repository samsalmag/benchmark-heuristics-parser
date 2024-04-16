package io.github.samsalmag.benchmarkheuristics.parser.stubs;

import java.util.ArrayList;
import java.util.function.IntConsumer;

public class PackageAccessesStub {

    // Classes String and Thread both live in same package: java.lang

    public void empty() { }

    public void oneAccesses_1() {
        String s;
    }

    public void oneAccesses_2() {
        new ArrayList<>();
    }

    public void twoAccesses_1() {
        Thread t = new Thread();
    }

    public void twoAccesses_2() {
        Thread t;
        new ArrayList<>();
    }

    public void twoAccesses_3() {
        new String();
        new ArrayList<>();
    }

    public void twoAccesses_4() {
        new Thread().getName();
    }

    public void threeAccesses_1() {
        Thread t = new Thread();
        new ArrayList<>();
    }

    public void threeAccesses_2() {
        Thread t;
        new String();
        new ArrayList<>();
    }

    public void threeAccesses_3() {
        String s = new String().trim();
    }

    public void fourAccesses_1() {
        String s = new String();
        new Thread().getName();
    }

    public void fourAccesses_2() {
        new String().contains("");
        new Thread();
        IntConsumer ic;
    }

    public void fourAccesses_3() {
        // Calling on 1 method in this class counts as +1 package accesses
        twoAccesses_2();
        IntConsumer ic;
    }

    public void fiveAccesses_1() {
        // Calling on 2 methods in this class counts as +2 package accesses
        oneAccesses_1();
        twoAccesses_3();
    }

    public void fiveAccesses_2() {
        // Calling on 5 methods in this class counts as +5 package accesses
        empty();
        empty();
        empty();
        empty();
        empty();
    }
}
