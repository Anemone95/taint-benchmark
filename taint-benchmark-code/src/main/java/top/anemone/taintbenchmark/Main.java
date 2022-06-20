package top.anemone.taintbenchmark;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.Wrapper;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.reflections.Reflections;
import top.anemone.taintbenchmark.auxiliary.Container;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Set;


public class Main extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;");
        response.getWriter().write("index");
    }

    public static void main(String[] args) throws Exception {

        Tomcat tomcat = new Tomcat();
        // 设置主机名称
        tomcat.setHostname("localhost");
        tomcat.setPort(8080);
        tomcat.setBaseDir(System.getProperty("user.dir"));
        StandardContext context = new StandardContext();
        // 设置资源路径
        context.setDocBase(System.getProperty("user.dir") + "/taint-benchmark-code/src/main/resources".replace("/", "\\"));
        // 设置应用路径
        context.setPath("/");
        context.addLifecycleListener(new Tomcat.FixContextListener());
        // 将context加入tomcat
        tomcat.getHost().addChild(context);
        Wrapper testServlet = context.createWrapper();
        testServlet.setName("DefaultServlet");
        testServlet.setServletClass(DefaultServlet.class.getCanonicalName());
        testServlet.addInitParameter("fork", "false");
        testServlet.addInitParameter("listings", "true");
        context.addChild(testServlet);
        context.addServletMapping("/", "DefaultServlet");


        Reflections reflections = new Reflections("top.anemone.taintbenchmark");
        //获取带Handler注解的类
        Set<Class<?>> classList = reflections.getTypesAnnotatedWith(javax.servlet.annotation.WebServlet.class);

        for (Class<?> clazz : classList) {
            WebServlet declaredAnnotation = clazz.getDeclaredAnnotation(WebServlet.class);

            // 在context中创建表示servlet的Wrapper并返回
            Wrapper testServlet1 = context.createWrapper();
            testServlet1.setName(clazz.getSimpleName());
            testServlet1.setServletClass(clazz.getCanonicalName());
            testServlet1.addInitParameter("fork", "false");
            context.addChild(testServlet1);
            context.addServletMapping(declaredAnnotation.value()[0], clazz.getSimpleName());
        }


        try {
            // 启动tomcat
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        // 等待请求
        tomcat.getServer().await();
    }
}
