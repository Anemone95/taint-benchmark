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

@WebServlet("/ContextSensitive/ContextBad6")
@SuppressWarnings("Duplicates")
public class ContextBad6 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        Transformer bt=new BadTransformer();
        Transformer gt=new GoodTransformer();
        Container<Transformer> cbt=new Container<>();
        Container<Transformer> cgt=new Container<>();

        
        Runtime.getRuntime().exec(cbt.getObjObjObj(bt).transform(source)); // 获取bad transformer
    }

}
