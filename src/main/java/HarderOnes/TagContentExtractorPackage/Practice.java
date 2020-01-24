package HarderOnes.TagContentExtractorPackage;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\n");
        //Arrays.stream(input).forEach(System.out::println);

        System.out.println(input[0].substring(3, 7));
        System.out.println(input[0].compareTo(input[1]));
        System.out.println(input[0]);

        Pattern p = Pattern.compile("");
    }
}
