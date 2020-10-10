package top.anemone.taintbenchmark.interprocedural;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InterProcedural/PrivateGood1")
public class PrivateGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        out.println(good(source)); // sink
    }
    private String good(String s){
        return "good";
    }
}
