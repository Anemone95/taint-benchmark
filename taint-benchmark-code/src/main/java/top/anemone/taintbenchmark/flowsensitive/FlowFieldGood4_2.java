package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class FlowFieldGood4_2 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Container c;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        c=new Container("foo","bar");
        PrintWriter out = response.getWriter();
        out.println(c.getXss()); // sink before taint
        c.setXss(source);
    }
}
