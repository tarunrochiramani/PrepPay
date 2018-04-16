package com.tr.ctci.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BuildOrder {
    private GraphService graphService = new GraphService();

    public String[] getBuildOrder(String[] projectNames, Map<String, List<String>> projectDependencies) {
        GraphWithProjectNodes graphWithProjectNodes = graphService.createGraphWithProjectNodes(projectNames);

        for (Map.Entry<String, List<String>> entry : projectDependencies.entrySet()) {
            graphService.addEdge(graphWithProjectNodes, entry.getKey(), entry.getValue());
        }

        List<String> orderedNames = new ArrayList<>();
        for(Project aProject : graphWithProjectNodes.getProjects()) {
            if (aProject.getInbound() == 0) {
                orderedNames.add(aProject.getName());
            }
        }

        int toBeProcessed = 0;
        while (toBeProcessed < orderedNames.size()) {
            Project currentProject = graphWithProjectNodes.getProjectByName().get(orderedNames.get(toBeProcessed));

            for (Project childProject : currentProject.getChildren()) {
                if (childProject.getInbound() > 0) {
                    childProject.decrementInbound();
                }

                if (childProject.getInbound() == 0) {
                    orderedNames.add(childProject.getName());
                }
            }
            toBeProcessed++;
        }


        String[] result = new String[orderedNames.size()];
        return orderedNames.toArray(result);
    }
}
