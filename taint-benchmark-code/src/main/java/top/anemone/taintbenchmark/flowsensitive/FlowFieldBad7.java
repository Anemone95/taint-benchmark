package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowFieldBad7")
public class FlowFieldBad7 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Container<String> bad, fakeClean, tmp;
        bad=new Container<>(source,source);
        fakeClean=new Container<>("clean","clean");
        tmp=bad;
        fakeClean=tmp;
        bad=fakeClean;
        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(bad.obj); // get clean
    }
}
