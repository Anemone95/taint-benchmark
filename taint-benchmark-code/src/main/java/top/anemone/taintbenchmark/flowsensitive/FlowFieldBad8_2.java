package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/flow/FlowFieldBad8_2")
public class FlowFieldBad8_2 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        Container<String> bad = new Container<>();
        if (new Random().nextFloat()<0.5){
            bad.obj="Clean";
        }else {
            bad.obj=source;
        }
            
        
        Runtime.getRuntime().exec(bad.obj); // get clean
    }
}
