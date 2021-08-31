package top.anemone.taintbenchmark.fieldsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FieldSensitive/FieldGood3")
@SuppressWarnings("Duplicates")
public class FieldGood3 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Container<String> c;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        c=new Container<>();
        c.setObj(source);
        c.setClean("clean");
        
        Runtime.getRuntime().exec(c.getClean()); // sink
    }
}
