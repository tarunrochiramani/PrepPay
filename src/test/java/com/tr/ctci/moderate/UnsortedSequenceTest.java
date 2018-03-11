package com.tr.ctci.moderate;

import com.tr.exceptions.InvalidInputException;
import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class UnsortedSequenceTest {
    private UnsortedSequence unsortedSequence = new UnsortedSequence();

    @Test
    public void canFindUnsortedSequence() throws InvalidInputException {
        Pair<Integer, Integer> unsortedSequence = this.unsortedSequence.findUnsortedSequence(new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19});

        Assert.assertNotNull(unsortedSequence);
        Assert.assertEquals(2, unsortedSequence.getKey().intValue());
        Assert.assertEquals(10, unsortedSequence.getValue().intValue());

    }
}
