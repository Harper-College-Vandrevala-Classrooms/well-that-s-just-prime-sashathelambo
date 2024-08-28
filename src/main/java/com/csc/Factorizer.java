package com.csc;

public class Factorizer {

    public int[] primeFactors(int number) {
        if (number <= 1) {
            return null;
        }

        int[] factors = new int[100];
        int index = 0;

        int i = 2;
        while (number > 1) {
            while (number % i == 0) {
                factors[index] = i;
                index++;
                number = number / i;
            }
            i++;
        }

        int[] result = new int[index];
        for (int j = 0; j < index; j++) {
            result[j] = factors[j];
        }

        return result;
    }

    public static void main(String[] args) {
        Factorizer factorizer = new Factorizer();

        printFactors(28, factorizer.primeFactors(28));
        printFactors(13, factorizer.primeFactors(13));
        printFactors(1, factorizer.primeFactors(1));
        printFactors(100, factorizer.primeFactors(100));
        printFactors(210, factorizer.primeFactors(210));
    }

    private static void printFactors(int number, int[] factors) {
        if (factors == null) {
            System.out.println("Prime factors of " + number + ": null");
        } else {
            System.out.print("Prime factors of " + number + ": ");
            for (int factor : factors) {
                System.out.print(factor + " ");
            }
            System.out.println();
        }
    }
}
