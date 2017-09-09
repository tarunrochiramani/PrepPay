package com.tr.ds.services;

import java.util.List;
import java.util.Map;

import com.tr.ds.BSTNode;
import com.tr.exceptions.InvalidInputException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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

    @Test
    public void cantGetMaxDepthForBalancedTree() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        int maxDepth = service.maxDepth(root);

        assertTrue(maxDepth > 0);
        assertEquals(4 , maxDepth);
    }

    @Test
    public void cantGetMaxDepthForUnBalancedTree() throws InvalidInputException {
        int[] values = new int[] {1, 2, 3, 4, 5};
        BSTNode root = service.createTree(values);

        int maxDepth = service.maxDepth(root);

        assertTrue(maxDepth > 0);
        assertEquals(5 , maxDepth);
    }

    @Test
    public void doesHaveSumForOneNode() throws InvalidInputException {
        int[] values = new int[] {5};
        BSTNode root = service.createTree(values);

        assertTrue(service.hasPathSum(root, 5));
        assertFalse(service.hasPathSum(root, 10));
    }

    @Test
    public void doesHaveSum() throws InvalidInputException {
        int[] values = new int[] {10, 20, 8, 9, 4, 4};
        BSTNode root = service.createTree(values);

        assertTrue(service.hasPathSum(root, 27));
    }

    @Test
    public void canPrintPaths() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        String paths = service.printPaths(root);

        assertNotNull(paths);
        System.out.println(paths);
    }

    @Test
    public void canMirror() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        service.mirror(root);

        int countOfNodes = assertMirrorBST(root);
        assertEquals(values.length, countOfNodes);
    }

    @Test
    public void canDoubleTree() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        service.doubleTree(root);
        service.printInorder(root);

        int countOfNode = assertIsBST(root);
        assertEquals(values.length * 2, countOfNode);
    }

    @Test
    public void isSameTree() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        assertTrue(service.sameTree(root, root));
    }

    @Test
    public void isSameTreeWithNoNodes() throws InvalidInputException {
        BSTNode root = null;

        assertTrue(service.sameTree(root, root));
    }

    @Test
    public void areNotSameTree() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        int[] values1 = new int[] {3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root1 = service.createTree(values1);

        assertFalse(service.sameTree(root, root1));
    }


    @Test
    public void canGetListOfNodesAtEachDepth() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        Map<Integer, List<BSTNode>> listOfNodesAtEachLayer = service.listOfNodesAtEachLayer(root);

        assertNotNull(listOfNodesAtEachLayer);
        assertFalse(listOfNodesAtEachLayer.isEmpty());
    }

    @Test
    public void canGetAllSequences() throws InvalidInputException {
        int[] values = new int[] {7, 3, 9, 2, 4, 8, 10, 5 ,1};
        BSTNode root = service.createTree(values);

        List<List<Integer>> allBSTSequences = service.getAllBSTSequences(root);

        assertNotNull(allBSTSequences);
        assertFalse(allBSTSequences.isEmpty());
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

    private int assertMirrorBST(BSTNode root) {
        int countOfNodes = 0;
        if (root == null) {
            return countOfNodes;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return ++countOfNodes;
        }

        if (root.getLeft() != null) {

            assertTrue(root.getLeft().getValue() > root.getValue());
            countOfNodes += assertMirrorBST(root.getLeft());
        }

        if (root.getRight() != null) {

            assertTrue(root.getRight().getValue() <= root.getValue());
            countOfNodes += assertMirrorBST(root.getRight());
        }

        return ++countOfNodes;
    }
}
