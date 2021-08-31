package top.anemone.taintbenchmark.convertchannel;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/convertchannel/IfBad1")
public class IfBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        PrintWriter out = response.getWriter();
        if (source.equals("hello world")) {
            source = "hello world";
        }
        Runtime.getRuntime().exec(source); // sink
    }
}
