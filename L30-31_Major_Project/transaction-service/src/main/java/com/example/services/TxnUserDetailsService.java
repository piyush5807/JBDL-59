package com.example.services;

import com.example.models.TxnUser;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TxnUserDetailsService implements UserDetailsService {

    RestTemplate restTemplate = new RestTemplate();

    private static Logger logger = LoggerFactory.getLogger(TxnUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String usermobile) throws UsernameNotFoundException {
        // fetch the user details
        String url = "http://localhost:4000/user/mobile/" + usermobile;

        // Creating authorization header for txn service
        String plainCreds = "txnservice:P@ass123";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<>(headers);

        JSONObject userData = restTemplate.exchange(url, HttpMethod.GET, request, JSONObject.class).getBody();

        logger.info("user data - {}", userData);
        return TxnUser.builder()
                .username((String)userData.get("mobile"))
                .password((String) userData.get("password"))
                .build();

    }
}
