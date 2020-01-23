package EasyOnes;

import java.util.Scanner;

public class JavaStdinAndStdoutII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        double b = scanner.nextDouble();
        String c = scanner.next();

        System.out.println("String: " + c);
        System.out.println("Double: " + b);
        System.out.print("Int: " + a);
    }
}
