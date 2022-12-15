package org.zai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZAITokenResponce implements Serializable {
    private String access_token;
    private String expires_in;
    private String token_type;
}
