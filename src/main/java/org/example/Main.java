package org.example;

import java.util.*;

import static java.util.Collections.frequency;

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

        List<Human> humans = new ArrayList<>();
        Human human1 = new Human("Roma","Ivanov", 50);
        Human human2 = new Human("Gena","Rogov", 49);
        Human human3 = new Human("Vika","Aolova", 12);
        humans.add(human1);
        humans.add(human2);
        humans.add(human3);

        HashSet<Human> humansHashSet = new HashSet<>(humans);
        System.out.println(humansHashSet); //Выведено в том же порядке, что и введено

        LinkedHashSet<Human> humansLinkedHashSet = new LinkedHashSet<>(humans);
        System.out.println(humansLinkedHashSet); //Выведено в том же порядке, что и введено

        TreeSet<Human> humansTreeSet = new TreeSet<>(humans);
        System.out.println(humansTreeSet); //Отсортировано по фамилии

        TreeSet<Human> humanTreeSetWithCompLName = new TreeSet<>(new HumanComparatorByLastName());
        humanTreeSetWithCompLName.addAll(humans);
        System.out.println(humanTreeSetWithCompLName); //Отсортировано по фамилии

        TreeSet<Human> humanTreeSetWithCompAge = new TreeSet<>(Comparator.comparingInt(Human::getAge));
        humanTreeSetWithCompAge.addAll(humans);
        System.out.println(humanTreeSetWithCompAge); //Отсортировано по возрасту

        String str = "The phone rings on the phone";
        HashMap<String, Integer> words = getStringIntegerHashMap(str);
        System.out.println(words);

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Arseniy", 8);
        map.put("Alina", 8);
        map.put("Vladislav", 9);
        System.out.println(map);
        Map<Integer, String> swappedMap = swapKeyValues(map);
        System.out.println(swappedMap);
    }

    private static HashMap<String, Integer> getStringIntegerHashMap(String str) {
        String strIgnoreCase =  str.toLowerCase();

        HashMap<String, Integer> words = new HashMap<>();
        String word = "";
        for(int i = 0; i < strIgnoreCase.length(); ++i){
            if(strIgnoreCase.charAt(i) != ' '){
                word += strIgnoreCase.charAt(i);
                if(i == strIgnoreCase.length() - 1){
                    if (!words.containsKey(word)) {
                        words.put(word, 1);
                    } else{
                        words.put(word, words.get(word) + 1);
                    }
                    word = "";
                }
            } else if(strIgnoreCase.charAt(i) == ' '){
                if (!words.containsKey(word)) {
                    words.put(word, 1);
                } else{
                    words.put(word, words.get(word) + 1);
                }
                word = "";
            }
        }
        return words;
    }

    private static Map<Integer, String> swapKeyValues(Map<String, Integer> originalMap) {
        Map<Integer, String> swappedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : originalMap.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }
        return swappedMap;
    }
}


class Human implements Comparable<Human> {

    private final String firstName;
    private final String lastName;
    private final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Human other) {
        return this.lastName.compareToIgnoreCase(other.lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + '}';
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

class HumanComparatorByLastName implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.getLastName().compareToIgnoreCase(human2.getLastName());
    }
}