package top.anemone.taintbenchmark.differentscope.thirdpartpkg;


import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ThirdPart/CommonSinkBad1")
public class CommonSinkBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        CommandLine cmd=CommandLine.parse(source);
        int i=new DefaultExecutor().execute(cmd);
    }
}
