package br.com.rafael;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {

    private List<String> wordsFound = new ArrayList<>();

    /**
     * This method is responsible for process the dictionary to looking for all words which is composed
     * of two concatenated smaller words.
     * @param dictionary with words.
     */
    public void process(Dictionary dictionary) {

        List<String> words = dictionary.getWordList();

        List<String> smallWords = words.stream()
                .filter(word -> word.length() < dictionary.getMaxNumberOfLetters())
                .collect(Collectors.toList());

        String currentWord;
        String startWord;
        String endWord;
        String inverted;

        for (int i = 0; i < smallWords.size(); i++) {
            startWord = smallWords.get(i);

            for (int x = i + 1; x < smallWords.size(); x++) {
                endWord = smallWords.get(x);

                // here two different combinations of words are checked to avoid reading the entire list twice.
                currentWord = startWord.concat(endWord);
                addWordIfExistsInDictionary(dictionary, currentWord);

                inverted = endWord.concat(startWord);
                addWordIfExistsInDictionary(dictionary, inverted);
            }
        }
    }

    /**
     * This method add the words found in an internal list.
     * @param dictionary with all the words.
     * @param word to check if exists in the dictionary.
     */
    private void addWordIfExistsInDictionary(Dictionary dictionary, String word) {
        String wordFound;
        wordFound = getWord(dictionary, word);

        if (wordFound != null) {
            wordsFound.add(wordFound);
        }
    }

    /**
     * Returns this list of words found
     * @return {@link List<String>} words found.
     */
    public List<String> getWordsFound() {
        return wordsFound;
    }

    private String getWord(Dictionary dictionary, String currentWord) {
        String wordFound = null;
        if (currentWord.length() == 6) {
            wordFound = dictionary.get(currentWord);
        }
        return wordFound;
    }
}
