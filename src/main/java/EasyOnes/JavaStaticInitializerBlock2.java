package EasyOnes;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class JavaStaticInitializerBlock2 {
    static boolean flag; static int B,H;

    static{
        Scanner scan = new Scanner(System.in);
        B = scan.nextInt();
        H = scan.nextInt();

        try {
            if (B > 0 && H > 0) {
                flag = true;
            } else throw new java.lang.Exception();
        } catch (java.lang.Exception e) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

    public static void main(String[] args) {
        if(flag){
            int area=B * H;
            System.out.print(area);
        }

        Calendar c = Calendar.getInstance();
        c.set(2019, 01, 01);

    }
}
