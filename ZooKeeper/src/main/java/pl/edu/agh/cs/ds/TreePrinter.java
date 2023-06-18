package pl.edu.agh.cs.ds;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

public class TreePrinter {
    public static void printTree(String znode, ZooKeeper zooKeeper) {
        TreeNode tree = createTree(znode, zooKeeper, 0);
        if (tree == null) {
            System.out.println("Empty tree");
        } else {
            System.out.println("Tree structure:");
            System.out.println(tree);
        }
    }

    private static TreeNode createTree(String path, ZooKeeper zooKeeper, int indent) {
        List<TreeNode> children = new ArrayList<>();
        try {
            for (String child : zooKeeper.getChildren(path, false)) {
                children.add(createTree(path + "/" + child, zooKeeper, indent + 1));
            }
        } catch (KeeperException e) {
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TreeNode(path, children);
    }
}
