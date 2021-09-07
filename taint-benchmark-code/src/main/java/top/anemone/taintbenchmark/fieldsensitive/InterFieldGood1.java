package top.anemone.taintbenchmark.fieldsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FieldSensitive/FieldBad1")
@SuppressWarnings("Duplicates")
public class InterFieldGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        Container<String> a = new Container<>();
        a.setObj("clean");
        a.setClean("clean");
        put(a, source);
        
        Runtime.getRuntime().exec(a.getObj()); // sink
    }
    private void put(Container<String> c, String s){
        c.setClean(s);
    }
}
