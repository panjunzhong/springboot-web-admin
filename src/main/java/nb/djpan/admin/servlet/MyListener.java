package nb.djpan.admin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ClassName:MyListener
 * Package:nb.djpan.admin.servlet
 *
 * @Author:pjz
 * @Create:2023/3/19
 * @Description:
 */
@Slf4j
//@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("MyListener 监听到项目初始化完成");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("MyListener 监听到项目销毁完成");
    }
}
