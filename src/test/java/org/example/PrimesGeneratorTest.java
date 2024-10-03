package org.example;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimesGeneratorTest {

    @Test
    void generatePrimes() {
        PrimesGenerator generator = new PrimesGenerator();
        int n = 70;
        List<Integer> primes = generator.generatePrimes(n);

        System.out.println("Первые " + n + " простых чисел в прямом порядке:");
        System.out.println(primes);

        Collections.reverse(primes);
        System.out.println("Первые " + n + " простых чисел в обратном порядке:");
        System.out.println(primes);
    }
}