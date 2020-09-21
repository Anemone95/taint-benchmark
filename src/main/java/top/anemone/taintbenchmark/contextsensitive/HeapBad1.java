package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.BadTransformer;
import top.anemone.taintbenchmark.auxiliary.Container;
import top.anemone.taintbenchmark.auxiliary.GoodTransformer;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/ContextBad1")
public class HeapBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        String clean = new String("clean");
        Container bad=newContainer(source);
        Container good=newContainer(clean);

        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        out.println(bad.getXss()); // sink
    }

    private Container newContainer(String s) {
        Container c = new Container(); //这里未做heap sensitive那么任何上下文指向的对象永远为o34
        c.setXss(s);
        return c;
    }
}
