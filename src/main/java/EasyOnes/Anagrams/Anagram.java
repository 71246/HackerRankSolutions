package EasyOnes.Anagrams;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String string1 = scanner.next();
        System.out.println(isAnagram(string, string1) ? "Anagrams" : "Not Anagrams");
    }

    static boolean isAnagram(String a, String b) {
        return countChars(a.toUpperCase()).equals(countChars(b.toUpperCase()));
    }

    static java.util.HashMap<Character, Integer> countChars(String s) {
        java.util.HashMap<Character, Integer> hm = new java.util.HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            if (hm.containsKey(s.charAt(j))) {
                System.out.println(hm.get(s.charAt(j)));
                System.out.println(hm.get(s.charAt(j)) + 1);
                //hm.putIfAbsent(s.charAt(j), hm.get(s.charAt(j)) + 1);
                hm.replace(s.charAt(j), hm.get(s.charAt(j)) + 1);
            } else {
                hm.put(s.charAt(j), 1);
            }
        }
        return hm;
    }
}
