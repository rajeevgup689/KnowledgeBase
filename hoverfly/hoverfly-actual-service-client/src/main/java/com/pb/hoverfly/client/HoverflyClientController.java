package com.pb.hoverfly.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HoverflyClientController {
	
	@Autowired
    RestTemplate restTemplate;
 
    @RequestMapping("/invoke")
    public String invoke() {
        System.out.println("inside TestController::invoke()");
        String url = "http://localhost:9080/service/hoverfly";
        String response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {
                }).getBody();
        
        //String response = restTemplate.getForEntity(url, String.class).getBody();
        System.out.println("Actual Response : " + response);
        return response;
    }

}
