package HarderOnes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Utilities.CheckAnswers.*;

public class Java1DArrayPart2 {
    static final boolean fromFile = true;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<>();
        ArrayList<String> expectedAnswers;
        ArrayList<String> siteInput;
        ArrayList<Integer> indicesOfIncorrectAnswers;
        int q, n, leap;

        try {
            siteInput = getAllFromTextFile("Test case 3 - input.txt");
            if (fromFile) {
                q = Integer.parseInt(siteInput.get(0));
            } else {
                q = scan.nextInt();
            }
            int counter = 1;

            while (q-- > 0) {
                String[] sizeAndLeap = siteInput.get(counter).split(" ");
                leap = Integer.parseInt(sizeAndLeap[1]);
                String[] gameArray = siteInput.get(counter + 1).split(" ");
                int[] game = new int[gameArray.length];

                for (int i = 0; i < gameArray.length; i++) {
                    game[i] = Integer.parseInt(gameArray[i]);
                }

                answers.add((canWin(leap, game)) ? "YES" : "NO");

                counter += 2;

                if (!fromFile) {
                    n = scan.nextInt();
                    leap = scan.nextInt();

                    int[] game1 = new int[n];
                    for (int i = 0; i < n; i++) {
                        game1[i] = scan.nextInt();
                    }

                    System.out.println((canWin(leap, game1)) ? "YES" : "NO");
                }
            }

            try {
                expectedAnswers = getAllFromTextFile("Test case 3 - expected output.txt");
                indicesOfIncorrectAnswers = getIncorrectAnswersIndices(answers, expectedAnswers);
                printOutIncorrectInputs(indicesOfIncorrectAnswers, siteInput, expectedAnswers);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        ArrayList<Integer> rangeOfImmediateArea = new ArrayList<>();

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
            for (int i = 0; i < rangeOfImmediateArea.size(); i += 2) {
                if (rangeOfImmediateArea.get(i) == lastIndexOnLeft && rangeOfImmediateArea.get(i + 1) == lastIndexOnRight) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                rangeOfImmediateArea.add(lastIndexOnLeft);
                rangeOfImmediateArea.add(lastIndexOnRight);
            }

            if (lastIndexOnLeft == game.length - 1 || lastIndexOnRight == game.length - 1) {
                rangeOfImmediateArea = null;
                break;
            }
        }

        return rangeOfImmediateArea;
    }

    public static ArrayList<Integer> getGoodLandingSpots(int[] game, ArrayList<Integer> rangeOfIndexes, int leap) {
        ArrayList<Integer> goodSpots = new ArrayList<>();
        //go through game array from rangeOfIndexes.get(i) to rangeOfIndexes.get(i + 1)
        for (int i = 0; i < rangeOfIndexes.size(); i += 2) {
            int lastIndexInRange = rangeOfIndexes.get(i + 1);

            for (int j = rangeOfIndexes.get(i); j <= rangeOfIndexes.get(i + 1); j++) {
                //calculate index after leap
                int indexAfterLeap = j + leap;
                //check if the spot is 0/good spot
                if (game[indexAfterLeap] == 0 && indexAfterLeap > lastIndexInRange) {
                    //add the spot to output array
                    goodSpots.add(indexAfterLeap);
                }
            }
        }
        return goodSpots;
    }
}
