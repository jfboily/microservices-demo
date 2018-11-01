package com.jfboily.microdemo.microdemofrontend.controllers;

import com.jfboily.microdemo.microdemofrontend.apiclients.MicrodemoApiClient;
import com.jfboily.microdemo.microdemofrontend.entities.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class FrontendController {

    @Autowired
    private MicrodemoApiClient apiClient;

    @RequestMapping("/")
    public String getColorTool(Map<String, Object> model) {
        // get a random tool
        String tool = apiClient.getTool();

        // get a random color
        Color color = apiClient.getColor();

        model.put("color", color);
        model.put("tool", tool);

        return "index";
    }

}
