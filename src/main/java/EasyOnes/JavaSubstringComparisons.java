package EasyOnes;

import java.util.ArrayList;

public class JavaSubstringComparisons {
    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest;
        String largest;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - (k - 1); i++) {
            if (i == 0) {
                sb.append(s, i, k + i);
            } else {
                sb.append(",").append(s, i, k + i);
            }
        }

        String[] strArray = sb.toString().split(",");

        for (int i = 0; i < strArray.length - 1; i++) {
            for (int j = i + 1; j < strArray.length; j++) {
                if (strArray[i].compareTo(strArray[j]) > 0) {
                    String temp = strArray[i];
                    strArray[i] = strArray[j];
                    strArray[j] = temp;
                }
            }
        }

        smallest = strArray[0];
        largest = strArray[strArray.length - 1];

        return smallest + "\n" + largest;
    }
}

