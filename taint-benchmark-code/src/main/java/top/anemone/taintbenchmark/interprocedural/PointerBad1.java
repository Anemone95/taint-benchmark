package top.anemone.taintbenchmark.interprocedural;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IntraProcedural/PointerBad1")
public class PointerBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 未做域敏感或者未做指针分析
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("source");
        

        Container<String> c=new Container<>();
        c.setObj("clean");

        Container<Container<String>> fakeGood=new Container<>();
        fakeGood.obj=c;
        Container<Container<String>> bad=new Container<>();
        bad.obj=c;

        bad.obj.setObj(source);
        Container<Container<String>> p=fakeGood;

        
        Runtime.getRuntime().exec(p.obj.getObj()); // sink
    }
}
