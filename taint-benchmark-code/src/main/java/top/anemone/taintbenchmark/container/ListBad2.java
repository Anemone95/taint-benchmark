package top.anemone.taintbenchmark.container;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * 污点存储在列表的第0个元素中，sink点取出第0个元素，因此存在漏洞
 */
@WebServlet("/container/ListBad1")
public class ListBad2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        List<String> list=new LinkedList<>();
        list.add("nonce");
        list.add(source);
        list.remove(0);
        Runtime.getRuntime().exec(list.get(0));
    }
}
