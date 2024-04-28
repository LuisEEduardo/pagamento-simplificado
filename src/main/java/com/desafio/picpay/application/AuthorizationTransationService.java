package com.desafio.picpay.application;

import com.desafio.picpay.controllers.Response.AuthorizationReponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthorizationTransationService {

    private final String serviceUrl;

    public AuthorizationTransationService(@Value("${authorization.transaction.url}") String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public void verifyIfTransactionAuthorized() throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        var response = restTemplate.getForEntity(serviceUrl, AuthorizationReponse.class);

        var body = response.getBody();

        if (body != null && body.message().equals("Autorizado")) {
            return;
        }

        throw new Exception("Transaction not authorized");
    }

}
