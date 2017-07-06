package com.tr.ds.services;

import com.tr.ds.BSTNode;
import com.tr.exceptions.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class BSTServiceTest {
    BSTService service = new BSTService();

    @Test
    public void canCreate() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};

        BSTNode root = service.createTree(values);

        assertNotNull(root);
        assertEquals(values.length, assertIsBST(root));
    }

    private int assertIsBST(BSTNode root) {
        int countOfNodes = 0;
        if (root == null) {
            return countOfNodes;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return ++countOfNodes;
        }

        if (root.getLeft() != null) {

            assertTrue(root.getLeft().getValue() <= root.getValue());
            countOfNodes += assertIsBST(root.getLeft());
        }

        if (root.getRight() != null) {

            assertTrue(root.getRight().getValue() > root.getValue());
            countOfNodes += assertIsBST(root.getRight());
        }

        return ++countOfNodes;
    }
}
