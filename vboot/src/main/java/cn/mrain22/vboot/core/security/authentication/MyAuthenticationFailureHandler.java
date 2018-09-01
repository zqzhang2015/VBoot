package cn.mrain22.vboot.core.security.authentication;

import cn.mrain22.vboot.core.common.utils.SimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 22
 * 自定义的认证失败处理器
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    /**
     * ObjectMapper这个类是java中jackson提供的，主要是用来把对象转换成为一个json字符串返回到前端,
     */
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        //设置返回类型
        response.setContentType("application/json;charset=UTF-8");
        //将错误信息写入
        response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(500,"",exception)));
    }


}
