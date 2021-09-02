package top.anemone.taintbenchmark.convertchannel;

import top.anemone.taintbenchmark.auxiliary.CommandEngExecutor;
import top.anemone.taintbenchmark.auxiliary.EngExecutor;
import top.anemone.taintbenchmark.auxiliary.InputEngExecutor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author anemone(anemone95@qq.com)
 * @date 2021/8/31 17:47
 */

@WebServlet("/convertchannel/FlowEngineGood4")
public class FlowEngineGood4 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        String[] input = {source};
        String[] out = new String[3];
        EngExecutor inputExecutor = new InputEngExecutor();
        EngExecutor commandExecutor = new CommandEngExecutor();
        String[] seq = {"command", "input"};
        for (String e : seq) {
            if (e.equals("command")) {
                commandExecutor.exec(input, out);
            } else if (e.equals("input")) {
                inputExecutor.exec(input, out);
            }
        }
    }
}
