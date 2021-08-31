package top.anemone.taintbenchmark.fieldsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FieldSensitive/FieldGood1")
@SuppressWarnings("Duplicates")
public class FieldGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        Container<String> a = new Container<>();
        a.setObj(source);
        a.setClean("clean");
        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(a.getClean()); // sink
    }
}
