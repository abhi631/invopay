package com.commons.zaiDTOS.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZAIClientDTO {
    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String country;
}
