package com.leetcode.solutions.classic;

public class C204_count_primes {
    public int countPrimes(int n) {

        // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

        if (n <= 2)
            return 0;

        // init an array to track prime numbers
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++)
            primes[i] = true;

        for (int i = 2; i <= Math.sqrt(n - 1); i++) {
            // or for (int i = 2; i <= n-1; i++) {
            if (primes[i]) {
                for (int j = i + i; j < n; j += i)
                    primes[j] = false;
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }

        return count;

        // this solution exceed time limit since it is n^2
//         if (n <= 1)
//             return 0;
//         if (n == 2)
//             return 0;
//         if (n == 3)
//             return 1;
//         List<Integer> list = new ArrayList<>();
//         list.add(2);
//         list.add(3);
//         for (int i = 4; i < n; i ++) {
//             boolean isPrime = true;
//             for (int pri : list) {
//                 if (i % pri == 0) {
//                     isPrime = false;
//                     break;
//                 }

//             }
//             if (isPrime)
//                 list.add(i);
//         }

//         return list.size();
    }
}
