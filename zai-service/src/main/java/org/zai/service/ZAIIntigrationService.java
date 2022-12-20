package org.zai.service;

import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.zai.dto.ZAIHeader;
import org.zai.dto.ZAITokenResponce;
import com.commons.zaiDTOS.client.ZAIClientDTO;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@Service
public class ZAIIntigrationService {

    @Autowired private WebClient webClient;
    @Autowired private RedisTemplate redisTemplate;

    @Value("${tokenUri}") private String tokenUri;
    @Value("${grant_type}") private String grant_type;
    @Value("${client_id}") private String client_id;
    @Value("${client_secret}") private String client_secret;
    @Value("${scope}") private String scope;
    @Value ("${createClient}") private String createUserUrl;

    public ZAITokenResponce generateToken(){
        ZAITokenResponce zaiTokenResponce = webClient.post().uri(tokenUri)
                .body(Mono.just(new ZAIHeader(grant_type,client_id,client_secret,scope)), ZAIHeader.class)
                .retrieve().bodyToMono(ZAITokenResponce.class)
                .block();
        redisTemplate.opsForHash().put("zaiTokenResponce", "token" ,zaiTokenResponce );
        redisTemplate.expire("token",3600, TimeUnit.SECONDS);
        return  zaiTokenResponce;
    }

    public void createClientAtZai(ZAIClientDTO client) {
        String zaiToken = generateToken().getAccess_token();
        Object o =webClient.post().uri(createUserUrl).body(Mono.just(client), ZAIClientDTO.class)
//                .headers(h-> h.setBearerAuth(zaiToken))
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + zaiToken)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .retrieve().bodyToMono(Object.class)
                .block();
        System.out.println(o);
    }
}
