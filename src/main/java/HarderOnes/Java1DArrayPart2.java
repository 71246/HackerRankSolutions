package HarderOnes;

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
        //int[] -> StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i : game) sb.append(i);

        Pattern p = Pattern.compile("(1{" + leap + "})");
        Matcher m = p.matcher(sb);

        if (m.find() | leap == 0 && sb.indexOf("1") >= 0) {
            return false;
        } else {
            if (sb.indexOf("1") == -1) {
                return true;
            } else {
                int index = 0;
                boolean win = false;

                while (true) {
                    int[] range = findNextLeapSpotRange(game, index, leap, game.length);

                    for (int i = index; i < range[1] + 1; i++) {
                        int newIndex = checkLeapSpots(i, leap, game.length, game, range[1]);

                        if (newIndex == -1) {
                            win = true;
                            break;
                        } else {
                            if (index == range[1]) {
                                return false;
                            } else if (index > game.length) {
                                return true;
                            }
                            index = newIndex;
                        }
                    }

                    if (win) {
                        return true;
                    }
                }
            }
        }
    }

    public static int[] findNextLeapSpotRange(int[] game, int currentIndex, int leap, int n) {
        int lastIndexOnLeft = currentIndex;
        int lastIndexOnRight = currentIndex;

        //Count available leaping spots to the left
        if (currentIndex > 0) {
            boolean found = false;

            for (int i = currentIndex - 1; i > 0; i--) {
                if (game[i] == 1) {
                    lastIndexOnLeft = currentIndex - (currentIndex - i) + 1;
                    found = true;
                    break;
                }
            }
            if (!found) lastIndexOnLeft = 0;
        }

        //and to the right
        for (int i = currentIndex + 1; i < n; i++) {
            if (game[i] == 1) {
                lastIndexOnRight = currentIndex + (i - currentIndex) - 1;
                break;
            }
        }

        return new int[]{lastIndexOnLeft, lastIndexOnRight};
    }

    public static int checkLeapSpots(int index, int leap, int n, int[] game, int lastIndex) {
        if (index + 1 == n) {
            //walk across the end of array
            return -1;
        }

        //check if any of those spots are any good
        if (index + leap < n) {
            if (game[index + leap] == 0 && index + leap > lastIndex) {
                int[] spots = findNextLeapSpotRange(game, index + leap, leap, game.length);
                return checkLeapSpots(index + leap, leap, n, game, spots[1]);
            } else {
                if (index + 1 < lastIndex) {
                    return index + 1;
                } else {
                    return 0;
                }
            }
        } else {
            return -1;
        }
    }
}
