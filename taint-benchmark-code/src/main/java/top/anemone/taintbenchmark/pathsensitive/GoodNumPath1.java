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
@WebServlet("/flow/GoodPath1")
public class GoodNumPath1 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source;
        int x = 86;
        if ((7*42)-x <200){
            source = "clean";
        } else {
            source = request.getParameter("source");
        }
        Runtime.getRuntime().exec(source);
    }
}
