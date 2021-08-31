package top.anemone.taintbenchmark.contextsensitive;

import top.anemone.taintbenchmark.auxiliary.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ContextSensitive/ContextBad4")
@SuppressWarnings("Duplicates")
public class ContextBad4 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        Transformer bt=new BadTransformer();
        Transformer gt=new GoodTransformer();
        Container<Transformer> cbt=new Container<>();
        cbt.setSetSetObj(bt);
        Container<Transformer> cgt=new Container<>();
        cgt.setSetSetObj(gt);

        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(cbt.getObj().transform(source)); // 获取bad transformer
    }

}
