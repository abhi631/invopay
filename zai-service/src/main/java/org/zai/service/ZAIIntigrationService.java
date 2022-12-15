package org.zai.service;

import com.google.common.net.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.client.WebClient;
import org.zai.dto.ZAIHeader;
import org.zai.dto.ZAITokenResponce;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.sql.Time;
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

    public ZAITokenResponce generateToken(){
        ZAITokenResponce zaiTokenResponce = webClient.post().uri(tokenUri)
                .body(Mono.just(new ZAIHeader(grant_type,client_id,client_secret,scope)), ZAIHeader.class)
                .retrieve().bodyToMono(ZAITokenResponce.class)
                .block();
        redisTemplate.opsForHash().put("zaiTokenResponce", "token" ,zaiTokenResponce );
        redisTemplate.expire("token",3600, TimeUnit.SECONDS);
        return  zaiTokenResponce;
    }
}
