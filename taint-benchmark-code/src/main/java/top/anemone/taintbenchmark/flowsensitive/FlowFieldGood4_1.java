package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowFieldBad4_1")
public class FlowFieldGood4_1 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Container<String> c;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        c=new Container<>(source,"boo");
        c.setObj("clean");
        
        Runtime.getRuntime().exec(c.getObj()); // sink before taint
        c.setObj(source);
    }
}
