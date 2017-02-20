package hello.controller.manage;

import hello.repository.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/1/12.
 */
@Controller
public class ManagerController {
    ManagerDao managerDao;

    @Resource(name = "managerDao")
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @RequestMapping("/manage")
    public String managerEntryHandle(HttpSession session){
        if(session.getAttribute("logined")!=null){
            return "forward:/managePage";
        }
        return "manage/managerLogin";
    }

    @RequestMapping(value = "/managerLoginSubmit",method = RequestMethod.POST)
    public String managerLoginHandle(HttpSession session, String user, String pass, String checkCode){
        String code = (String)session.getAttribute("strCode");

        System.out.println("code = "+code + " checkCode = "+checkCode +" user = "+user+" pass = "+pass);

        session.removeAttribute("strCode");//清空防止利用
        session.removeAttribute("logined");

        String loginUrl = "manage/managerLogin";

        if(!code.equals(checkCode)){
            System.out.println("yan zheng ma!");
            return loginUrl;
        }

        boolean isManager = managerDao.checkManager(user,pass);

        if(!isManager){
            System.out.println("user or pass!");
            return loginUrl;
        }

        session.setAttribute("logined",true);
        return "forward:/managePage";
    }

    @RequestMapping("/managePage")
    public String managePage(HttpSession session){
        Object loginFlag = session.getAttribute("logined");
        if(loginFlag == null){
            return "index";
        }
        return "manage/manage";
    }
}
