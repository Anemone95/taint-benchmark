package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.BadTransformer;
import top.anemone.taintbenchmark.auxiliary.GoodConstructor;
import top.anemone.taintbenchmark.auxiliary.GoodTransformer;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/ContextBad1")
public class ContextBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Transformer bt=new BadTransformer();
        Transformer gt=new GoodTransformer();
        Transformer pbt=prettyTransformer(bt);
        Transformer pgt=prettyTransformer(gt);

        PrintWriter out = response.getWriter();
        out.println(pbt.transform(source)); // sink
    }

    /**
     *
     * @param n=pbt,pgt
     * @return
     */
    public Transformer prettyTransformer(Transformer n){
        return n;
    }
}
