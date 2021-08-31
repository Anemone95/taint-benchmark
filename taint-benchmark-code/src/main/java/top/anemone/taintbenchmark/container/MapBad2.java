package top.anemone.taintbenchmark.container;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/container/MapBad2")
public class MapBad2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Map<String,String> map=new HashMap<>();
        String s="xss";
        map.put(s,source);
        map.put("boo","bar");
        Runtime.getRuntime().exec(map.get(s));
    }
}
