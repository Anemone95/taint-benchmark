package top.anemone.taintbenchmark.pathsensitive;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author anemone(anemone95@qq.com)
 * @date 2021/8/31 16:57
 */
@WebServlet("/flow/BadNumPath2")
public class GoodStrPath2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source;
        source = request.getParameter("source");
        String x = "AB";
        if (x.charAt(0) == 'A') {
            return;
        } else {
            Runtime.getRuntime().exec(source);
        }
    }
}
