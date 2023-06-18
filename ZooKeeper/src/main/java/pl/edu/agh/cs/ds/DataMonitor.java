package pl.edu.agh.cs.ds;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class DataMonitor implements Watcher, AsyncCallback.StatCallback, AsyncCallback.Children2Callback {
    ZooKeeper zk;
    String znode;

    private int lastSum = -1;

    private final ProgramExecutionController programController;

    public DataMonitor(ZooKeeper zk, String znode, ProgramExecutionController programController) {
        this.zk = zk;
        this.znode = znode;
        this.programController = programController;
        watch();
    }

    public void watch() {
        zk.exists(znode, true, this, null);
    }

    public void startWatch() {
        zk.exists(znode, true, this, null);
        this.subscribeChildrenAndGetCount(znode);
    }

    private int subscribeChildrenAndGetCount(String childrenName) {
        zk.getChildren(childrenName, true, this, null);

        int sum = 1;
        try {
            List<String> children = this.zk.getChildren(childrenName, false);
            for (String child : children) {
                sum += this.subscribeChildrenAndGetCount(childrenName + "/" + child);
            }
        } catch (KeeperException.NoNodeException e) {
            //
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
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
            default -> zk.exists(znode, true, this, null);
        }
    }

    @Override
    public void processResult(int rc, String s, Object o, List<String> list, Stat stat) {
        int sum = this.subscribeChildrenAndGetCount(znode);
        if (sum != this.lastSum) {
            this.lastSum = sum;
            if (rc == KeeperException.Code.OK.intValue()) {
                System.out.println("Changed child of `z` node. There are: " + (sum - 1) + " children now.");
            }
        }
    }

}