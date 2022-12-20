package org.zai.controller;

import com.commons.ResponceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.commons.zaiDTOS.client.ClientDTO;
import org.zai.service.ZAIIntigrationService;
import org.zai.service.ZAIService;

@RestController
public class ZAIController {

    @Autowired private ZAIIntigrationService zaiIntigrationService;
    @Autowired private ZAIService zaiService;

    @PostMapping("/create_client")
    public ResponseEntity<Object> createClient(@RequestBody ClientDTO clientdto){
        return ResponceHandler.generateResponce(HttpStatus.OK , true , zaiService.createClient(clientdto));
    }

}
