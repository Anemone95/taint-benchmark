package top.anemone.taintbenchmark.flowsensitive;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowGood5")
public class FlowGood5 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fakeSource = request.getParameter("xss");
        
        String fakeClean="clean";
        String tmp;
        // fakeSource, fakeClean=fakeClean, fakeSource
        tmp=fakeSource;
        fakeSource=fakeClean;
        fakeClean=tmp;

        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(fakeSource); // get clean
    }
}
