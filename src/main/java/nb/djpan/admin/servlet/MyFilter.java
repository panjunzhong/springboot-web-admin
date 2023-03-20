package nb.djpan.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * ClassName:MyFilter
 * Package:nb.djpan.admin.servlet
 *
 * @Author:pjz
 * @Create:2023/3/19
 * @Description: 注入servlet中原生的过滤器Filter
 * @WebFilter (urlPatterns = {"/css/*"}) 拦截的请求可以写在路径里面
 */
@Slf4j
//@WebFilter(urlPatterns = {"/css/*"})
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("真正来实现过滤功能的doFilter方法");
    }

    @Override
    public void destroy() {
        log.info("Filter销毁");
    }
}
