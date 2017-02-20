package hello.controller.manage;

import hello.pojo.Manga;
import hello.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/20.
 */
@Controller
public class MangaController {
    @Autowired
    MangaRepository mangaDao;

    @RequestMapping("/listManga")
    public ModelAndView mangaListHandle(){
        ModelAndView mav = new ModelAndView("manage/listManga");

        List<Manga> mangas = new ArrayList<>();

        mangaDao.findAll().forEach(it -> {
            mangas.add(it);
        });

        mav.addObject("mangas",mangas);
        return mav;
    }

    @RequestMapping("/mangaEdit")
    public ModelAndView mangaEditHandle(@RequestParam int id){
        ModelAndView mav = new ModelAndView("manage/mangaEdit");
        mav.addObject("manga",mangaDao.findOne(Long.valueOf(id)));
        return mav;
    }

    @RequestMapping(value = "/updateManga",method = RequestMethod.POST)
    public String updateMangaHandle(
            @RequestParam String name,@RequestParam String comment,
            @RequestParam String logoPath,@RequestParam String url,
            @RequestParam int id
    ){
        Manga manga = new Manga();
        manga.setId(id);
        manga.setName(name);
        manga.setComment(comment);
        manga.setLogoPath(logoPath);
        manga.setUrl(url);

        mangaDao.save(manga);
        return "forward:/listManga";
    }

    @RequestMapping("/addPage")
    public String addManga(){
        return "manage/addManga";
    }

    @RequestMapping(method = RequestMethod.POST,value = "/addManga")
    public String addMangaHandle(
            @RequestParam String name,@RequestParam String comment,
            @RequestParam String logoPath,@RequestParam String url
    ){
        Manga manga = new Manga();
        manga.setName(name);
        manga.setComment(comment);
        manga.setLogoPath(logoPath);
        manga.setUrl(url);

        mangaDao.save(manga);

        return "index";
    }
}
