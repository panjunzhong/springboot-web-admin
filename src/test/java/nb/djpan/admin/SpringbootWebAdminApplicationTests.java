package nb.djpan.admin;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.naming.Name;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class SpringbootWebAdminApplicationTests {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier(value = "dataSource")
	DataSource dataSource;

	@Test
	void contextLoads() {

		List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user");
		maps.forEach(System.out::println);
		System.out.println(dataSource.getClass());
	}

}
