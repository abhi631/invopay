package org.invopayWebService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/web/getData")
    public String getData(){
        return "this is data";
    }
}
