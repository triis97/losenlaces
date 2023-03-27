package org.losenlaces.algorithms.dynamic;

import java.util.Arrays;
import java.util.Random;

//Dynamic + memorization
public class Dynamic {

    // Driver Code
    public static void main(String[] args) {

        Arrays.fill(dp, -1);

        for (int i = 0; i < 10; i++) {
            int n = new Random().nextInt(15);
            System.out.println(fib(n));
        }

    }

    // Initialize array of dp
    static int[] dp = new int[15];

    static int fib(int n) {
        if (n <= 1) return n;

        // Temporary variables to store
        // values of fib(n-1) & fib(n-2)
        int first, second;

        if (dp[n - 1] != -1) first = dp[n - 1];
        else first = fib(n - 1);

        if (dp[n - 2] != -1) second = dp[n - 2];
        else second = fib(n - 2);

        // Memoization
        return dp[n] = first + second;
    }


}
