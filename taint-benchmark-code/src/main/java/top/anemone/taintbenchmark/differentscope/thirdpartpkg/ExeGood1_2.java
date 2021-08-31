package top.anemone.taintbenchmark.differentscope.thirdpartpkg;

import top.anemone.taintbenchmarkdep.ExeAgent1;
import top.anemone.taintbenchmarkdep.Executor;
import top.anemone.taintbenchmarkdep.GoodExecutor2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class ExeGood1_2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        Executor e=new GoodExecutor2();
        e.setcmd(source);
        ExeAgent1 exeAgent1=new ExeAgent1();
        exeAgent1.exe(e); //sink
    }
}
