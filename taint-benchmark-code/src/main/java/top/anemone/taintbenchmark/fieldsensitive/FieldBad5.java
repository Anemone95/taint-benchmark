package top.anemone.taintbenchmark.fieldsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FieldSensitive/FieldBad5")
@SuppressWarnings("Duplicates")
public class FieldBad5 extends HttpServlet {

    private static final long serialVersionUID = 1L;


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Container<String> c=new Container<>();
        Container<String> c2=c;
        c2.obj=source;

        Runtime.getRuntime().exec(c.obj); // sink
    }
}
