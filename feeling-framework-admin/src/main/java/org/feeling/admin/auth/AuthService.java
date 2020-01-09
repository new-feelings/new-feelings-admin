package org.feeling.admin.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lyq on 2020-01-09 11:17 下午
 * @desc
 */
@Service
public class AuthService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ClientCredentialsResourceDetails client;

    public AuthEntity login(String username,String password){
        MultiValueMap<String, String> param= new LinkedMultiValueMap<String, String>();
        param.add("client_id",client.getClientId());
        param.add("client_secret",client.getClientSecret());
        param.add("grant_type",client.getGrantType());
        param.add("username",username);
        param.add("password",password);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(param, headers);
        ResponseEntity<AuthEntity> response = restTemplate.postForEntity(
                "http://new-feelings-auth/oauth/token",
                request,
                AuthEntity.class,
                param
        );
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return null;
    }

    public boolean logout(String access_token){
        access_token = access_token.split(" ")[1];
        try {
            restTemplate.delete(
                    "http://new-feelings-auth/oauth/logout?access_token=" + access_token
            );
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
