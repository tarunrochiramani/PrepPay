package com.tr.ctci.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphService {

    public GraphWithProjectNodes createGraphWithProjectNodes(String[] projectNames) {
        GraphWithProjectNodes graphWithProjectNodes = new GraphWithProjectNodes();
        for (String name : projectNames) {
            Project aProject = new Project();
            aProject.setName(name);
            graphWithProjectNodes.getProjects().add(aProject);
            graphWithProjectNodes.getProjectByName().put(name, aProject);
        }
        return graphWithProjectNodes;
    }

    public void addEdge(GraphWithProjectNodes graphWithProjectNodes, String fromProject, List<String> toProject) {
        Project project = graphWithProjectNodes.getProjectByName().get(fromProject);

        for (String dependentProjectName : toProject) {
            Project dependentProject = graphWithProjectNodes.getProjectByName().get(dependentProjectName);
            project.getChildren().add(dependentProject);
            dependentProject.incrementInbound();
        }
    }


    public Graph createGraph(String[] vertices, Map<String, List<String>> edges) {
        Graph graph = new Graph();
        Map<String, Node> nodeMap = new HashMap<>();
        for (String name : vertices) {
            Node node = new Node();
            node.setLabel(name);
            graph.getNodes().add(node);
            nodeMap.put(name, node);
        }

        for (Map.Entry<String, List<String>> edgeEntry : edges.entrySet()) {
            String fromNodeLabel = edgeEntry.getKey();
            Node fromNode = nodeMap.get(fromNodeLabel);

            for (String edgeLabel : edgeEntry.getValue()) {
                fromNode.getNodes().add(nodeMap.get(edgeLabel));
            }
        }

        return graph;
    }
}
