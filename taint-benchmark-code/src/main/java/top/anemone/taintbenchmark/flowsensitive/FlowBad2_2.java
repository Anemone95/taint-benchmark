package top.anemone.taintbenchmark.flowsensitive;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/FlowBad2")
public class FlowBad2_2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        String ret;
        if (request.getParameter("fromp").equals("true")){
            ret="clean";
        } else {
            ret=source;
        }
        
        
        Runtime.getRuntime().exec(ret); // sink
    }
}
