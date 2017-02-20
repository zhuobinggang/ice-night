package hello.controller;

import hello.pojo.Manga;
import hello.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/11.
 */
@Controller
public class IndexController {
//    MangaDao dao;
    @Autowired
    MangaRepository mangaRepository;

    @RequestMapping({"/index","/"})
    public ModelAndView indexHandler(HttpServletResponse response){
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        ModelAndView mav = new ModelAndView("index");

        List<Manga> mangas = new ArrayList<>();
        mangaRepository.findAll().forEach(it -> {
            mangas.add(it);
        });

        mav.addObject("mangas",mangas);
        return mav;
    }
}
