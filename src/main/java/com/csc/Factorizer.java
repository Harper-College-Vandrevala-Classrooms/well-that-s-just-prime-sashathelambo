package com.csc;

import java.util.ArrayList;
import java.util.List;

public class Factorizer {

    public List<Integer> primeFactors(int number) {
        if (number <= 1) {
            return null;
        }

        List<Integer> factors = new ArrayList<>();

        int i = 2;
        while (number > 1) {
            while (number % i == 0) {
                factors.add(i);
                number = number / i;
            }
            i++;
        }

        return factors;
    }

    public boolean isPrime(int number) {
        List<Integer> factors = primeFactors(number);
        return factors != null && factors.size() == 1 && factors.get(0) == number;
    }

    public boolean isComposite(int number) {
        return number > 1 && !isPrime(number);
    }

    public String reduce(int numerator, int denominator) {
        List<Integer> numFactors = primeFactors(numerator);
        List<Integer> denFactors = primeFactors(denominator);

        if (numFactors == null || denFactors == null) {
            return numerator + "/" + denominator;
        }

        for (int factor : numFactors) {
            if (denFactors.contains(factor)) {
                numFactors.remove((Integer) factor);
                denFactors.remove((Integer) factor);
            }
        }

        int reducedNumerator = 1;
        for (int factor : numFactors) {
            reducedNumerator *= factor;
        }

        int reducedDenominator = 1;
        for (int factor : denFactors) {
            reducedDenominator *= factor;
        }

        return reducedNumerator + "/" + reducedDenominator;
    }

    public static void main(String[] args) {
        Factorizer factorizer = new Factorizer();

        printFactors(28, factorizer.primeFactors(28));
        printFactors(13, factorizer.primeFactors(13));
        printFactors(1, factorizer.primeFactors(1));
        printFactors(100, factorizer.primeFactors(100));
        printFactors(210, factorizer.primeFactors(210));

        System.out.println("Is 28 prime? " + factorizer.isPrime(28));
        System.out.println("Is 13 prime? " + factorizer.isPrime(13));
        System.out.println("Is 1 prime? " + factorizer.isPrime(1));
        System.out.println("Is 100 prime? " + factorizer.isPrime(100));
        System.out.println("Is 210 prime? " + factorizer.isPrime(210));

        System.out.println("Is 28 composite? " + factorizer.isComposite(28));
        System.out.println("Is 13 composite? " + factorizer.isComposite(13));
        System.out.println("Is 1 composite? " + factorizer.isComposite(1));
        System.out.println("Is 100 composite? " + factorizer.isComposite(100));
        System.out.println("Is 210 composite? " + factorizer.isComposite(210));

        System.out.println("Reduced fraction of 12/26: " + factorizer.reduce(12, 26));
        System.out.println("Reduced fraction of 100/210: " + factorizer.reduce(100, 210));
    }

    private static void printFactors(int number, List<Integer> factors) {
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
