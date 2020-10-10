package top.anemone.taintbenchmark.interprocedural;


import top.anemone.taintbenchmark.auxiliary.BadPasser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IntraProcedural/IntraBad1")
public class AbstractBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        BadPasser passer=new BadPasser();
        source=passer.transform(source);
        PrintWriter out = response.getWriter();
        out.println(source); // sink
    }
}
