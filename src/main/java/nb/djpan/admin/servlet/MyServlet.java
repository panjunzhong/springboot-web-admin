package nb.djpan.admin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName:MyServlet
 * Package:nb.djpan.admin.servlet
 *
 * @Author:pjz
 * @Create:2023/3/19
 * @Description: 注入原生的servlet
 */
//@WebServlet(urlPatterns = "/MyServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("中国人！！！");
    }
}
