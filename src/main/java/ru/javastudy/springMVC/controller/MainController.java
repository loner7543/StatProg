package ru.javastudy.springMVC.controller;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.javastudy.springMVC.model.User;
import ru.javastudy.springMVC.model.convert.DatReader;
import ru.javastudy.springMVC.model.statistics.ProfileStatistics;
import ru.javastudy.springMVC.tools.FileUploadForm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
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
        ModelAndView modelAndView = new ModelAndView("Profile");
        return modelAndView;
    }

    @RequestMapping(value = "/Help", method = RequestMethod.GET)
    public ModelAndView showHelp(){
        ModelAndView modelAndView = new ModelAndView("Help");
        return modelAndView;
    }

    @RequestMapping(value = "/UploadFile",method = RequestMethod.POST)
    public void uploadFile() {//
        int a = 5;
        int i = 6;

    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public  @ResponseBody String save(@RequestParam("files[]") List<MultipartFile> files,Model map) throws IOException {
        List<String> fileNames = new ArrayList<String>();
        List<ProfileStatistics> dataList = new LinkedList<>();//тут данные уже прошедшие через парсер
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                InputStream is = multipartFile.getInputStream();
                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);
                ProfileStatistics statistics = DatReader.readData(fileName,is);
                dataList.add(statistics);
            }
    }
        return "file_upload_success";
}}
