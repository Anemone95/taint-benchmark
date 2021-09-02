package top.anemone.taintbenchmark.container;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/container/MapBad1")
public class MapBad3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Map<String,String> map=new HashMap<>();
        map.put("source",source);
        map.put("boo","bar");
        Map<String,String> map1=new HashMap<>();
        map1.putAll(map);
        Runtime.getRuntime().exec(map1.get("source"));
    }
}
