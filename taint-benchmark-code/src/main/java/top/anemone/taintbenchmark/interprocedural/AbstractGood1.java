package top.anemone.taintbenchmark.interprocedural;


import top.anemone.taintbenchmark.auxiliary.BadPasser;
import top.anemone.taintbenchmark.auxiliary.GoodPasser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 该类误报很可能扫描器使用CHA构建调用图
 */
@WebServlet("/InterProcedural/AbstractGood1")
public class AbstractGood1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("source");
        
        BadPasser passer=new GoodPasser();
        source=passer.transform(source);
        
        Runtime.getRuntime().exec(source); // sink
    }
}
