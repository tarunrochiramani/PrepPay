package com.tr.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RemoveDupsFromSortedArrayTest {

    private RemoveDupsFromSortedArray removeDupsFromSortedArray = new RemoveDupsFromSortedArray();

    @Test
    public void canDoInplaceRemoval() {
        Assert.assertEquals(2, removeDupsFromSortedArray.inPlaceRemoveDups(new int[] {1, 1, 2}));
        Assert.assertEquals(6, removeDupsFromSortedArray.inPlaceRemoveDups(new int[] {1, 1, 1, 2, 2, 3, 4, 5, 5, 6}));
        Assert.assertEquals(7, removeDupsFromSortedArray.inPlaceRemoveDups(new int[] {1, 1, 1, 2, 2, 3, 4, 5, 5, 6, 7, 7, 7, 7, 7}));
    }
}
