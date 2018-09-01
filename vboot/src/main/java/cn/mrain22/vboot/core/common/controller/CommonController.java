package cn.mrain22.vboot.core.common.controller;

import cn.mrain22.vboot.core.common.utils.SimpleResponse;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @author 22
 */
@RestController
public class CommonController extends AbstractErrorController {

    public CommonController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @GetMapping("/loginMust")
    public SimpleResponse loginMust(){
        return new SimpleResponse(401,"请先登录！");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("${server.error.path:${error.path:/error}}")
    public SimpleResponse globalError(ServletWebRequest webRequest){
        //调用父类方法获取错误信息
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest.getRequest(), true);
        return new SimpleResponse(500,"发生错误",errorAttributes);
    }
}
