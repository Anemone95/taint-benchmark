package top.anemone.taintbenchmark.convertchannel;

import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author anemone(anemone95@qq.com)
 * @date 2021/9/1 14:23
 */

class ContentWriter implements Runnable {
    private Container<String> container;
    private String content;

    public ContentWriter(Container<String> container, String content) {
        this.container = container;
    }

    @Override
    public void run() {
        container.setObj(content);
    }
}

class RceRunner implements Runnable {
    private Container<String> container;

    public RceRunner(Container<String> container) {
        this.container = container;
    }

    @Override
    public void run() {
        while (true) {
            if (container.getObj() != null) {
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

public class ThreadBad1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        Container<String> c = new Container<>();
        Thread t1 = new Thread(new RceRunner(c));
        Thread t2 = new Thread(new ContentWriter(c, source));
        t1.start();
        t2.start();
    }
}
