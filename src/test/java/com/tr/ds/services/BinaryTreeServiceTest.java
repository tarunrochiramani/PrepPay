package com.tr.ds.services;

import com.tr.ds.BSTNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BinaryTreeServiceTest {
    BinaryTreeService binaryTreeService = new BinaryTreeService();

    @Test
    public void canCreateBinaryTree() {
        Integer[] input = {1, 2, 3, 4, 5, -1, -2, -3, -4};
        BSTNode root = binaryTreeService.createTree(input);

        Integer[] bfsPath = binaryTreeService.bfsPath(root);
        assertArrayEquals(input, bfsPath);
    }

    @Test
    public void canGetTotalCountsWithSum() {
        Integer[] input = {10, 5, 1, 2, -1, -1, 7, 1, 2};
        BSTNode root = binaryTreeService.createTree(input);

        int result = binaryTreeService.totalCountsWithSum(root, 8);

        assertEquals(2, result);
    }
}
