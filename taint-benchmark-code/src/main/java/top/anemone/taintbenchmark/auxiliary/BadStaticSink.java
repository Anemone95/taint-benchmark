package top.anemone.taintbenchmark.auxiliary;

import java.io.IOException;

/**
 * @author wenyuan.xwy@alibaba-inc.com
 * @date 2021/8/25 16:31
 */
public class BadStaticSink {
    public static void execute(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
    }
}
