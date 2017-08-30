package br.com.rafael;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class KataTest {

    private Kata kata;

    @Before
    public void setUp() {
        kata = new Kata();
    }

    @Test
    public void testProcessWithValidInput() {

        List<String> words =
                Arrays.asList("con",
                "bums",
                "al",
                "albums",
                "bar",
                "ely",
                "barely",
                "be",
                "foul",
                "befoul",
                "vex",
                "convex",
                "here",
                "by",
                "hereby",
                "jig",
                "saw",
                "jigsaw",
                "or",
                "tail",
                "tailor",
                "we",
                "aver",
                "weaver");


        Dictionary dictionary = new Dictionary(6);
        words.stream().forEach(dictionary::add);

        kata.process(dictionary);
        Assert.assertEquals(8, kata.getWordsFound().size());

    }

    @Test
    public void testProcessWithEmptyDictionary() {
        Dictionary dictionary = new Dictionary(6);
        kata.process(dictionary);
        Assert.assertTrue(kata.getWordsFound().isEmpty());
    }

    @Test
    public void testProcessWithEmptyResult() {
        Dictionary dictionary = new Dictionary(6);
        Arrays.asList("Rafael", "Peretta", "Santos").forEach(dictionary::add);
        kata.process(dictionary);
        Assert.assertEquals(0, kata.getWordsFound().size());
    }
}
