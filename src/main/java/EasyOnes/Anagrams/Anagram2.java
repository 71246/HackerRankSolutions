package EasyOnes.Anagrams;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String string1 = scanner.next();
        System.out.println(isAnagram(string, string1) ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String a, String b) {
        HashMap<Character, Integer> hm = new HashMap<>();
        HashMap<Character, Integer> hm1 = new HashMap<>();

        for (int j = 0; j < a.length(); j++) {
            if (hm.containsKey(a.charAt(j))) {
                hm.putIfAbsent(a.charAt(j), hm.get(a.charAt(j)) + 1);
            } else {
                hm.put(a.charAt(j), 1);
            }
        }

        for (int j = 0; j < b.length(); j++) {
            if (hm1.containsKey(b.charAt(j))) {
                hm1.putIfAbsent(b.charAt(j), hm1.get(b.charAt(j)) + 1);
            } else {
                hm1.put(b.charAt(j), 1);
            }
        }

        return hm.equals(hm1);
    }
}
