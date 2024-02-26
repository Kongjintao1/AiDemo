package com.example.aidemo.controller;


import com.example.aidemo.util.AiUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: 孔金涛
 * @Date: 2024年02月19日 16:10
 */
@RestController
public class AiController {

    @RequestMapping(value = "/word",method = RequestMethod.POST)
    public String word(@RequestParam("file") MultipartFile file) throws IOException {
        return AiUtils.word(file);
    }

    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public String img(@RequestParam("file") MultipartFile file) throws IOException {
        return AiUtils.img(file);
    }

    @RequestMapping(value = "/nlp",method = RequestMethod.GET)
    public String nlp(@RequestParam("text") String text){
        return AiUtils.nlp(text);
    }
}
