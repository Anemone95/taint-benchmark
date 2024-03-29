package top.anemone.taintbenchmark.interprocedural;


import top.anemone.taintbenchmark.auxiliary.BadStaticSink;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InterProcedural/StaticBad2")
public class StaticBad2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        BadStaticSink.execute(source);
    }
}
