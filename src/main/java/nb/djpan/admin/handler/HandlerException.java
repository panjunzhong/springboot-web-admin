package nb.djpan.admin.handler;

import nb.djpan.admin.exception.PasswordException;
import nb.djpan.admin.exception.UsernameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ClassName:HandlerException
 * Package:nb.djpan.admin.handler
 *
 * @Author:pjz
 * @Create:2023/3/18
 * @Description:
 */
@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(UsernameException.class)
    public String usernameException(){

        return "usernameError";
    }

    @ExceptionHandler(PasswordException.class)
    public String passwordException(){

        return "passwordError";
    }
}
