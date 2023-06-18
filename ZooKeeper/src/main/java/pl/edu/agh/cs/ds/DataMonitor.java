package pl.edu.agh.cs.ds;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class DataMonitor implements Watcher, AsyncCallback.StatCallback, AsyncCallback.Children2Callback {

    private final ZooKeeper zooKeeper;
    private final String znode;
    private int previousChildNum = -1;
    private final ProgramExecutor programController;

    public DataMonitor(ZooKeeper zooKeeper, String znode, ProgramExecutor programController) {
        this.zooKeeper = zooKeeper;
        this.znode = znode;
        this.programController = programController;
        watch();
    }

    public void watch() {
        zooKeeper.exists(znode, true, this, null);
    }

    public void startWatch() {
        watch();
        this.countChildrenNode(znode);
    }

    private int countChildrenNode(String name) {
        zooKeeper.getChildren(name, true, this, null);
        int s = 1;
        try {
            List<String> children = this.zooKeeper.getChildren(name, false);
            for (String child : children) {
                s += this.countChildrenNode(name + "/" + child);
            }
        } catch (KeeperException.NoNodeException e) {
            // ignore
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    public void process(WatchedEvent event) {
        watch();
    }

    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        switch (KeeperException.Code.get(rc)) {
            case OK -> programController.startProgram();
            case NONODE -> programController.stopProgram();
            case SESSIONEXPIRED, NOAUTH -> {
            }
            default -> zooKeeper.exists(znode, true, this, null);
        }
    }

    @Override
    public void processResult(int rc, String s, Object o, List<String> list, Stat stat) {
        int newSum = this.countChildrenNode(znode);
        if (newSum != this.previousChildNum) {
            this.previousChildNum = newSum;
            if (rc == KeeperException.Code.OK.intValue()) {
                System.out.println("/z node number of children has changed. \nCurrent value: " + (newSum - 1));
            }
        }
    }

}