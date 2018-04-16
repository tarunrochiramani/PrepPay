package com.tr.ctci.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class GraphWithCyclesTest {
    private GraphService graphService = new GraphService();
    private GraphWithCycles graphWithCycles = new GraphWithCycles();

    @Test
    public void canCountGraphCyclesWhenNoCycle() {
        Graph graph = createGraph();

        assertEquals(0, graphWithCycles.countCycles(graph));
    }


    @Test
    public void canCountGraphCycles() {
        Graph graph = createCyclicGraph();

        assertEquals(3, graphWithCycles.countCycles(graph));
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

    private Graph createCyclicGraph() {
        String[] vertices = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        Map<String, List<String>> edges = new HashMap<>();
        edges.put("f", Arrays.asList("c", "b", "a"));
        edges.put("c", Arrays.asList("a"));
        edges.put("b", Arrays.asList("a", "e"));
        edges.put("a", Arrays.asList("e"));
        edges.put("e", Arrays.asList("c", "a"));
        edges.put("d", Arrays.asList("g"));
        edges.put("g", Arrays.asList("d"));

        return graphService.createGraph(vertices, edges);
    }

}
