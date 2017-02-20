package hello.controller.bbs;

import hello.pojo.BBS;
import hello.repository.BbsRepository;
import hello.util.Emoji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Administrator on 2017/1/24.
 */
@Controller
public class BBSController {
    @Autowired
    BbsRepository bbsDao;

    @RequestMapping("/bbs")
    public ModelAndView bbsHandle(@RequestParam(required = false,defaultValue = "1") int page){
        ModelAndView mav = new ModelAndView("bbs/bbs");

        if(page<0)page = 1;

        List<BBS> bbs = bbsDao.findAll(new PageRequest(page-1,3)).getContent();

        mav.addObject("bbs",bbs);
        mav.addObject("page",page);
        return mav;
    }

    @RequestMapping("/submitComment")
    public String submitComment(
            @RequestParam String name,@RequestParam String comment,
            @RequestParam int emoji
    ){
        BBS bbs = new BBS();
        bbs.setName(name);
        bbs.setComment(comment);
        bbs.setEmoji(Emoji.getUrlFromEmoji(emoji));

        System.out.println(bbs);

        bbsDao.save(bbs);
        return "forward:/bbs";
    }

    @RequestMapping("/say")
    public String sayHandle(){
        return "bbs/say";
    }


}
