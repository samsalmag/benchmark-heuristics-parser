package io.github.samsalmag.benchmarkheuristics.parser.stubs;

import java.util.Collections;

public class MethodCallsStub {

    public void empty() { }

    public void oneMethodCall_1() {
        // 0 method calls inside methods below
        // Plus 1 method calls because of the calls in this method
        empty();
    }

    public void oneMethodCall_2() {
        // 0 method calls inside methods below (lib calls end recursion)
        // Plus 1 method calls because of the calls in this method
        Collections.sort(null);
    }

    public void twoMethodCall_1() {
        // 0 method calls inside methods below
        // Plus 2 method calls because of the calls in this method
        empty();
        empty();
    }

    public void twoMethodCall_2() {
        // 0 method calls inside methods below (lib calls end recursion)
        // Plus 2 method calls because of the calls in this method
        empty();
        Collections.sort(null);
    }

    public void threeMethodCall_1() {
        // 0 method calls inside methods below
        // Plus 3 method calls because of the calls in this method
        empty();
        empty();
        empty();
    }

    public void threeMethodCall_2() {
        // 1 method calls inside methods below
        // Plus 2 method calls because of the calls in this method
        empty();
        oneMethodCall_2();
    }

    public void fourMethodCall() {
        // 2 method calls inside methods below
        // Plus 2 method calls because of the calls in this method
        empty();
        twoMethodCall_1();
    }

    public void eightMethodCall() {
        // 6 method calls inside methods below
        // Plus 2 method calls because of the calls in this method
        threeMethodCall_1();
        threeMethodCall_2();
    }

    public void nineMethodCall() {
        // 6 method calls inside methods below
        // Plus 3 method calls because of the calls in this method
        twoMethodCall_1();
        twoMethodCall_1();
        twoMethodCall_2();
    }

    public void sixteenMethodCall() {
        // 10 method calls inside methods below (lib calls end recursion)
        // Plus 6 method calls because of the calls in this method
        oneMethodCall_1();
        oneMethodCall_2();
        eightMethodCall();

        Collections.sort(null);
        Collections.sort(null);
        Collections.sort(null);
    }

    public void thirtyMethodCall() {
        // 24 method calls inside methods below
        // Plus 6 method calls because of the calls in this method
        empty();
        oneMethodCall_1();
        twoMethodCall_2();
        fourMethodCall();
        eightMethodCall();
        nineMethodCall();
    }
}
