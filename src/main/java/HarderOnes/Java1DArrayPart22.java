package HarderOnes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java1DArrayPart22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();

        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES " + n + " " + leap : "NO " + n + " " + leap);
        }
        scan.close();
    }

    public static boolean canWin(int leap, int[] game) {
        StringBuilder sb = new StringBuilder();
        for (int i : game) sb.append(i);

        Pattern p = Pattern.compile("(1{" + leap + "})");
        Matcher m = p.matcher(sb);

        return !(m.find() | (leap < 2 && sb.indexOf("1") >= 0));
    }
}
