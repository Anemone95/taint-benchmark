package top.anemone.taintbenchmark.soundiness.reflect;

import top.anemone.taintbenchmark.auxiliary.BadTransformer;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@WebServlet("/Soundiness/ReflectBad1")
public class ReflectBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        try {
            Class clazz = BadTransformer.class;
            Transformer transformer = (Transformer) clazz.newInstance();
            Method m = clazz.getDeclaredMethod("transform", String.class);
            source = (String) m.invoke(transformer, source);
            
            Runtime.getRuntime().exec(source); // sink
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
