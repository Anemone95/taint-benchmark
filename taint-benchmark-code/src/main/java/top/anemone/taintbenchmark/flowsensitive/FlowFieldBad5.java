package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.BadContainer;
import top.anemone.taintbenchmark.auxiliary.Container;
import top.anemone.taintbenchmark.auxiliary.GoodContainer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowFieldBad5")
public class FlowFieldBad5 extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Container<String> c;
        int a = 31 + 1;
        if (a == 32) {
            c = new BadContainer<>();
        } else {
            c = new GoodContainer<>();
        }
        c.setObj(source);
        c.setClean("clean");
        PrintWriter out = response.getWriter();
        out.println(c.getInfo()); // sink
    }
}
