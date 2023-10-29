package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }

    public static int leastAmountOfDigitsBetween(int[] numbers){
        //Return if the array contains less than two numbers
        if (numbers.length < 2) {
            return -1;
        }

        Arrays.sort(numbers);

        int smallestGap = Integer.MAX_VALUE;

        for (int i = 1; i < numbers.length; i++) {
            //return if a number in array is not a natural number
            if(numbers[i] < 1)
                return -1;

            int gap = numbers[i] - numbers[i - 1];

            if (gap < smallestGap)
                smallestGap = gap;
        }
        //returns 0 also when array contains the same number more than once
        return smallestGap==0 ? 0 : smallestGap - 1;
    }

}