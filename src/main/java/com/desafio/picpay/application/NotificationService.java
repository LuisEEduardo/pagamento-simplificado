package com.desafio.picpay.application;

import com.desafio.picpay.controllers.Response.NotificationReponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    private final String serviceUrl;

    public NotificationService(@Value("${notification.url}") String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public void send() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        var response = restTemplate.getForEntity(serviceUrl, NotificationReponse.class);

        var body = response.getBody();

        if (body != null && body.message().equals(true)) {
            return;
        }

        throw new Exception("Send message not have success");
    }
}
