package EasyOnes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine().trim();
        String[] tokens = null;

        if (!line.isEmpty()) {
            tokens = line.split("[\\s\\?',!._@]+");
            System.out.println(tokens.length);

            for (String str: tokens) {
                System.out.println(str);
            }
        } else {
            System.out.println("0");
        }
        scan.close();
    }
}
