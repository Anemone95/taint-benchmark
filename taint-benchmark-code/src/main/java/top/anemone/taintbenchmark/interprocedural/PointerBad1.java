package top.anemone.taintbenchmark.interprocedural;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class PointerBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");

        Container c=new Container();
        c.setXss("clean");

        Container fakeGood=new Container();
        fakeGood.next=c;
        Container bad=new Container();
        bad.next=c;

        bad.next.setXss(source);
        Container p=fakeGood;

        PrintWriter out = response.getWriter();
        out.println(p.next.getXss()); // sink
    }
}
