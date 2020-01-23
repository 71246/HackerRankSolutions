package TagContentExtractorPackage;

import java.util.Scanner;

public class TagContentExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        while (testCases > 0) {
            String line = in.nextLine();
            String startTag;
            String tempLine = "";
            boolean extractedUntilEmpty = false;
            int counter = 0;
            boolean alreadyPrinted = false;

            while (line.contains("<") && line.contains(">") && line.contains("/")) {
                startTag = line.substring(line.indexOf("<"), line.indexOf(">") + 1);

                if (startTag.contains("/") | startTag.length() == 2) {
                    line = line.substring(line.indexOf(startTag) + startTag.length());
                    if (line.length() == 0) System.out.println("None");
                    extractedUntilEmpty = true;
                } else {
                    String endTag = startTag.substring(0, 1) + "/" + startTag.substring(1);

                    if (line.contains(endTag) && endTag.length() > 3) {
                        String newLine = line.substring(line.indexOf(startTag) + startTag.length(), line.lastIndexOf(endTag));
                        line = line.substring(line.lastIndexOf(endTag) + endTag.length());

                        if (!newLine.contains("<") && !newLine.contains(">")) {
                            if (newLine.length() > 0) {
                                System.out.println(newLine);
                            } else {
                                System.out.println("None");
                            }

                            alreadyPrinted = true;

                            if (!tempLine.isEmpty()) {
                                line = tempLine;
                                tempLine = "";
                                counter++;
                            }
                        } else {
                            tempLine = line;
                            line = newLine;
                        }
                    } else {
                        line = line.substring(line.indexOf(startTag) + startTag.length());
                        if (line.length() == 0 && counter == 0 && !alreadyPrinted) System.out.println("None");
                    }
                }
            }

            if (!extractedUntilEmpty && !alreadyPrinted) {
                System.out.println("None");
            }
            testCases--;
        }
    }
}
