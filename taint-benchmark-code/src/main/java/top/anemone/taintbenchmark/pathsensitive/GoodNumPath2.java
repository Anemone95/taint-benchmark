package top.anemone.taintbenchmark.pathsensitive;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * @author anemone(anemone95@qq.com)
 * @date 2021/8/31 16:57
 */
@WebServlet("/flow/BadNumPath2")
public class GoodNumPath2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source;
        int x = new Random().nextInt();
        if (x * (x + 1) % 2 == 0) {
            source = "clean";
        } else {
            source = request.getParameter("source");
        }
        Runtime.getRuntime().exec(source);
    }
}
