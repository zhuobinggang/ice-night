package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import hello.util.CheckCodeGenerator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/1/12.
 */
@Controller
public class Checker {
    @RequestMapping("/getCheckCode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response
            , HttpSession session) throws IOException{
        CheckCodeGenerator.getCodeImg(request,response,session);
    }
}
