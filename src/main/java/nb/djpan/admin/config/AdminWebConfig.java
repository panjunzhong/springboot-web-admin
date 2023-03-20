package nb.djpan.admin.config;

import nb.djpan.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName:AdminWebConfig
 * Package:nb.djpan.admin.config
 *
 * @Author:pjz
 * @Create:2023/3/18
 * @Description: 配置拦截器
 * 过程：1、编写一个拦截器实现HandlerInterceptor接口
 *      2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors()方法）
 *      3、指定拦截器规则(如果是拦截所有，静态资源也会被拦截)
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer{

    /**
     * 配置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                //会拦截所有请求，包括静态资源，css样式
                .addPathPatterns("/**")
                //放行以下请求路径
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");

    }
}
