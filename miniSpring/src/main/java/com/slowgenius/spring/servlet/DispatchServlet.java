package com.slowgenius.spring.servlet;

import com.slowgenius.demo.mvc.action.DemoAction;
import com.slowgenius.spring.annotation.Autowried;
import com.slowgenius.spring.annotation.Controller;
import com.slowgenius.spring.annotation.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author slowgenius
 * @date 2/19/2020 8:20 PM
 * @description
 */
public class DispatchServlet extends HttpServlet {

    private Properties contextConfig = new Properties();

    private Map<String, Object> beanMap = new ConcurrentHashMap<>();

    private List<String> classNames = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("==========调用doPost============");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //开始初始化

        //定位
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        
        //加载
        doScanner(contextConfig.getProperty("scanPackage"));

        //注册
        doRegistry();

        //自动依赖注入
        doAutoWired();

        DemoAction demoAction = (DemoAction) beanMap.get("demoAction");
        demoAction.query(null, null, "slowgenis");

        //SpringMVC会多一个handlerMapping
        //将@RequestMapping中配置的url和一个Method关联上
        //以便从浏览器获得用户输入的url后,能够找到具体的Method通过反射去调用
        initHandlerMapping();
    }

    private void initHandlerMapping() {
    }

    private void doRegistry() {
        if (classNames.isEmpty()) {
            return;
        }

        try {
            for (String classname : classNames) {
                Class<?> clazz = Class.forName(classname);
                //spring中用的多个子方法处理的
                if (clazz.isAnnotationPresent(Controller.class)) {
                    String beanName = lowerFistCase(clazz.getSimpleName());
                    //spring在这里不会直接put instance 是put的BeanDefinition
                    beanMap.put(beanName, clazz.newInstance());
                } else if (clazz.isAnnotationPresent(Service.class)) {

                    Service service = clazz.getAnnotation(Service.class);
                    //默认用类名首字母注入
                    //如果自己定义了beanName,那么优先试用自己定义的beanName
                    //如果是一个接口,使用接口的类型去自动注入

                    //spring中同样会分别调用不同的方法 autowriedByName() autowriedByType()

                    String beanName = service.value();
                    if ("".equals(beanName.trim())) {
                        beanName = lowerFistCase(clazz.getSimpleName());
                    }

                    Object instance = clazz.newInstance();
                    beanMap.put(beanName, instance);

                    Class<?>[] interfaces = clazz.getInterfaces();

                    for (Class<?> i : interfaces) {
                        beanMap.put(i.getName(), instance);
                    }
                } else {
                    continue;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //spring中是通过调用getBean()方法才触发注入依赖的
    private void doAutoWired() {
        if (beanMap.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : beanMap.entrySet()) {
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Autowried.class)) {
                    continue;
                }
                Autowried autowried = field.getAnnotation(Autowried.class);

                String beanName = autowried.value().trim();

                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }
                field.setAccessible(true);
                try {
                    field.set(entry.getValue(), beanMap.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void doScanner(String packageName) {
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(packageName + "." + file.getName());
            } else {
                classNames.add(packageName + "." + file.getName().replace(".class", ""));
            }
        }
    }

    private void doLoadConfig(String location) {
        //spring中是通过reader去查找定位的
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(location.replace("classpath:", ""));

        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String lowerFistCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
