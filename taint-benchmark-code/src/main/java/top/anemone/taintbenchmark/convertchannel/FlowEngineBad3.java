package top.anemone.taintbenchmark.convertchannel;

import top.anemone.taintbenchmark.auxiliary.CommandEngExecutor;
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

@WebServlet("/convertchannel/FlowEngineBad3")
public class FlowEngineBad3 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        String[] input={source};
        String[] out=new String[3];
        Map<String,EngExecutor> executorMap=new HashMap<>();
        executorMap.put("input", new InputEngExecutor());
        executorMap.put("command", new CommandEngExecutor());
        String[] seq={"input", "command"};
        for (String e : seq) {
            executorMap.get(e).exec(input,out);
        }
    }
}
