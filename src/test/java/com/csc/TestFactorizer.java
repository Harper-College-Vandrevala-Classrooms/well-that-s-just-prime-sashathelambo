package com.csc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFactorizer {

  Factorizer factorizer;

  @BeforeEach
  void setUp() {
    factorizer = new Factorizer();
  }

  @Test
    public void testZero() {
        // Testing primeFactors with input 0, expecting null
        assertNull(factorizer.primeFactors(0), "Prime factors of 0 should be null.");
    }

    @Test
    public void testOne() {
        // Testing primeFactors with input 1, expecting null
        assertNull(factorizer.primeFactors(1), "Prime factors of 1 should be null.");
    }

    @Test
    public void testTen() {
        // Testing primeFactors with input 10, expecting [2, 5]
        int[] expected = {2, 5};
        assertArrayEquals(expected, factorizer.primeFactors(10), "Prime factors of 10 should be [2, 5].");
    }
}