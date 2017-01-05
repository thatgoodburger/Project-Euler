import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    private static final int FLT_LOAD = 10;

    private static Scanner scanner;
    private static Random randomGen;

    static {
        scanner = new Scanner(System.in);
        randomGen = new Random();
    }

    public static void main(String[] args) {
        int numArgs = scanner.nextInt();

        // go through the input numbers
        for (int i = 0; i < numArgs; ++i) {
            long input = scanner.nextLong();
            long greatestPrimeFactor = 1;

            // first test the input number
            if (fermatTest((int) input)) {
                greatestPrimeFactor = input;
            } else {
                // look for factors of the number starting at sqrt(input)
                for (long j = 2; j < (long) Math.sqrt(input); ++j) {
                    // see if j is a factor of input
                    if (input % j == 0) {
                        long primeFactor = testFactorPair(j, input / j);
                        if (primeFactor > greatestPrimeFactor) {
                            greatestPrimeFactor = primeFactor;
                        }
                    }
                }
            }
//            System.out.println("Greatest prime factor of " + input + " is " + greatestPrimeFactor);
            System.out.println(greatestPrimeFactor);
        }

    }

    /**
     * Given two factors, x and y, test to see if either is prime.
     *
     * @param x - one factor of an input.
     * @param y - a second factor of the input.
     * @return - the largest of x and y if one is prime, 0 if neither are prime.
     */
    private static long testFactorPair(long x, long y) {
        return fermatTest((int) y) ? y : fermatTest((int) x) ? x : 0;
    }

    /**
     * Performs Fermat's Little Theorem test with FLT_LOAD tries
     *
     * @param p - the number to test.
     * @return - true if p is prime, false otherwise.
     */
    private static boolean fermatTest(int p) {
        boolean isPrime = true;

        // select a such that 1 < a < p for FLT_LOAD tests
        for (int i = 0; i < FLT_LOAD; ++i) {
            BigInteger a = new BigInteger(String.valueOf(getNextRandLong(p)));

            // log the output of the power... might need big numbers.
            BigInteger result = a.pow(p-1).mod(new BigInteger(String.valueOf(p)));
            isPrime = isPrime && result.doubleValue() == 1;

            if (!isPrime)
                break;
        }

        return isPrime;
    }

    /**
     * @param p - the upper bound of the value of a, non-inclusive
     * @return - a, 1 < a < p
     */
    private static long getNextRandLong(long p) {
        long a = 0;

        while (a == 0) {
            a = Math.abs(randomGen.nextLong()) % p;
        }

        return a;
    }
}
