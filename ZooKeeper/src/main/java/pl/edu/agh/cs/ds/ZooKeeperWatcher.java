package pl.edu.agh.cs.ds;

import lombok.Getter;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZooKeeperWatcher implements Watcher {

    private final DataMonitor dataMonitor;
    @Getter
    private final String znode;
    @Getter
    private final ZooKeeper zooKeeper;

    public ZooKeeperWatcher(String hostPort, String znode, String execPath) throws IOException {
        this.znode = znode;
        zooKeeper = new ZooKeeper(hostPort, 3500, this);
        dataMonitor = new DataMonitor(zooKeeper, znode, new ProgramExecutor(execPath));
        dataMonitor.startWatch();
    }

    public void process(WatchedEvent event) {
        dataMonitor.process(event);
    }

}
