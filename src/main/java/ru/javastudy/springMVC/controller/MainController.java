package ru.javastudy.springMVC.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.User;
import ru.javastudy.springMVC.tools.FileUploadForm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {

    /*First method on start application*/
    /*Попадаем сюда на старте приложения (см. параметры аннтоции и настройки пути после деплоя) */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        String s = "df";
        int a = 6;
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*как только на index.jsp подтвердится форма
    <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
    то попадем вот сюда
     */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("secondPage");
        modelAndView.addObject("userJSP", user);

        return modelAndView;
    }

    @RequestMapping(value = "/Statistics", method = RequestMethod.GET)
    public ModelAndView showStat(){
        ModelAndView modelAndView = new ModelAndView("Statistics");
        int k = 5;
        int sd = 4;
        return modelAndView;
    }

    @RequestMapping(value = "/Profile", method = RequestMethod.GET)
    public ModelAndView showProfile(){
        int asd = 666777;
        ModelAndView modelAndView = new ModelAndView("Profile");
        return modelAndView;
    }

    @RequestMapping(value = "/Help", method = RequestMethod.GET)
    public ModelAndView showHelp(){
        ModelAndView modelAndView = new ModelAndView("Help");
        int a = 5;
        String upd = "ads";
        String s = "New st";
        s=upd;
        return modelAndView;
    }

    @RequestMapping(value = "/UploadFile",method = RequestMethod.POST,consumes = "application/json")
    public void uploadFile(@RequestBody String f) throws JSONException {
        String s = f;
        JSONObject jsonObject = new JSONObject(f);
        Object file = jsonObject.get("file");

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute FileUploadForm uploadForm,Model map) throws IOException {
        List<MultipartFile> files = uploadForm.getFiles();
        List<String> fileNames = new ArrayList<String>();
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                InputStream is = multipartFile.getInputStream();
                byte[] data = multipartFile.getBytes();
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                //Handle file content - multipartFile.getInputStream()
            }
        }
        map.addAttribute("files", fileNames);
        return "file_upload_success";
    }
}
