package top.anemone.taintbenchmark.interprocedural;

import top.anemone.taintbenchmark.auxiliary.BadSink;
import top.anemone.taintbenchmark.auxiliary.Sink;
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
@WebServlet("/IntraProcedural/InterfaceBad3")
public class InterfaceBad3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Sink sink=new BadSink();
        sink.execute(source);
    }
}
