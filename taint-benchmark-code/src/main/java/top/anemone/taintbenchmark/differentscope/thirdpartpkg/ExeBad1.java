package top.anemone.taintbenchmark.differentscope.thirdpartpkg;

import top.anemone.taintbenchmarkdep.BadExecutor;
import top.anemone.taintbenchmarkdep.ExeAgent1;
import top.anemone.taintbenchmarkdep.Executor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ThirdPart/ExeBad1")
public class ExeBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        Executor e=new BadExecutor();
        e.setcmd(source);
        ExeAgent1 exeAgent1=new ExeAgent1();
        exeAgent1.exe(e);
        out.println(source); // sink
    }

}
