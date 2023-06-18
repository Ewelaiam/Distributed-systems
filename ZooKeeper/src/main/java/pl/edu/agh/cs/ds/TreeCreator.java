package pl.edu.agh.cs.ds;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.util.ArrayList;
import java.util.List;

public class TreeCreator {
    public static void showTree(String znode, ZooKeeper zooKeeper) {
        TreeNode tree = createTree(znode, zooKeeper, 0);
        if (tree == null)
            System.out.println("Current tree structure: \n EMPTY");
        else
            System.out.println("Current tree structure: \n" + tree);
    }

    private static TreeNode createTree(String path, ZooKeeper zooKeeper, int indent) {
        List<TreeNode> children = new ArrayList<>();
        try {
            for (String child : zooKeeper.getChildren(path, false))
                children.add(createTree(path + "/" + child, zooKeeper, indent + 1));
        } catch (KeeperException e) {
            return null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TreeNode(path, children);
    }
}
