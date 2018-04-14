package com.tr.ctci.graph;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class TopologicalSortTest {
    private TopologicalSort topologicalSort = new TopologicalSort();
    private GraphService graphService = new GraphService();

    @Test
    public void canGetBuildOrder() {
        Graph graph = createGraph();
        graphService.addEdge(graph, "f", Arrays.asList("c", "b", "a"));
        graphService.addEdge(graph,"c", Arrays.asList("a"));
        graphService.addEdge(graph,"b", Arrays.asList("a", "e"));
        graphService.addEdge(graph,"a", Arrays.asList("e"));
        graphService.addEdge(graph,"d", Arrays.asList("g"));

        String[] buildOrder = topologicalSort.getSortedValues(graph);

        assertTrue(buildOrder.length > 0);
        assertArrayEquals(new String[] {"f", "d", "g", "c", "b", "a", "e"}, buildOrder);

    }

    private Graph createGraph() {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        Graph graph = graphService.createGraphNodes(projects);

        return graph;
    }
}
