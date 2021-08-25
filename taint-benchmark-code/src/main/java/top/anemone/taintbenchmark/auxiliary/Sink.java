package top.anemone.taintbenchmark.auxiliary;

import java.io.IOException;

/**
 * @author wenyuan.xwy@alibaba-inc.com
 * @date 2021/8/25 16:14
 */
public interface Sink {
    void execute(String cmd) throws IOException;
}
