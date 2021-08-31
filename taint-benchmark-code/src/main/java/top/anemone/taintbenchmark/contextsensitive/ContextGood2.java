package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContextSensitive/ContextGood2")
@SuppressWarnings("Duplicates")
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
        
        Transformer bt=new BadTransformer();
        Transformer gt=new GoodTransformer();

        Container<Transformer> cbt=new Container<>();
        cbt.setObj(bt);
        Container<Transformer> cgt=new Container<>();
        cgt.setObj(gt);

        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(cgt.getObj().transform(source)); // 获取good transformer
    }

}
