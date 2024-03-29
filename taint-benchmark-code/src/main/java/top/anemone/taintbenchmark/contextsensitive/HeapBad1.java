package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContextSensitive/HeapBad1")
@SuppressWarnings("Duplicates")
public class HeapBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        String clean = new String("clean");
        Container bad=newContainer(source);
        Container good=newContainer(clean);

        
        
        Runtime.getRuntime().exec((String) bad.getObj()); // sink
    }

    private Container newContainer(String s) {
        Container<String> c = new Container<>(); //这里未做heap sensitive那么任何上下文指向的对象永远为o34
        c.setObj(s);
        return c;
    }
}
