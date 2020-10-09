package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowFieldBad6")
public class FlowFieldBad6 extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Container<String> inner;
        Container<Container<String>> outer;
        Container<String> good=new Container<>();
        Container<String> bad=new Container<>();
        Container<Container<String>> goodc=new Container<>();
        Container<Container<String>> badc=new Container<>();
        int a = 31 + 1;
        if (a == 32) {
            outer=badc;
            inner=bad;
        } else {
            outer=goodc;
            inner=good;
        }
        outer.obj=inner;
        inner.setObj(source);
        PrintWriter out = response.getWriter();
        out.println(badc.getObj().getObj());
    }
}
