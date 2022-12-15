package org.zai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zai.service.ZAIIntigrationService;

@RestController
public class ZAIController {

    @Autowired
    private ZAIIntigrationService zaiIntigrationService;

    @GetMapping("/responce")
    public Object getLeaves(){
        return zaiIntigrationService.generateToken();
    }

}
