package top.anemone.taintbenchmark.interprocedural;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 最简单的污点分析模型，从request中读取内容并返回，造成xss
 */
@WebServlet("/InterProcedural/PrivateBad1")
public class PrivateBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss"); // source
        response.setContentType("text/html;");
        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(bad(source)); // sink
    }
    private String bad(String s){
        return s;
    }
}
