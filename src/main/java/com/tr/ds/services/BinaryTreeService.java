package com.tr.ds.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.tr.ds.BSTNode;

public class BinaryTreeService {

    public BSTNode createTree(Integer[] values) {
        BSTNode root = null;

        for (int value : values) {
            root = appendNode(root, value);
        }

        return root;
    }

    private BSTNode appendNode(BSTNode root, int value) {
        BSTNode newNode = new BSTNode();
        newNode.setValue(value);

        if (root == null) {
            return newNode;
        }

        Queue<BSTNode> bfsQ = new LinkedList<BSTNode>();
        bfsQ.add(root);
        while (!bfsQ.isEmpty()) {

            BSTNode polledElement = bfsQ.poll();

            if (polledElement.getLeft() == null) {
                polledElement.setLeft(newNode);
                break;
            } else if (polledElement.getRight() == null) {
                polledElement.setRight(newNode);
                break;
            } else {
                bfsQ.add(polledElement.getLeft());
                bfsQ.add(polledElement.getRight());

            }
        }

        return root;
    }

    public Integer[] bfsPath(BSTNode root) {
        List<Integer> retVal= new ArrayList<Integer>();
        Queue<BSTNode> bfsQ = new LinkedList<BSTNode>();
        bfsQ.add(root);
        while(!bfsQ.isEmpty()) {
            BSTNode polledElement = bfsQ.poll();
            retVal.add(polledElement.getValue());
            if (polledElement.getLeft() != null) {
                bfsQ.add(polledElement.getLeft());
            }
            if (polledElement.getRight() != null) {
                bfsQ.add(polledElement.getRight());
            }
        }

        Integer[] result = new Integer[retVal.size()];
        return retVal.toArray(result);
    }
    
    public int totalCountsWithSum(BSTNode root, int targetSum) {
        return totalCounts(root, new HashMap<Integer, Integer>(), targetSum, 0);
    }

    private int totalCounts(BSTNode root, Map<Integer, Integer> helper, int targetSum, int runningSum) {
        if (root == null) {
            return 0;
        }

        runningSum+= root.getValue();
        Integer sumCounts = helper.getOrDefault(runningSum, 0);
        helper.put(runningSum, sumCounts+1);

        int leftCounts = totalCounts(root.getLeft(), helper, targetSum, runningSum);
        int rightCounts = totalCounts(root.getRight(), helper, targetSum, runningSum);

        int currentCounts = leftCounts + rightCounts;
        if (runningSum == targetSum) {
            currentCounts ++;
        }

        currentCounts += helper.getOrDefault(runningSum - targetSum, 0);

        sumCounts = helper.get(runningSum) - 1;
        if (sumCounts > 0) {
            helper.put(runningSum, sumCounts);
        } else {
            helper.remove(runningSum);
        }

        return currentCounts;
    }


}