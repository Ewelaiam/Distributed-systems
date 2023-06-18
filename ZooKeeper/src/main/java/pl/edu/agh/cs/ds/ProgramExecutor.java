package pl.edu.agh.cs.ds;

import java.io.IOException;

public class ProgramExecutor {

    private final String execPath;
    private Process child;

    public ProgramExecutor(String execPath) {
        this.execPath = execPath;
    }

    public void startProgram() {
        if (child == null) {
            try {
                child = Runtime.getRuntime().exec(execPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopProgram() {
        if (child != null) {
            child.destroyForcibly();
            try {
                child.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            child = null;
        }
    }
}

