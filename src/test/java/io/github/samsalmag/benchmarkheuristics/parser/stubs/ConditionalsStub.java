package io.github.samsalmag.benchmarkheuristics.parser.stubs;

public class ConditionalsStub {

    public void empty() { }

    public void oneIf_1() {
        if (true) { }
    }

    public void oneIf_2() {
        if (true) { }
        else { }
    }

    public void twoIf_1() {
        if (true) { }

        if (true) { }
    }

    public void twoIf_2() {
        if (true) { }
        else if (true) { }
    }

    public void twoIf_3() {
        if (true) { }
        else if (true) { }
        else { }
    }

    public void threeIf_1() {
        if (true) { }

        if (true) { }

        if (true) { }
    }

    public void threeIf_2() {
        if (true) { }
        else if (true) { }

        if (true) { }
    }

    public void oneSwitchCase() {
        switch ("") {
            case "1": break;
        }
    }

    public void twoSwitchCase() {
        switch ("") {
            case "1": break;
            case "2": break;
        }
    }

    public void threeSwitchCase() {
        switch ("") {
            case "1": break;
            case "2": break;
            case "3": break;
        }
    }
}
