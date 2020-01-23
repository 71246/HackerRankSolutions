package JavaStackPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        ArrayList<String> inp = new ArrayList<>();
        /*inp.add("[({})(())]");
        inp.add("(({()})))[[");
        inp.add("({(){}()})()({(){}()})(){()}{}((()))");
        inp.add("{}()))(()()({}}{}");*/
        inp.add("}}}}");
        inp.add("))))");
        /*inp.add("{{{");
        inp.add("(((");
        inp.add("{}(){()}((())){{{}}}{()()}{{}{}}");
        inp.add("{{{{{{{)))))))))))))))))))");
        inp.add("{}{}(");
        inp.add("{}}}{}");
        inp.add("()()()())))");
        inp.add("(((((()()()");
        inp.add("(){}{{}}()(()){{()()}}");
        inp.add("{}{{{}}}{{{((()))}}}");
        inp.add("((()))[]");
        inp.add("{{}}(()[])");*/

        //while (sc.hasNext()) {
        for (String string : inp) {
            //String input = sc.next();
            String input = string;
            Stack<String> stack = new Stack<String>();

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("(", ")");
            map.put("{", "}");
            map.put("[", "]");

            String[] strings = input.split("");

            if (!map.containsKey(strings[0])) {
                System.out.println("false");
            } else {
                stack.push(strings[0]);

                for (int i = 1; i < strings.length; i++) {
                    boolean openingBracket = false;

                    if (map.get(strings[i]) != null) openingBracket = true;

                    if (openingBracket) {
                        stack.push(strings[i]);
                    } else {
                        if (stack.size() > 0 ) {
                            if (strings[i].equals(map.get(stack.peek()))) {
                                stack.pop();
                            }
                        } else {
                            stack.push(strings[i]);
                            break;
                        }
                    }
                }

                if (stack.size() == 0) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
        }
    }
}
