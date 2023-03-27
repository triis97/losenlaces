package org.losenlaces.algorithms.dynamic;

import java.util.Arrays;
import java.util.Random;

//Dynamic + memorization
public class Dynamic {

    // Driver Code
    public static void main(String[] args) {

        Arrays.fill(dynamicProgramming, -1);

        for (int i = 0; i < 10; i++) {
            int n = new Random().nextInt(15);
            System.out.println(fib(n));
        }

    }

    // Initialize array of dp
    static int[] dynamicProgramming = new int[15];

    static int fib(int n) {
        if (n <= 1) return n;

        // Temporary variables to store
        // values of fib(n-1) & fib(n-2)
        int first, second;

        if (dynamicProgramming[n - 1] != -1) {
            first = dynamicProgramming[n - 1];
        } else {
            first = fib(n - 1);
        }

        if (dynamicProgramming[n - 2] != -1) {
            second = dynamicProgramming[n - 2];
        } else {
            second = fib(n - 2);
        }

        // Memoization
        dynamicProgramming[n] = first + second;
        return dynamicProgramming[n];
    }
}
