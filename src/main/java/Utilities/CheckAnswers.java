package Utilities;

import java.io.*;
import java.util.ArrayList;

public class CheckAnswers {
    public static ArrayList<Integer> getIncorrectAnswersIndices(ArrayList<String> answersFromCode, ArrayList<String> answersFromSite) {
        ArrayList<Integer> incorrectAnswers = new ArrayList<>();

        for (int i = 0; i < answersFromCode.size(); i++) {
            if (!answersFromCode.get(i).equals(answersFromSite.get(i))) {
                incorrectAnswers.add(i);
            }
        }
        return incorrectAnswers;
    }

    public static ArrayList<String> getAllFromTextFile(String answersFileName) throws Exception {
        FileReader fr = new FileReader("src/resources/" + answersFileName);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> answers = new ArrayList<>();

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            answers.add(line);
        }
        br.close();
        fr.close();
        return answers;
    }

    public static void printOutIncorrectInputs(ArrayList<Integer> indicesOfIncorrectAnswers, ArrayList<String> inputFromSite, ArrayList<String> correctAnswers) {
        for (Integer indicesOfIncorrectAnswer : indicesOfIncorrectAnswers) {
            System.out.println(inputFromSite.get(1 + (indicesOfIncorrectAnswer * 2)) + " " + correctAnswers.get(indicesOfIncorrectAnswer));
            System.out.println(inputFromSite.get(1 + (indicesOfIncorrectAnswer * 2) + 1));
        }
    }
}
