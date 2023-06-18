package pl.edu.agh.cs.ds;

import java.util.Iterator;
import java.util.List;

public class TreeNode {
    private final String nodeName;
    private final List<TreeNode> children;

    public TreeNode(String nodeName, List<TreeNode> children) {
        this.nodeName = nodeName;
        this.children = children;
    }

    private void addNextLevel(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix).append(nodeName).append('\n');
        for (Iterator<TreeNode> iterator = children.iterator(); iterator.hasNext();) {
            TreeNode next = iterator.next();
            if (iterator.hasNext()) {
                next.addNextLevel(buffer, childrenPrefix + "├──> ", childrenPrefix + "│   ");
            } else {
                next.addNextLevel(buffer, childrenPrefix + "└──> ", childrenPrefix + "    ");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder(75);
        addNextLevel(buffer, "", "");
        return buffer.toString();
    }
}
