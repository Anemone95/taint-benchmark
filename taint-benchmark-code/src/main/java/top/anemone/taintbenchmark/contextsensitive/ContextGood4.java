package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.BadTransformer;
import top.anemone.taintbenchmark.auxiliary.Container;
import top.anemone.taintbenchmark.auxiliary.GoodTransformer;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContextSensitive/ContextGood4")
@SuppressWarnings("Duplicates")
public class ContextGood4 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Transformer bt=new BadTransformer();
        Transformer gt=new GoodTransformer();
        Container<Transformer> cbt=new Container<>();
        cbt.setSetSetObj(bt);
        Container<Transformer> cgt=new Container<>();
        cgt.setSetSetObj(gt);

        PrintWriter out = response.getWriter();
        out.println(cgt.getObj().transform(source)); // 获取good transformer
    }

}
