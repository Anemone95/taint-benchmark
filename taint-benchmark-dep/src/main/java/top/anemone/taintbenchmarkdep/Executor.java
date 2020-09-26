package top.anemone.taintbenchmarkdep;

import java.io.IOException;

public interface Executor {
    void setcmd(String s);
    String getcmd();
    Process exe(String exe) throws IOException;
}
