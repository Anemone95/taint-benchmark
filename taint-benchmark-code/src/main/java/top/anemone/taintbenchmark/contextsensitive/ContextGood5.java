package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContextSensitive/ContextGood5")
@SuppressWarnings("Duplicates")
public class ContextGood5 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 误报说明1-callsite
     * @param request
     * @param response
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        Transformer bt=new BadTransformer();
        Transformer gt=new GoodTransformer();
        Container<Transformer> cbt=new Container<>();
        Container<Transformer> cgt=new Container<>();

        
        Runtime.getRuntime().exec(cgt.getObjObj(gt).transform(source));  // 获取good transformer
    }

}
