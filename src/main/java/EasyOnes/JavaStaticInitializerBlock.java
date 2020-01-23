package EasyOnes;

import java.util.Scanner;

public class JavaStaticInitializerBlock {
    static int B = initializeBreadthAndHeight();
    static int H = initializeBreadthAndHeight();
    static boolean flag = setFlag();

    public static void main(String[] args) {
        if(flag){
            int area=B * H;
            System.out.print(area);
        }
    }

    static private int initializeBreadthAndHeight() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    static private boolean setFlag() {
        try {
            if (B > 0 && H > 0) {
                return true;
            } else throw new java.lang.Exception();
        } catch (java.lang.Exception e) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }

        return false;
    }
}
