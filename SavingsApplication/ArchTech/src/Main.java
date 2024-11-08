import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int i;
        int j;
        int[] intArr = {2, 5, 9, 3, 6, 0, 1, 2, 5, 7, 10};
        int max = 0;
        int nextMax = 0;

        for (i = 0; i < intArr.length; i++) {
            for (j = 0; j < intArr.length; j++) {
                if (intArr[i] > intArr[j]) {
                    max = intArr[i];
                }
            }
        }

        SUM OF 2 POSSIBLE INTEGER
        System.out.println(max);
    }

    public static void calculateVowelsAndConsonants() {
        int i;
        String stringSample = "The quick brown fox brown jumps over the lazy dog!".toLowerCase();
        String vowels = "aeiou";
        int vowelsCount = 0;
        int consonantCount = 0;

        for (i = 0; i < stringSample.length(); i++) {
            char charVar = stringSample.charAt(i);
            if (Character.isLetter(charVar) && Character.isAlphabetic(charVar)) {
                if (vowels.contains(String.valueOf(charVar))) {
                    vowelsCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.println("Vowels Count: " + vowelsCount);
        System.out.println("Consonant Count: " + consonantCount);
    }

    public static void reverse() {
        int i;
        String reverse = "";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String stringInput = scanner.nextLine();

        for (i = stringInput.length() - 1; i >= 0; i--) {
            reverse += String.valueOf(stringInput.charAt(i));
        }

        System.out.println(reverse);

    }
}