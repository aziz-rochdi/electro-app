package com.rochdi.clientservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "global.params")
@Setter @Getter
public class GlobalConfig {
    private int p1;
    private int p2;
}
