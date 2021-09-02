package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/flow/FlowFieldBad7")
public class FlowFieldBad9_2 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");

        Container<String> bad = new Container<>();
        Container<String> bad2 = bad;

        if (new Random().nextFloat()<0.5){
            bad2.obj="Clean";
        }else {
            bad2.obj=source;
        }

        Runtime.getRuntime().exec(bad.obj); // get clean
    }
}
