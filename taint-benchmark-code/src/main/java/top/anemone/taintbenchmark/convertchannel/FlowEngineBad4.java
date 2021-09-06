package top.anemone.taintbenchmark.convertchannel;

import top.anemone.taintbenchmark.auxiliary.CommandEngExecutor;
import top.anemone.taintbenchmark.auxiliary.Container;
import top.anemone.taintbenchmark.auxiliary.EngExecutor;
import top.anemone.taintbenchmark.auxiliary.InputEngExecutor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anemone(anemone95@qq.com)
 * @date 2021/8/31 17:47
 */

@WebServlet("/convertchannel/FlowEngineBad4")
public class FlowEngineBad4 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Container<String> container=new Container<>();
        container.clean=source;
        EngExecutor inputExecutor = new InputEngExecutor();
        EngExecutor commandExecutor = new CommandEngExecutor();
        String[] seq = {"input", "command"};
        for (String e : seq) {
            if (e.equals("command")){
                commandExecutor.exec(container);
            } else if (e.equals("input")){
                inputExecutor.exec(container);
            }
        }
    }
}
