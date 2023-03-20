package nb.djpan.admin.controller;

import lombok.extern.slf4j.Slf4j;
import nb.djpan.admin.bean.User;
import nb.djpan.admin.exception.MyAdminException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * ClassName:IndexController
 * Package:nb.djpan.admin.controller
 *
 * @Author:pjz
 * @Create:2023/3/18
 * @Description: 发起请求后跳转到登陆页面
 */
@Controller
@Slf4j
public class IndexController {

    /**
     * 去到登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {

        return "login";
    }

    /**
     * 去到主页面
     *
     * @param
     * @param
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) throws MyAdminException {
        if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())) {
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功重定向到main.html
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg","账号密码有错误");
            return "login";
        }
    }


    /**
     * 使用重定向来解决重复页面刷新问题
     * 真正的来到main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){

        log.info("当前的方法是：{}","mainPage");
        return "main";
       /*
        已经配置了拦截器，这里就不需要了
        //判断用户是否登录，但是不能给每一个方法都写一个判断，一般用拦截器，过滤器来解决
        Object logonUser = session.getAttribute("loginUser");
        if (logonUser != null){
            return "main";
        }else {
            //否则重新回到登陆页面
            model.addAttribute("msg","请重新登录");
            return "login";
        }*/
    }
}
