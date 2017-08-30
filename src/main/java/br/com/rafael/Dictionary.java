package br.com.rafael;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This dictionary is responsible for store all the lines(words) of a file.
 */
public class Dictionary {

    private HashMap<String, String> words = new HashMap<>();

    private List<String> wordList = new ArrayList<>();

    private int maxNumberOfLetters;

    public Dictionary(int maxNumberOfLetters) {
        this.maxNumberOfLetters = maxNumberOfLetters;
    }

    /**
     * Constructor a dictionary.
     * @param filePath the path of file to be loaded.
     * @param maxNumberOfLetters the max number of letter allowed per word.
     * @throws IOException if something goes wrong when read the file.
     */
    public Dictionary(String filePath, int maxNumberOfLetters) throws IOException {
        this.maxNumberOfLetters = maxNumberOfLetters;

        wordList = Files.lines(Paths.get(filePath), Charset.forName("ISO-8859-1"))
                .filter(word -> word.length() <= maxNumberOfLetters)
                .collect(Collectors.toList());

        wordList.forEach(word -> this.words.put(word, word));
    }

    /**
     * Add the word to the dictionary if the number of letter is lower or equal
     * the number of letter allowed per word.
     * @param word to be added in the dictionary.
     */
    public void add(String word) {
        if (word.length() <= this.maxNumberOfLetters) {
            words.put(word, word);
            wordList.add(word);
        }
    }

    /**
     * Returns the word if it exists in the dictionary.
     * @param word the word to be found in the dictionary.
     * @return the word if exists in the dictionary otherwise null.
     */
    public String get(String word) {
        return words.get(word);
    }

    /**
     * Get a copy of all words loaded.
     * @return {@link List<String>} word list.
     */
    public List<String> getWordList() {
        return new ArrayList<>(this.wordList);
    }

    /**
     * Get the max number of letter allowed for each word.
     * @return number of letter allowed per word.
     */
    public int getMaxNumberOfLetters() {
        return maxNumberOfLetters;
    }
}
