package HarderOnes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java1DArrayPart2 {
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

        if (leap >= game.length) return true;
        if (m.find() | leap < 2 && sb.indexOf("1") >= 0) return false;

        if (sb.indexOf("1") == -1) {
            return true;
        } else {
            ArrayList<Integer> landingSpots = new ArrayList<>();
            landingSpots.add(game[0]);

            while (true) {
                try {
                    ArrayList<Integer> maximisedImmediateArea = findExtentOfImmediateArea(game, landingSpots);
                    landingSpots = getGoodLandingSpots(game, maximisedImmediateArea, leap);
                } catch (IndexOutOfBoundsException | NullPointerException e) {
                    return true;
                }

                if (landingSpots.size() == 0) {
                    return false;
                }
            }
        }
    }

    //Create index groups
    public static ArrayList<Integer> findExtentOfImmediateArea(int[] game, ArrayList<Integer> indexes) {
        ArrayList<Integer> outputRange = new ArrayList<>();

        int n = game.length;
        int lastIndexOnLeft = 0;
        int lastIndexOnRight = 0;

        for (Integer index : indexes) {
            if (index > 0) {
                boolean found = false;

                for (int j = index - 1; j > 0; j--) {
                    if (game[j] == 1) {
                        lastIndexOnLeft = index - (index - j) + 1;
                        found = true;
                        break;
                    }
                }
                if (!found) lastIndexOnLeft = 0;
            } else {
                lastIndexOnLeft = 0;
            }

            boolean wasInThere = false;

            for (int j = index + 1; j < n; j++) {
                if (game[j] == 1) {
                    lastIndexOnRight = index + (j - index) - 1;
                    wasInThere = true;
                    break;
                }
            }

            if (!wasInThere) lastIndexOnRight = game.length - 1;

            boolean found = false;
            for (int i = 0; i < outputRange.size(); i += 2) {
                if (outputRange.get(i) == lastIndexOnLeft && outputRange.get(i + 1) == lastIndexOnRight) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                outputRange.add(lastIndexOnLeft);
                outputRange.add(lastIndexOnRight);
            }

            if (lastIndexOnLeft == game.length -1 || lastIndexOnRight == game.length - 1) {
                outputRange = null;
                break;
            }
        }

        return outputRange;
    }

    public static ArrayList<Integer> getGoodLandingSpots(int[] game, ArrayList<Integer> rangeOfIndexes, int leap) {
        ArrayList<Integer> goodSpots = new ArrayList<>();
        //go through game array from rangeOfIndexes.get(0) to rangeOfIndexes.get(1)
        for (int i = rangeOfIndexes.get(0); i <= rangeOfIndexes.get(1); i++) {
            //calculate index after leap
            int indexAfterLeap = i + leap;
            //check if the spot is 0/good spot
            if (game[indexAfterLeap] == 0 && indexAfterLeap > rangeOfIndexes.get(1)) {
                //add the spot to output array
                goodSpots.add(indexAfterLeap);
            }
        }
        return goodSpots;
    }
}
