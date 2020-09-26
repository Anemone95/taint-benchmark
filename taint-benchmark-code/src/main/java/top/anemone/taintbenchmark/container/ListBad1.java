package top.anemone.taintbenchmark.container;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/intraprocedural/IntraBad1")
public class ListBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        List<String> list=new LinkedList<>();
        list.add(source);
        list.add("nonce");
        PrintWriter out = response.getWriter();
        out.println(list.get(0)); // sink
    }
}
