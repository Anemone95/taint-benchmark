package top.anemone.taintbenchmark.convertchannel;

import top.anemone.taintbenchmark.auxiliary.MyException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/convertchannel/ExceptionGood3")
public class ExceptionGood2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        String ret = "success";

        try {
            getString(source);
        } catch (MyException f) { // Not valid!
            ret = f.toString();
        }

        PrintWriter out = response.getWriter();
        Runtime.getRuntime().exec(ret); // sink
    }

    private String getString(String s) throws MyException {
        throw new MyException("clean");
    }
}
