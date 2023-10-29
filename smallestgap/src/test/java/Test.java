import org.example.Main;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test {

    @org.junit.jupiter.api.Test
    void test1() {
        int[] myNum = {10,4,1};
        assertEquals(2, Main.leastAmountOfDigitsBetween(myNum));
    }

    @org.junit.jupiter.api.Test
    void test2() {
        int[] myNum = {10,10,4,1};
        assertEquals(0, Main.leastAmountOfDigitsBetween(myNum));
    }

    @org.junit.jupiter.api.Test
    void test3() {
        int[] myNum = {2226655, 11, 5762837, 777, 650};
        assertEquals(126, Main.leastAmountOfDigitsBetween(myNum));
    }

    @org.junit.jupiter.api.Test
    void test4() {
        int[] myNum = {1};
        assertEquals(-1, Main.leastAmountOfDigitsBetween(myNum));
    }

    @org.junit.jupiter.api.Test
    void test5() {
        int[] myNum = {123, -22, -20};
        assertEquals(-1, Main.leastAmountOfDigitsBetween(myNum));
    }

}
