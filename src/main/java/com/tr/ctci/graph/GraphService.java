package com.tr.ctci.graph;

import java.util.List;

public class GraphService {

    public Graph createGraphNodes(String[] projectNames) {
        Graph graph = new Graph();
        for (String name : projectNames) {
            Project aProject = new Project();
            aProject.setName(name);
            graph.getProjects().add(aProject);
            graph.getProjectByName().put(name, aProject);
        }
        return graph;
    }

    public void addEdge(Graph graph, String fromProject, List<String> toProject) {
        Project project = graph.getProjectByName().get(fromProject);

        for (String dependentProjectName : toProject) {
            Project dependentProject = graph.getProjectByName().get(dependentProjectName);
            project.getChildren().add(dependentProject);
            dependentProject.incrementInbound();
        }
    }
}
