package top.anemone.taintbenchmark.auxiliary;

import top.anemone.taintbenchmark.auxiliary.EngExecutor;

import java.io.IOException;

/**
 * @author anemone(anemone95@qq.com)
 * @date 2021/8/30 15:51
 */
public class InputEngExecutor implements EngExecutor {

    @Override
    public void exec(Container<String> container) throws IOException {
        container.obj=container.getClean();
    }
}
