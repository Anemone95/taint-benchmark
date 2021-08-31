package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.BadTransformer;
import top.anemone.taintbenchmark.auxiliary.GoodTransformer;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContextSensitive/ContextGood1")
public class ContextGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        

        Transformer bt = new BadTransformer();
        Transformer gt = new GoodTransformer();
        Transformer pbt = id(bt);
        Transformer pgt = id(gt);

        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(pgt.transform(source)); // 获取good transformer
    }

    /**
     * @param n=pbt,pgt
     * @return
     */
    public Transformer id(Transformer n) {
        return n;
    }
}
