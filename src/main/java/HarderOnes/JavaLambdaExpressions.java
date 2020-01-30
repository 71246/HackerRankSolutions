package HarderOnes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JavaLambdaExpressions {
    interface PerformOperation {
        boolean check(int a);
    }

    public static class MyMath {
        public static boolean checker(PerformOperation p, int num) {
            return p.check(num);
        }

        public static PerformOperation isOdd() {
            return (int a) -> a % 2 != 0;
        }

        public static PerformOperation isPrime() {
            return (int a) -> {
                int m = a / 2, flag = 0;
                if (a != 0 && a != 1) {
                    for (int i = 2; i <= m; i++) {
                        if (a % i == 0) {
                            flag = 1;
                            break;
                        }
                    }
                }
                return flag == 0;
            };
        }

        public static PerformOperation isPalindrome() {
            return (int a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
        }
    }

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
