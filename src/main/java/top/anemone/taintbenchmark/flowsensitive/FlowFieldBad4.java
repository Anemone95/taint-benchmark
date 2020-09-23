package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class FlowFieldBad4 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Container c;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        c=new Container(source,"boo");
        c.setXss(source);
        PrintWriter out = response.getWriter();
        out.println(c.getXss()); // sink before clean
        c.setXss("clean");
    }
}
