package com.rex.onlineShop.interceptor.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rex.onlineShop.entity.UserInfo;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ShopLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userObject = request.getSession().getAttribute("user");
        if(userObject != null){
            UserInfo user= (UserInfo)userObject;
            if(user.getUserId() !=null && user.getUserId() >0){
                return true;
            }
        }

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open(" + request.getContextPath() + "/local/login?usertype = 2'.'_self");
        out.print("</script>");
        out.println("</html>");
        return false;

    }
}
