package nb.djpan.admin.controller;

import nb.djpan.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * ClassName:TableController
 * Package:nb.djpan.admin.controller
 *
 * @Author:pjz
 * @Create:2023/3/18
 * @Description:
 */
@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){

        //表格内容的遍历
        List<User> list = Arrays.asList(
                new User("张三","12345"),
                new User("李四","11111"),
                new User("王五","22222")
        );
        model.addAttribute(list);

        return "table/dynamic_table";
    }


    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }


    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

}
