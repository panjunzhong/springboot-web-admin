package nb.djpan.admin.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:User
 * Package:nb.djpan.admin.bean
 *
 * @Author:pjz
 * @Create:2023/3/18
 * @Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String userName;

    private String password;
}
