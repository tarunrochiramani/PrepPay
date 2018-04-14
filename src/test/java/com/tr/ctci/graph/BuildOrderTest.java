package com.tr.ctci.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class BuildOrderTest {

    private BuildOrder buildOrder = new BuildOrder();

    @Test
    public void canGetBuildOrder() {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        Map<String, List<String>> projectDependencies = new HashMap<>();
        projectDependencies.put("f", Arrays.asList("c", "b", "a"));
        projectDependencies.put("c", Arrays.asList("a"));
        projectDependencies.put("b", Arrays.asList("a", "e"));
        projectDependencies.put("a", Arrays.asList("e"));
        projectDependencies.put("d", Arrays.asList("g"));

        String[] buildOrder = this.buildOrder.getBuildOrder(projects, projectDependencies);

        assertTrue(buildOrder.length > 0);
        assertArrayEquals(new String[] {"d", "f", "g", "c", "b", "a", "e"}, buildOrder);

    }

    @Test
    public void canGetReducedBuildOrderWithCyclicGraph() {
        String[] projects = new String[]{"a", "b", "c", "d", "e", "f", "g"};
        Map<String, List<String>> projectDependencies = new HashMap<>();
        projectDependencies.put("f", Arrays.asList("c", "b", "a"));
        projectDependencies.put("c", Arrays.asList("a"));
        projectDependencies.put("b", Arrays.asList("a", "e"));
        projectDependencies.put("a", Arrays.asList("e"));
        projectDependencies.put("e", Arrays.asList("c"));
        projectDependencies.put("d", Arrays.asList("g"));

        String[] buildOrder = this.buildOrder.getBuildOrder(projects, projectDependencies);

        assertTrue(buildOrder.length > 0);
        assertArrayEquals(new String[] {"d", "f", "g", "b"}, buildOrder);

    }
}
