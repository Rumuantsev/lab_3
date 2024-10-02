package org.example;

import java.util.*;

import static java.util.Collections.frequency;
import static java.util.Collections.sort;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(" ");
        System.out.print("Input N: ");
        int size = in.nextInt();

        Random random = new Random();
        int[] randomArray = new int[size];

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(101); // Числа от 0 до 100 включительно
        }

        List<Integer> randomList = new ArrayList<>();
        for (int number : randomArray) {
            randomList.add(number);
        }

        System.out.print("List: ");
        System.out.println(randomList);

        Collections.sort(randomList);
        System.out.print("Sorted list: ");
        System.out.println(randomList);

        Collections.reverse(randomList);
        System.out.print("Reverse list: ");
        System.out.println(randomList);

        Collections.shuffle(randomList);
        System.out.print("Shuffle list: ");
        System.out.println(randomList);

        Collections.rotate(randomList, 1);
        System.out.print("Rotate list: ");
        System.out.println(randomList);

        List<Integer> uniqueElements = new ArrayList<>();
        for (int obj: randomList) {
            if( frequency(randomList, obj) == 1){
                uniqueElements.add(obj);
            }
        }
        System.out.print("Unique elements: ");
        System.out.println(uniqueElements);

        List<Integer> duplicateElements = new ArrayList<>();
        for (int obj: randomList) {
            if( frequency(randomList, obj) > 1){
                duplicateElements.add(obj);
            }
        }
        System.out.print("Duplicate elements: ");
        System.out.println(duplicateElements);

        Object[] listToArray = randomList.toArray();
        System.out.print("Array: ");
        System.out.println(Arrays.toString(listToArray));

        for (int number: randomList) {
            System.out.print(number + ": " + frequency(randomList, number) + " \n");
        }
    }
}

class PrimesGenerator {
    public List<Integer> generatePrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        if (n <= 0) {
            return primes;
        }

        primes.add(2);
        int number = 3;

        while (primes.size() < n) {
            if (isPrime(number)) {
                primes.add(number);
            }
            number += 2;
        }

        return primes;
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}