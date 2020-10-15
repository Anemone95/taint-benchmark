package top.anemone.taintbenchmark.differentscope.thirdpartpkg;

import top.anemone.taintbenchmarkdep.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class ExeBad2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Executor e=new GoodExecutor2();
        e.setcmd(source);
        ExeAgent2 exeAgent2=new ExeAgent2();
        exeAgent2.exe(e,source); //sink
    }
}
