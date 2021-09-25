package top.anemone.taintbenchmark.thread;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

class ContentWriter implements Runnable{
    private Container<String> container;
    private String content;
    public ContentWriter(Container<String> container, String content){
        this.container=container;
        this.content=content;
    }

    @Override
    public void run() {
        container.setObj(content);
    }
}

class RceRunner implements Runnable{
    private PrintWriter writer;
    private Container<String> container;
    public RceRunner( Container<String> container){
        this.container=container;
    }

    @Override
    public void run() {
        while (true){
            if (container.getObj()!=null){
                try {
                    Runtime.getRuntime().exec(container.getObj());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}

@WebServlet("/Thread/ThreadBad1")
public class ThreadBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        response.setContentType("text/html;");
        Container<String> cache=new Container<>();
        RceRunner rceRunner =new RceRunner(cache);
        ContentWriter contentWriter=new ContentWriter(cache, source);
        Thread t1=new Thread(rceRunner);
        t1.start();
        Thread t2=new Thread(contentWriter);
        t2.start();
    }

}