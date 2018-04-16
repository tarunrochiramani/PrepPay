package com.tr.ctci.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    /*
    Works only for Directed ACyclic Graph
     */
    public String[] getSortedValues(Graph graph) {
        Set<String> visited = new HashSet<>();
        Stack<String> sortedValues = new Stack<>();
        for (Node node : graph.getNodes()) {
            if (!visited.contains(node.getLabel())) {
                dfs(node, visited, sortedValues);
            }
        }

        String[] result = new String[sortedValues.size()];
        int pos = 0;
        while(!sortedValues.empty()) {
            result[pos++] = sortedValues.pop();
        }

        return result;
    }

    private void dfs(Node node, Set<String> visited, Stack<String> sortedValues) {
        if (node.getNodes().isEmpty()) {
            sortedValues.push(node.getLabel());
            return;
        }

        for (Node child : node.getNodes()) {
            if (!visited.contains(child.getLabel())) {
                visited.add(child.getLabel());
                dfs(child, visited, sortedValues);
            }
        }
        visited.add(node.getLabel());
        sortedValues.push(node.getLabel());
    }
}
