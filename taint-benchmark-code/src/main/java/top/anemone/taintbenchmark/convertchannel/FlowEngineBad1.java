package top.anemone.taintbenchmark.convertchannel;

import top.anemone.taintbenchmark.auxiliary.CommandEngExecutor;
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

@WebServlet("/convertchannel/FlowEngineBad1")
public class FlowEngineBad1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        String[] input={source};
        String[] out=new String[3];
        new InputEngExecutor().exec(input,out);
        new CommandEngExecutor().exec(input,out);
    }
}
