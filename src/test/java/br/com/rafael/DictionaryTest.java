package br.com.rafael;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class DictionaryTest {

    private Dictionary dictionary;

    @Before
    public void setUp() {
        dictionary = new Dictionary(6);
    }

    public void addWordToDictionary() {
        Arrays.asList("Rafael", "Peretta", "Santos").forEach(word -> dictionary.add(word));
    }

    @Test
    public void testAdd() {
        addWordToDictionary();
        Assert.assertEquals(2, dictionary.getWordList().size());
    }

    @Test
    public void testGetWordThatExistsInTheDictionary() {
        addWordToDictionary();
        String word = "Rafael";
        Assert.assertEquals(word, dictionary.get(word));
    }

    @Test
    public void testGetWordThatDoesNotExistsInTheDictionary() {
        addWordToDictionary();
        String word = "Test";
        Assert.assertEquals(null, dictionary.get(word));
    }

    @Test
    public void testGetWordList() {
        addWordToDictionary();
        Assert.assertEquals(2, dictionary.getWordList().size());
    }
}
