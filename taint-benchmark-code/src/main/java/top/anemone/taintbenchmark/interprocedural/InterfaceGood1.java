package top.anemone.taintbenchmark.interprocedural;

import top.anemone.taintbenchmark.auxiliary.GoodTransformer;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 该类误报很可能扫描器使用CHA构建调用图
 */
@WebServlet("/InterProcedural/InterfaceGood1")
public class InterfaceGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        Transformer transformer=new GoodTransformer();
        source = transformer.transform(source);
        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(source); // sink
    }
}
