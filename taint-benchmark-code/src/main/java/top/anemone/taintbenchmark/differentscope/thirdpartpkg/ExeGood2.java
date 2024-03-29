package top.anemone.taintbenchmark.differentscope.thirdpartpkg;

import top.anemone.taintbenchmarkdep.ExeAgent2;
import top.anemone.taintbenchmarkdep.Executor;
import top.anemone.taintbenchmarkdep.GoodExecutor1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ThirdPart/ExeGood2")
public class ExeGood2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        Executor e=new GoodExecutor1();
        e.setcmd(source);
        ExeAgent2 exeAgent2=new ExeAgent2();
        exeAgent2.exe(e,source); //sink
    }
}
