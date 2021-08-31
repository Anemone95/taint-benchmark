package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Transformer;
import top.anemone.taintbenchmark.auxiliary.TransformerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Factory/IntraBad1")
public class FactoryBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        Transformer t = TransformerFactory.getTransformer("bad");
        
        Runtime.getRuntime().exec(t.transform(source)); // sink
    }
}
