package com.covid.vaccineapi.utility;

import com.covid.vaccineapi.pojo.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Component
public class SendTelegramNotification {

    @Autowired
    private RestTemplate restTemplate;

    private static final String CHAT_ID = "";
    private static final String TOKEN = ";

    private static final String CHAT_ID_DOSE2 = "";
    private static final String TOKEN_DOSE2 = "";

    @Async
    public CompletableFuture<SendMessage> sendTelegramMsg(String msg, boolean isDose1) {

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        String url = "https://api.telegram.org/{token}/sendMessage?chat_id={chat_id}&text={text}";
        ResponseEntity<SendMessage> messageResponseEntity = null;

        if(isDose1)
            messageResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, SendMessage.class, "bot" + TOKEN, CHAT_ID, msg);
        else
            messageResponseEntity = restTemplate.exchange(url, HttpMethod.GET, null, SendMessage.class, "bot" + TOKEN_DOSE2, CHAT_ID_DOSE2, msg);

        return CompletableFuture.completedFuture(messageResponseEntity.getBody());
    }

}
