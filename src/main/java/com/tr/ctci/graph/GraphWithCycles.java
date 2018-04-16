package com.tr.ctci.graph;

import java.util.HashSet;
import java.util.Set;

public class GraphWithCycles {
    public int countCycles(Graph graph) {
        Set<Node> visitingNodes = new HashSet<>();
        Set<Node> visitedNodes = new HashSet<>();
        int count = 0;
        for (Node node : graph.getNodes()) {
            if (!visitedNodes.contains(node)) {
                count += dfs(node, visitingNodes, visitedNodes);
            }
        }

        return count;
    }

    private int dfs(Node node, Set<Node> visitingNodes, Set<Node> visitedNodes) {
        int count = 0;
        if (visitingNodes.contains(node)) {
            return count+1;
        }

        visitingNodes.add(node);
        for (Node connectingNode : node.getNodes()) {
            if (!visitedNodes.contains(connectingNode)) {
                count += dfs(connectingNode, visitingNodes, visitedNodes);
            }
        }
        visitedNodes.add(node);
        visitingNodes.remove(node);

        return count;
    }
}
