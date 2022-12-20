package org.zai.service;

import com.commons.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.commons.zaiDTOS.client.ClientDTO;
import com.commons.zaiDTOS.client.ZAIClientDTO;
import org.zai.models.Client;
import org.zai.repository.ZaiClientRepo;

@Service
public class ZAIService {

    @Autowired private ZaiClientRepo zaiClientRepo;
    @Autowired ZAIIntigrationService zaiIntigrationService;

    public ClientDTO createClient(ClientDTO clientdto) {
        if(validateClient(clientdto)){
            Client client = ObjectMapperUtil.copyPropertiesByMapper(clientdto , Client.class);
//            zaiClientRepo.save(client);
            ZAIClientDTO zaiClientDTO = new ZAIClientDTO(client.getClient_id() , client.getClient_fname() , client.getClient_lname() , client.getClient_email() , "AUS");
            zaiIntigrationService.createClientAtZai(zaiClientDTO);
        }
        return clientdto;
    }

    private boolean validateClient(ClientDTO clientDTO) {
        if(clientDTO.getClient_fname()!= null && clientDTO.getClient_fname().isEmpty()){
            throw new RuntimeException("Client first name can't be empity");
        }
        if(clientDTO.getClient_lname()!= null && clientDTO.getClient_lname().isEmpty()){
            throw new RuntimeException("Client first name can't be empity");
        }
        if(clientDTO.getClient_email()!= null && clientDTO.getClient_email().isEmpty()){
            throw new RuntimeException("Client first name can't be empity");
        }
        return true;
    }
}
