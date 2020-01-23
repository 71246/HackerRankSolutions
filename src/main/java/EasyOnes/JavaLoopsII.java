package EasyOnes;

import java.util.Scanner;
import java.lang.Math;

public class JavaLoopsII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int mainCalc = 0;
        int addCalc = 0;

        for(int i = 0; i < q; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            mainCalc = a + b;

            for(int s = 1; s <= n; s++){
                if (s != 1) {
                    addCalc = (int) (Math.pow(2, s - 1) * b);
                    mainCalc = mainCalc + addCalc;
                }

                System.out.print(mainCalc + " ");

                if (s == n) {
                    System.out.println();
                }
            }
        }

        in.close();
    }
}
