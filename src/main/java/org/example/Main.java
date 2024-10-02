package org.example;

import java.util.*;

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
    }
}