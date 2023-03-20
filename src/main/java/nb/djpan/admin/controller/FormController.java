package nb.djpan.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * ClassName:FormController
 * Package:nb.djpan.admin.controller
 *
 * @Author:pjz
 * @Create:2023/3/19
 * @Description: 文件上传测试
 */
@Controller
@Slf4j
public class FormController {

    @GetMapping("/form_layouts")
    public String formLayouts(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传过来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息：email={},username={},headerImg={},photos={}",
              email,username,headerImg.getSize(),photos.length);
        if (!headerImg.isEmpty()) {
            //获取名字
            String originalFilename = headerImg.getOriginalFilename();
            //保存到文件服务器上
            headerImg.transferTo(new File("D:\\Study\\MultipartFile\\"+originalFilename));
        }

        if (photos.length > 0){
            for (MultipartFile photo : photos){
                if (!photo.isEmpty()) {
                    //获取名字
                    String originalFilename = photo.getOriginalFilename();
                    //保存文件到服务器上
                    photo.transferTo(new File("D:\\Study\\MultipartFile\\"+originalFilename));
                }
            }
        }
      return "main";
    }
}
