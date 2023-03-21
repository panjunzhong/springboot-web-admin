package nb.djpan.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * ClassName:DruidSqlConfig
 * Package:nb.djpan.admin.config
 *
 * @Author:pjz
 * @Create:2023/3/20
 * @Description:
 */
@Controller
public class DruidSqlController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/sql")
    public String queryList(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user");
        maps.forEach(System.out::println);
        return maps.toString();
    }
}
