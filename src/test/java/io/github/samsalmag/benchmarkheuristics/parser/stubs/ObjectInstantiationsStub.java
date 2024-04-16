package io.github.samsalmag.benchmarkheuristics.parser.stubs;

import java.util.ArrayList;

public class ObjectInstantiationsStub {

    public void empty() { }

    public void oneInst_1() {
        Thread t = new Thread();
    }

    public void oneInst_2() {
        new Thread();
    }

    public void oneInst_3() {
        new Thread().getName();
    }

    public void twoInst_1() {
        Thread t1 = new Thread();
        Thread t2 = new Thread();
    }

    public void twoInst_2() {
        Thread t = new Thread();
        String s = new String();
    }

    public void twoInst_3() {
        String s = new String();
        new Thread();
    }

    public void twoInst_4() {
        String s = new String();
        new Thread().getName();
    }

    public void twoInst_5() {
        oneInst_1();
        oneInst_2();
    }

    public void threeInst_1() {
        Thread t = new Thread();
        new String();
        new ArrayList<>();
    }

    public void threeInst_2() {
        oneInst_3();
        twoInst_3();
    }

    public void threeInst_3() {
        twoInst_2();
        new ArrayList<>();
    }
}
