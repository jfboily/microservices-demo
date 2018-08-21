package com.jfboily.microdemo.colorservice;

import com.jfboily.microdemo.colorservice.Entities.Color;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ColorServiceConfiguration {

    @Value("${colors}")
    private String colorsString;
    private List<Color> colors;


    @EventListener({EnvironmentChangeEvent.class, ContextRefreshedEvent.class})
    public void onRefresh() {
        parseColors();
    }

    public List<Color> getColors() {
        return colors;
    }

    private void parseColors() {
        String[] colorsArray = colorsString.split("\\|");

        colors = new ArrayList<>();

        Arrays.stream(colorsArray).forEach(c -> {
            String[] args = c.split(":");
            Color color = new Color();
            color.setName(args[0]);
            color.setCode(args[1]);

            colors.add(color);
        });
    }


}
