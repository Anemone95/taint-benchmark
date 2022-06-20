package top.anemone.taintbenchmark.withfrontend;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AuxiliaryBackend")
public class AuxiliaryBackend extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("application/json");
        response.getWriter().write("{\"resp\": \""+source+"\"}");
    }

}
