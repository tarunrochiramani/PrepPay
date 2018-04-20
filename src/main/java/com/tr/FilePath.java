package com.tr;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FilePath {

    /**
     *
     * @param structure - 0|root,1|dir1,2|file1.txt,1|dir2,2|file2.txt,1|file3.txt
     * @param target
     * @return
     */
    public String getFilePath(String structure, String target) {
        Node rootNode = createTree(structure);

        Stack<String> path = new Stack<>();
        dfs(rootNode, target, path);

        StringBuilder stringBuilder = new StringBuilder();
        while(!path.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(path.pop());
        }

        return stringBuilder.toString();
    }

    public boolean dfs(Node aNode, String target, Stack<String> pathCollector) {
        if (aNode.getName().equals(target)) {
            pathCollector.push(aNode.getName());
            return true;
        }

        if (aNode.getChildren() != null) {
            for (Node child : aNode.getChildren()) {
                boolean found = dfs(child, target, pathCollector);
                if (found) {
                    pathCollector.push(aNode.getName());
                    return true;
                }
            }
        }

        return false;

    }

    protected Node createTree(String structure) {
        String[] elements = structure.split(",");
        List<Stack<Node>> levelNodes = new ArrayList<>();

        int previousLevel = 0;
        for (String element : elements) {
            String[] levelAndElement = element.split("\\|");
            Node aNode = new Node();
            aNode.setName(levelAndElement[1]);

            int level = Integer.valueOf(levelAndElement[0]);
            while (previousLevel > level) {
                levelNodes.get(previousLevel).pop();
                previousLevel--;
            }

            if (level > 0) {
                Node parent = levelNodes.get(level - 1).peek();
                if (parent.getChildren() == null) {
                    parent.setChildren(new ArrayList<>());
                }
                parent.getChildren().add(aNode);
            }


            if (!aNode.getName().contains(".")) {
                if (levelNodes.size() == level) {
                    levelNodes.add(new Stack<>());
                }
                Stack<Node> currentLevelStack = levelNodes.get(level);
                currentLevelStack.push(aNode);
                previousLevel = level;
            }
        }
        return levelNodes.get(0).peek();
    }
}


class Node {
    private String name;
    private List<Node> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}