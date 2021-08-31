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

@WebServlet("/ContextSensitive/ContextBad1")
public class ContextBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Transformer bt = new BadTransformer();
        Transformer gt = new GoodTransformer();
        Transformer pbt = id(bt);
        Transformer pgt = id(gt);

        Runtime.getRuntime().exec(pbt.transform(source)); // 获取bad transformer
    }

    /**
     * @param n=pbt,pgt
     * @return
     */
    public Transformer id(Transformer n) {
        return n;
    }
}
