package pl.edu.agh.cs.ds;

import lombok.Getter;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZooWatcher implements Watcher {

    private final DataMonitor dataMonitor;
    @Getter
    private final String znode;
    @Getter
    private final ZooKeeper zooKeeper;

    public ZooWatcher(String hostPort, String znode, String exec) throws IOException {
        this.znode = znode;
        ProgramExecutionController programExecutionController = new ProgramExecutionController(exec);
        zooKeeper = new ZooKeeper(hostPort, 3000, this);
        dataMonitor = new DataMonitor(zooKeeper, znode, programExecutionController);
        dataMonitor.startWatch();

    }

    public void process(WatchedEvent event) {
        dataMonitor.process(event);
    }

}
