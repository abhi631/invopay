package org.zai.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ZAIHeader {
    private String grant_type;
    private String client_id;
    private String client_secret;
    private String scope;
}
