package nb.djpan.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName:LoginInterceptor
 * Package:nb.djpan.admin.interceptor
 *
 * @Author:pjz
 * @Create:2023/3/18
 * @Description: 登录检查
 * 1、配置好拦截器要拦截哪些请求
 * 2、把这些请求放在容器中
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取拦截的路径
        String requestURI = request.getRequestURI();
        log.info("preHandle拦截得请求路径是{}",requestURI);

        //登录检查的逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            //放行
            return true;
        }

        //拦截住请求，跳转到登录页面
        request.setAttribute("msg","请先登录！！！");
        //response.sendRedirect("/");
        request.getRequestDispatcher("/").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行的异常{}",ex);
    }
}
