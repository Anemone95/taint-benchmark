package top.anemone.taintbenchmark.intraprocedural;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 如果该类被报出说明扫描器不存在污点分析
 */
@WebServlet("/IntraProcedural/IntraGood1")
public class IntraGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        source = "foo";
        
        
        Runtime.getRuntime().exec(source); // sink
    }
}
