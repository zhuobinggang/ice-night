package hello.controller.bbs;

import com.alibaba.fastjson.JSON;
import hello.pojo.BBS;
import hello.repository.BbsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by kobako on 2017/2/23.
 * Just a game
 */
@Controller
public class BbsAjaxController {
    @Autowired
    BbsRepository bbsDao;

    @RequestMapping("/bbs/ajaxPage")
    @ResponseBody
    public String getBbsPage(@RequestParam(required = false,defaultValue = "1") int page){
        if(page<0)page = 1;

        List<BBS> bbs = bbsDao.findAll(new PageRequest(page-1,3, Sort.Direction.DESC,"id")).getContent();
        return JSON.toJSONString(bbs);
    }

    @RequestMapping("/bbs2")
    public String bbs2Handler(){
        return "bbs/bbsAjaxVersion";
    }
}
