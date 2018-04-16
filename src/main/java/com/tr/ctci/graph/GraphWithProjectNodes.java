package com.tr.ctci.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphWithProjectNodes {
    private List<Project> projects = new ArrayList<>();
    private Map<String, Project> projectByName = new HashMap<>();

    public List<Project> getProjects() {
        return projects;
    }

    public Map<String, Project> getProjectByName() {
        return projectByName;
    }
}
