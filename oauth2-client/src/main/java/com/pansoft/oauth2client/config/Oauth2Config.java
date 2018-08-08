package com.pansoft.oauth2client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
@Configuration
public class Oauth2Config extends AuthorizationServerConfigurerAdapter {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("h2kedRv3wRTiSvmNhr6rNtWj") // client_id
                .secret("wZx362Kuem9zWbTbToxYUXHavBC1K24y") // client_secret
                .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
                .scopes("basic"); // 允许的授权范围
    }
}
