package EasyOnes.Anagrams;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String string1 = scanner.next();
        System.out.println(isAnagram(string, string1) ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String a, String b) {
        String[] arr = a.split("");
        String[] arr1 = b.split("");

        Arrays.sort(arr);
        Arrays.sort(arr1);

        return Arrays.equals(arr, arr1);
    }
}
