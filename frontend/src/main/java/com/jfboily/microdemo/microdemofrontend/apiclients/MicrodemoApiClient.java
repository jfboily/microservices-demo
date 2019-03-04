package com.jfboily.microdemo.microdemofrontend.apiclients;

import com.jfboily.microdemo.microdemofrontend.entities.Color;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gateway", url = "http://localhost:8888")
public interface MicrodemoApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/color-service/color")
    Color getColor();

    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/tool-service/tool")
    String getTool();

}
