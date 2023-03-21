package nb.djpan.admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * ClassName:MyDataSourceConfig
 * Package:nb.djpan.admin.config
 *
 * @Author:pjz
 * @Create:2023/3/20
 * @Description: 配置自定义的Druid数据源
 */
@Configuration
public class MyDataSourceConfig {

    /**
     * 给数据源绑定数据，直接从配置文件里面拿
     * @return
     */
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
/*      直接用注解来绑定数据源，直接写死不好得
        druidDataSource.setUrl();
        druidDataSource.setUsername();
        druidDataSource.setPassword();
        druidDataSource.setDriver();
        */
        //加入监控功能，下面的监控页功能才有用,以及加上wall防火墙功能，防止sql注入
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 配置druid的监控页功能
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet,"/druid/*");

        //优化druid的使用，设定用户名和密码才能访问
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","111");

        return registrationBean;
    }

    /**
     * WebStatFilter  用于采集web-jdbc关联监控的数据,就是监控web应用
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        //要拦截的路径可以写在上一行代码的括号里，也可以采用这种方法来写
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        //还要设置放行的路径,这些路径都是阿里巴巴建议文档里面的
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*,jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;

    }
}
