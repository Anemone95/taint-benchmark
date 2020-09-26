package top.anemone.taintbenchmarkdep;

import java.io.IOException;

public class ExeAgent1 {
    public void exe(Executor taint) throws IOException {
        new BadExecutor().exe(taint.getcmd());
    }
}
