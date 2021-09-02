package top.anemone.taintbenchmark.auxiliary;

import java.io.IOException;

/**
 * @author anemone(anemone95@qq.com)
 * @date 2021/8/30 15:51
 */
public class CommandEngExecutor implements EngExecutor {

    @Override
    public void exec(String[] in, String[] out) throws IOException {
        Runtime.getRuntime().exec(out[0]);
    }
}
