package top.anemone.taintbenchmark.flowsensitive;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowBad5")
public class FlowBad5 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        String fakeClean="clean";
        String tmp;
        // fakeSource, fakeClean=fakeClean, fakeSource
        tmp=source;
        fakeClean=tmp;
        source=fakeClean;

        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(source); // get source
    }
}
