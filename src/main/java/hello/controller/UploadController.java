package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import hello.util.UploadUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Administrator on 2017/1/14.
 */
@Controller
public class UploadController {
    @RequestMapping("/uploadPage")
    public String turnToUpload(){
        return "upload/uploadPage";
    }

    @RequestMapping("/showUploaded")
    public String turnToShowUploaded(){
        return "test/showUploaded";
    }

    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public @ResponseBody
    String handleFileUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("path") String path,
            HttpSession session){
        try{
            System.out.println("start!");

            if(session.getAttribute("logined") == null){
                //防止恶意利用
                return "please login!";
            }

            if (!file.isEmpty()) {
                String outputDirectory = UploadUtil.getStaticRoot() + path;
                System.out.println("dir = "+outputDirectory);
                Path dir = Paths.get(outputDirectory);
                if(Files.exists(dir)){
                    System.out.println("path exist!");
                }else{
                    Files.createDirectories(dir);
                    System.out.println("path not exist! try to create!");
                }

                String outputPath = outputDirectory + name;
                Path outPath = Paths.get(outputPath);

                if(Files.exists(outPath)){
                    System.out.println("file exist! try to truncate it!");
                    Files.delete(outPath);
                }else{
                    System.out.println("file not exist! create it");
                }
                Files.createFile(outPath);
                Files.write(outPath,file.getBytes(),StandardOpenOption.APPEND);

                return "upload file "+outputPath;
            } else {
                return "You failed to upload because the file was empty.";
            }
        }catch (IOException e){
            e.printStackTrace();
            return "IOException occur!";
        }
    }

    //try.jsp
    @RequestMapping(value = "/upload2")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
//        File targetFile = new File(path, fileName);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//
//        //保存
//        try {
//            file.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
//
//        return "result";
        return "index";
    }
}
