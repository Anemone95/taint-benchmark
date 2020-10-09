package top.anemone.taintbenchmark.convertchannel;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/convertchannel/ExceptionBad3")
public class ExceptionBad3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        String ret="clean";
        try {
            ret=source;
            throw new RuntimeException();
        } catch (RuntimeException f) { // Not valid!
            PrintWriter out = response.getWriter();
            out.println(ret); // sink
        }

    }
}
