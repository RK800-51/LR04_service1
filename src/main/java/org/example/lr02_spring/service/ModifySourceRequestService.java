package org.example.lr02_spring.service;

import org.example.lr02_spring.model.Request;
import org.example.lr02_spring.model.Response;
import org.example.lr02_spring.model.Systems;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ModifySourceRequestService implements ModifyRequestService{
    @Override
    public void modify(Request request) {
        request.setSource("Modified source");

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
        new RestTemplate().exchange("http//:localhost:8083/feedback", HttpMethod.POST,
                httpEntity, new ParameterizedTypeReference<>() {
                });
    }
}
