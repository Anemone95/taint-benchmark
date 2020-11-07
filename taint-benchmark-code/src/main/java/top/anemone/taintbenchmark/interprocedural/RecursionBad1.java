package top.anemone.taintbenchmark.interprocedural;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 */
@WebServlet("/InterProcedural/RecursionBad1")
public class RecursionBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss"); // source
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        bad(source, out, 0);
    }

    private void bad(String s, PrintWriter out, int l) {
        if (l>100) return;
        bad(s, out,l+1);
        out.println(s); // sink
    }
}
