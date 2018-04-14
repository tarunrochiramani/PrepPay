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
        for (Project aProject : graph.getProjects()) {
            if (!visited.contains(aProject.getName())) {
                dfs(aProject, visited, sortedValues);
            }
        }

        String[] result = new String[sortedValues.size()];
        int pos = 0;
        while(!sortedValues.empty()) {
            result[pos++] = sortedValues.pop();
        }

        return result;
    }

    private void dfs(Project project, Set<String> visited, Stack<String> sortedValues) {
        if (project.getChildren().isEmpty()) {
            sortedValues.push(project.getName());
            return;
        }

        for (Project child : project.getChildren()) {
            if (!visited.contains(child.getName())) {
                visited.add(child.getName());
                dfs(child, visited, sortedValues);
            }
        }
        visited.add(project.getName());
        sortedValues.push(project.getName());
    }
}
