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
public class PointerGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 如果报出那么无指针分析
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");

        Container c=new Container();
        c.setXss(source);

        Container good=new Container();
        good.next=c;
        Container bad=new Container();
        bad.next=c;

        good.next.setXss("clean");
        Container p=bad;

        PrintWriter out = response.getWriter();
        out.println(p.next.getXss()); // sink
    }
}
