package ru.shpi0.resttest.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
@Api(hidden = true)
public class RootController {

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "swagger main page", hidden = true)
    public String swaggerUi() {
        return "redirect:/swagger-ui.html";
    }

}
