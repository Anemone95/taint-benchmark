package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class FlowFieldBad6 extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Container inner;
        Container outer;
        Container good=new Container();
        Container bad=new Container();
        Container goodc=new Container();
        Container badc=new Container();
        int a = 31 + 1;
        if (a == 32) {
            outer=badc;
            inner=bad;
        } else {
            outer=goodc;
            inner=good;
        }
        outer.next=inner;
        inner.setXss(source);
        PrintWriter out = response.getWriter();
        out.println(bad.getXss());
    }
}
