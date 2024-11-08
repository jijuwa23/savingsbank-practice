import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        reverseString();
//        countVowels();
        countVowelsAndConsonant();
//        duplicates();

//        printList(transformEvenNumbers(), "list");

//        System.out.println(totalSumOfList());
//        addTwoNumbers();
    }

    public static void addTwoNumbers() {
        int i;
        //Given an array of distinct integers and a target sum, find two numbers (in a row) in the array that add up to the target sum.
        int[] numbers = {3, 9, 1, 15, 10};

        for (i = 0; i < numbers.length - 1; i++) {
            int first = numbers[i];
            int second = numbers[i + 1];
            int sum = first + second;
            if (sum == 10) {
                System.out.println("Numbers: " + first + ", " + second);
                System.out.println("Sum: " + sum);
            }
        }

    }

    public static List<Integer> filterOddNumbers() {
        //Filter Odd Numbers
        var nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return nums.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
    }

    public static Integer totalSumOfList() {
        //Total Sum of List
        var nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> transformEvenNumbers() {
        //Transform Even Numbers by multiplying by 3
        var nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        return nums.stream().filter(num -> num % 2 == 0).map(num -> num * 3).collect(Collectors.toList());
    }

    public static void printList(List<Integer> list, String message) {
        String result = list.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(message + "\n" + result);
    }

    private static void duplicates() {
        List<String> fruitsWithDuplicates = new ArrayList<>();
        fruitsWithDuplicates.add("APPLE");
        fruitsWithDuplicates.add("APPLE");
        fruitsWithDuplicates.add("ORANGE");
        fruitsWithDuplicates.add("MANGO");
        fruitsWithDuplicates.add("MANGO");

        System.out.println(fruitsWithDuplicates);

        HashSet<String> fruitsNoDuplicates = new HashSet<>();
        for (String fruit : fruitsWithDuplicates) {
            fruitsNoDuplicates.add(fruit);
        }

        System.out.println(fruitsNoDuplicates);
    }

    private static void countVowelsAndConsonant() {
        int i;
        String vowels = "aeiou";
        int vowelsCount = 0;
        int consonantCount = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String stringInput = scanner.nextLine().toLowerCase();

        for (i = 0; i < stringInput.length(); i++) {

            char inputChar = stringInput.charAt(i);
            if (Character.isLetter(inputChar)) {
                if (vowels.contains(String.valueOf(inputChar))) {
                    vowelsCount++;
                } else {
                    consonantCount++;
                }
            }

        }

        System.out.println("Vowels: " + vowelsCount);
        System.out.println("Consonants: " + consonantCount);
    }


    private static void countVowels() {
        int i;
        int j;
        int vowelsCount = 0;
        char[] vowelString = {'A', 'E', 'I', 'O', 'U'};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String stringInput = scanner.nextLine().toUpperCase();

        for (i = 0; i < stringInput.length(); i++) {
            for (j = 0; j < vowelString.length; j++) {
                if (stringInput.charAt(i) == vowelString[j]) {
                    vowelsCount++;
                }
            }
        }

        System.out.println(vowelsCount);
    }

    private static void reverseString() {
        int i;
        String reverse = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String stringInput = scanner.nextLine();

        for (i = stringInput.length() - 1; i >= 0; i--) {
            reverse += stringInput.charAt(i);
        }

        System.out.println(reverse);
    }
}