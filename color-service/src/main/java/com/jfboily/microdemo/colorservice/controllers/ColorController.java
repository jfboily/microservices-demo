package com.jfboily.microdemo.colorservice.controllers;

import com.jfboily.microdemo.colorservice.ColorServiceConfiguration;
import com.jfboily.microdemo.colorservice.Entities.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class ColorController {

    @Autowired
    ColorServiceConfiguration configuration;

    @RequestMapping("/color")
    public Color getColor() {
        Random r = new Random();

        List<Color> colors = configuration.getColors();

        return colors.get(r.nextInt(colors.size()));
    }
}
