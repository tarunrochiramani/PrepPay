package com.tr.ds.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.tr.ctci.linklist.Palindrome;
import com.tr.ds.BSTNode;
import com.tr.exceptions.InvalidInputException;

public class BSTService {
    public BSTNode createTree(int[] values) throws InvalidInputException {
        BSTNode head = null;

        for(int value : values) {
            if (head == null) {
                head = new BSTNode();
                head.setValue(value);
            } else {
                append(head, value);
            }
        }

        return head;
    }

    public void append(BSTNode head, int value) throws InvalidInputException {
        if (head == null) {
            throw new InvalidInputException();
        }
        BSTNode current = head;
        BSTNode previous = null;
        while (current != null) {
            previous = current;
            if (value <= current.getValue()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        BSTNode newNode = new BSTNode();
        newNode.setValue(value);

        if (value <= previous.getValue()) {
            previous.setLeft(newNode);
        } else {
            previous.setRight(newNode);
        }
    }

    public int maxDepth(BSTNode treenode) {
        if (treenode == null) {
            return 0;
        }

        if (treenode.getLeft() == null && treenode.getRight() == null) {
            return 1;
        }

        int leftDepth = maxDepth(treenode.getLeft());
        int rightDepth = maxDepth(treenode.getRight());

        int currentMax = leftDepth >= rightDepth ? leftDepth : rightDepth;

        return currentMax+1;
    }

    public void printInorder(BSTNode head) {
        if (head == null) {
            return;
        }
        printInorder(head.getLeft());
        System.out.println(head.getValue());
        printInorder(head.getRight());
    }

    public boolean hasPathSum(BSTNode treenode, int sum) {
        if (treenode == null) {
            return false;
        }

        if (treenode.getValue() > sum) {
            return false;
        }

        if (treenode.getValue() == sum && treenode.getLeft() == null && treenode.getRight() == null) {
            return true;
        }

        int remainingSum = sum - treenode.getValue();
        boolean leftHasPathSum = hasPathSum(treenode.getLeft(), remainingSum);
        if (leftHasPathSum) {
            return true;
        }

        return hasPathSum(treenode.getRight(), remainingSum);
    }

    public String printPaths(BSTNode treeNode) throws InvalidInputException {
        List<BSTNode> nodesVisited = new ArrayList<BSTNode>();
        StringBuilder stringBuilder = new StringBuilder();
        printPaths(treeNode, nodesVisited, stringBuilder);
        return stringBuilder.toString();
    }

    public void mirror(BSTNode treeNode) throws InvalidInputException {
        if (treeNode == null) {
            throw new InvalidInputException();
        }

        if (treeNode.getLeft() != null) {
            mirror(treeNode.getLeft());
        }

        if (treeNode.getRight() != null) {
            mirror(treeNode.getRight());
        }

        BSTNode temp = treeNode.getLeft();
        treeNode.setLeft(treeNode.getRight());
        treeNode.setRight(temp);
    }

    public void doubleTree(BSTNode treeNode) {
        if (treeNode == null) {
            return;
        }

        doubleTree(treeNode.getLeft());

        BSTNode newnode = new BSTNode();
        newnode.setValue(treeNode.getValue());
        newnode.setLeft(treeNode.getLeft());
        treeNode.setLeft(newnode);

        doubleTree(treeNode.getRight());
    }

    private void printPaths(BSTNode treeNode, List<BSTNode> nodesVisited, StringBuilder stringBuilder) throws InvalidInputException {
        if (treeNode == null) {
            throw new InvalidInputException();
        }

        if (treeNode.getLeft() == null && treeNode.getRight() == null) {
            for (BSTNode node : nodesVisited) {
                stringBuilder.append(node.getValue());
                stringBuilder.append(" -> ");
            }
            stringBuilder.append(treeNode.getValue());
            stringBuilder.append("\n");
            return;
        }

        nodesVisited.add(treeNode);
        if (treeNode.getLeft() != null) {
            printPaths(treeNode.getLeft(), nodesVisited, stringBuilder);
        }

        if (treeNode.getRight() != null) {
            printPaths(treeNode.getRight(), nodesVisited, stringBuilder);
        }
        nodesVisited.remove(treeNode);
    }

    public Map<Integer, List<BSTNode>> listOfNodesAtEachLayer(BSTNode root) throws InvalidInputException {
        if (root == null) {
            throw new InvalidInputException();
        }

        Map<Integer, List<BSTNode>> listOfNodesByDepth = new HashMap<Integer, List<BSTNode>>();
        listOfNodesAtEachLayer(root, 1, listOfNodesByDepth);
        return listOfNodesByDepth;

    }

    public List<List<Integer>> getAllBSTSequences(BSTNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> sequences = new ArrayList<List<Integer>>();

        List<List<Integer>> leftSequences = getAllBSTSequences(root.getLeft());
        List<List<Integer>> rightSequences = getAllBSTSequences(root.getRight());

        if (leftSequences.isEmpty() && rightSequences.isEmpty()) {
            List<Integer> aSequence = new ArrayList<Integer>();
            aSequence.add(root.getValue());
            sequences.add(aSequence);
            return sequences;
        }

        if (leftSequences.isEmpty()) {
            for (List<Integer> rightSequence : rightSequences) {
                List<Integer> aSequence = new ArrayList<Integer>();
                aSequence.add(root.getValue());
                aSequence.addAll(rightSequence);
                sequences.add(aSequence);
            }
        } else if (rightSequences.isEmpty()) {
            for (List<Integer> leftSequence : leftSequences) {
                List<Integer> aSequence = new ArrayList<Integer>();
                aSequence.add(root.getValue());
                aSequence.addAll(leftSequence);
                sequences.add(aSequence);
            }
        } else {
            for (List<Integer> leftSequence : leftSequences) {
                for (List<Integer> rightSequence : rightSequences) {
                    List<Integer> aSequence = new ArrayList<Integer>();
                    aSequence.add(root.getValue());
                    aSequence.addAll(leftSequence);
                    aSequence.addAll(rightSequence);
                    sequences.add(aSequence);
                }
            }

            for (List<Integer> rightSequence : rightSequences) {
                for (List<Integer> leftSequence : leftSequences) {
                    List<Integer> aSequence = new ArrayList<Integer>();
                    aSequence.add(root.getValue());
                    aSequence.addAll(rightSequence);
                    aSequence.addAll(leftSequence);
                    sequences.add(aSequence);
                }
            }
        }

        return sequences;
    }

    private void listOfNodesAtEachLayer(BSTNode treeNode, int depth, Map<Integer, List<BSTNode>> listOfNodesByDepth) {
        if (treeNode == null) {
            return;
        }

        if (!listOfNodesByDepth.containsKey(depth)) {
            listOfNodesByDepth.put(depth, new ArrayList<BSTNode>());
        }
        listOfNodesByDepth.get(depth).add(treeNode);
        listOfNodesAtEachLayer(treeNode.getLeft(), depth + 1, listOfNodesByDepth);
        listOfNodesAtEachLayer(treeNode.getRight(), depth + 1, listOfNodesByDepth);
    }

    public boolean sameTree(BSTNode treenodeA, BSTNode treeNodeB) {
        if (treenodeA == null && treeNodeB == null) {
            return true;
        }

        if (treenodeA == null || treeNodeB == null) {
            return false;
        }

        if (treenodeA.getValue() != treeNodeB.getValue()) {
            return false;
        }

        boolean leftsAreSame = sameTree(treenodeA.getLeft(), treeNodeB.getLeft());
        if (!leftsAreSame) {
            return false;
        }
        boolean rightsAreSame = sameTree(treenodeA.getRight(), treeNodeB.getRight());

        return leftsAreSame & rightsAreSame;
    }
}
