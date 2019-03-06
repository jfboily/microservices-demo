package com.jfboily.microdemo.microdemofrontend.controllers;

import com.jfboily.microdemo.microdemofrontend.apiclients.MicrodemoApiClient;
import com.jfboily.microdemo.microdemofrontend.entities.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws Exception {
        request.logout();
        return "redirect:http://localhost:8180/auth/realms/colortool/protocol/openid-connect/logout?redirect_uri=http%3A%2F%2Flocalhost%3A8087";
    }

}
