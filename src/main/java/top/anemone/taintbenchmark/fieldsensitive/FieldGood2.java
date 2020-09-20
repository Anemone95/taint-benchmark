package top.anemone.taintbenchmark.fieldsensitive;


import top.anemone.taintbenchmark.auxiliary.Clazz1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class FieldGood2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Clazz1 a = new Clazz1();
        a.setXss(source);
        a.setClean("clean");
        Clazz1 b = id(a);
        PrintWriter out = response.getWriter();
        out.println(b.getClean()); // sink
    }

    public Clazz1 id(Clazz1 a) {
        return a;
    }
}
