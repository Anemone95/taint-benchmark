package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.BadTransformer;
import top.anemone.taintbenchmark.auxiliary.Context;
import top.anemone.taintbenchmark.auxiliary.GoodTransformer;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow/ContextGood1")
public class ContextGood2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 误报说明上下文非敏感
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Transformer bt=new BadTransformer();
        Transformer gt=new GoodTransformer();
        Context cbt=new Context();
        cbt.setT(bt);
        Context cgt=new Context();
        cgt.setT(gt);

        PrintWriter out = response.getWriter();
        out.println(cgt.getT().transform(source)); // sink
    }

}
