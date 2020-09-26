package top.anemone.taintbenchmarkdep;

import java.io.IOException;

public class ExeAgent2 {
    public void exe(Executor e, String taint) throws IOException {
        e.exe(taint);
    }
}
