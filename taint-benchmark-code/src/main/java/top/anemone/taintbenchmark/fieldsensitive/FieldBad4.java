package top.anemone.taintbenchmark.fieldsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FieldSensitive/FieldBad4")
@SuppressWarnings("Duplicates")
public class FieldBad4 extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Container<String> c=new Container<>();
        Container<Container<String>> c2=new Container<>();
        Container<Container<String>> c3;
        c.setObj("clean");
        c2.setObj(c);
        c3=c2;
        c3.getObj().setObj(source);

        Runtime.getRuntime().exec(c2.getObj().getObj()); // sink
    }
}
