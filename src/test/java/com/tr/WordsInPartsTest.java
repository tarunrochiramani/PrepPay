package com.tr;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class WordsInPartsTest {
    private WordsInParts wordsInParts = new WordsInParts();

    @Test
    public void canFindSubStrings() {
        String[] words = new String[] {"Apple", "Watermelon"};
        String[] parts = new String[] {"a", "le", "mel", "lon"};
        List<String> substrings = wordsInParts.findSubstrings(words, parts);

        assertNotNull(substrings);
        assertFalse(substrings.isEmpty());
        assertTrue(substrings.contains("App[le]"));
        assertTrue(substrings.contains("Water[mel]on"));
    }
}
