package EasyOnes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());

        String[] arr1 = sb.toString().split("");
        String[] arr2 = sb.reverse().toString().split("");

        System.out.println(Arrays.equals(arr1, arr2) ? "Yes" : "No");
    }
}
