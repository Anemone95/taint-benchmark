package top.anemone.taintbenchmark.auxiliary;

import java.io.IOException;

/**
 * @author wenyuan.xwy@alibaba-inc.com
 * @date 2021/8/25 16:14
 */
public class BadSink implements Sink {

    @Override
    public void execute(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }
}
