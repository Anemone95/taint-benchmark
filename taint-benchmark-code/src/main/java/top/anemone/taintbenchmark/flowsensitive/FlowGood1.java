package top.anemone.taintbenchmark.flowsensitive;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowGood1")
public class FlowGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fakeSource = request.getParameter("xss");
        response.setContentType("text/html;");
        String fakeClean="clean";
        String tmp;
        // fakeSource, fakeClean=fakeClean, fakeSource
        tmp=fakeSource;
        fakeSource=fakeClean;
        fakeClean=tmp;

        PrintWriter out = response.getWriter();
        out.println(fakeSource); // get clean
    }
}
