package br.com.rafael;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Kata kata = new Kata();

        String filePath = "wordlist.txt";

        int maxNumberOfWordLetters = 6;
        Dictionary dictionary = new Dictionary(filePath, maxNumberOfWordLetters);

        long startTime = System.currentTimeMillis();
        kata.process(dictionary);
        long executionTime = System.currentTimeMillis() - startTime;

        System.out.println("Number of words found: " + kata.getWordsFound().size());
        System.out.println("Execution Time: " + executionTime / 1000);
    }

}
