package com.jfboily.microdemo.toolservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ToolController {

    @Value("${tools}")
    private String tools;

    @RequestMapping("/tool")
    public String getTool() {
        Random r = new Random();
        String[] toolsArray = tools.split("\\|");
        return toolsArray[r.nextInt(toolsArray.length)];
    }
}
