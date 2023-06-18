package pl.edu.agh.cs.ds;

import java.util.Iterator;
import java.util.List;

public class TreeNode {

    final String name;
    final List<TreeNode> children;

    public TreeNode(String name, List<TreeNode> children) {
        this.name = name;
        this.children = children;
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        constructLowerLevel(buffer, "", "");
        return buffer.toString();
    }

    private void constructLowerLevel(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(name);
        buffer.append('\n');
        for (Iterator<TreeNode> it = children.iterator(); it.hasNext();) {
            TreeNode next = it.next();
            if (it.hasNext()) {
                next.constructLowerLevel(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            } else {
                next.constructLowerLevel(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
            }
        }
    }
}
