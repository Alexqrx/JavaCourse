package com.tgt.common.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }
    //将CompactDisc 注入到 CDPlayer 之中
    @Bean
    public CDPlayer cdPlayer(CompactDisc cd){
        return new CDPlayer(sgtPeppers());
    }
}
