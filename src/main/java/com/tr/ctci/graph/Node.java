package com.tr.ctci.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String label;
    private List<Node> nodes = new ArrayList<>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
