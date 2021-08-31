package top.anemone.taintbenchmark.intraprocedural;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/IntraProcedural/IntraBad1")
public class IntraBad2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        source=source+"source";
        source=source.replace("1","2");
        source=source+1;
        
        Runtime.getRuntime().exec(source); // sink
    }
}
