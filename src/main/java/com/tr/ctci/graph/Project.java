package com.tr.ctci.graph;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private List<Project> children = new ArrayList<>();
    private int inbound = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getChildren() {
        return children;
    }

    public void setChildren(List<Project> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return name != null ? name.equals(project.name) : project.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void incrementInbound() {
        inbound++;
    }

    public void decrementInbound() {
        inbound--;
    }

    public int getInbound() {
        return inbound;
    }
}
