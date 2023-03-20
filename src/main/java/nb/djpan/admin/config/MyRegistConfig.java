package nb.djpan.admin.config;

import lombok.extern.slf4j.Slf4j;
import nb.djpan.admin.servlet.MyFilter;
import nb.djpan.admin.servlet.MyListener;
import nb.djpan.admin.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * ClassName:MyRegistConfig
 * Package:nb.djpan.admin.config
 *
 * @Author:pjz
 * @Create:2023/3/19
 * @Description: 注入原生的Servlet Filter Listener
 */
@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();
        ServletRegistrationBean<MyServlet> mssrb = new ServletRegistrationBean<>(myServlet, "/MyServlet", "/My...");
        return mssrb;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter = new MyFilter();
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>(myFilter);
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return myFilterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MyListener myListener = new MyListener();
        ServletListenerRegistrationBean<MyListener> myListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(myListener);
        return myListenerServletListenerRegistrationBean;
    }
}
