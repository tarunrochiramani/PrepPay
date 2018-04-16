package com.tr.ctci.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        String[] buildOrder = topologicalSort.getSortedValues(graph);

        assertTrue(buildOrder.length > 0);
        assertArrayEquals(new String[] {"f", "d", "g", "c", "b", "a", "e"}, buildOrder);

    }

    private Graph createGraph() {
        String[] vertices = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("f", Arrays.asList("c", "b", "a"));
        edges.put("c", Arrays.asList("a"));
        edges.put("b", Arrays.asList("a", "e"));
        edges.put("a", Arrays.asList("e"));
        edges.put("d", Arrays.asList("g"));

        return graphService.createGraph(vertices, edges);
    }
}
