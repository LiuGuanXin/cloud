package com.pansoft.zuulserver.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class UserFallBackProvider implements FallbackProvider {
    @Override
    public String getRoute() {
        //表明为那个服务提供回退
        return "PROVIDER-SERVICE";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse(){

            @Override
            public HttpHeaders getHeaders() {
                //headers设定
                HttpHeaders headers = new HttpHeaders();
                MediaType mt = new MediaType("application","json",
                        Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }

            @Override
            public InputStream getBody() throws IOException {
                //响应体
                return new ByteArrayInputStream("用户微服务不可用，请稍后再试。".getBytes());
            }

            @Override
            public HttpStatus getStatusCode() throws IOException {
                //fallback时的状态吗
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                //返回数字类型的状态码
                return this.getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                //状态文本
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }
        };
    }

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        return null;
    }
}