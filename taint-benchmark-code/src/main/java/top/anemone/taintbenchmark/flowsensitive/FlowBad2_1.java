package top.anemone.taintbenchmark.flowsensitive;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowBad2-1")
public class FlowBad2_1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        String ret;
        if (request.getParameter("fromp").equals("true")){
            ret=source;
        } else {
            ret="clean";
        }
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        out.println(ret); // sink
    }
}
