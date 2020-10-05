package top.anemone.taintbenchmark.flowsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/intraprocedural/IntraBad1")
public class FlowFieldGood6 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Container fakeBad, fakeClean, tmp;
        fakeBad=new Container(source,source);
        fakeClean=new Container("clean","clean");
        tmp=fakeBad;
        fakeBad=fakeClean;
        fakeClean=tmp;
        PrintWriter out = response.getWriter();
        out.println(fakeBad.xss); // get clean
    }

    public static void main(String[] args) {
            String source = "xss";
            Container clean, bad, tmp;
            clean=new Container(source,source);
            bad=new Container("clean","clean");
            tmp=clean;
            clean=bad;
            bad=tmp;
            System.out.println(clean.getXss());
    }
}
