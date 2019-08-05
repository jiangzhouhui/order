package com.example.order.controller;

import com.example.order.dto.OrderDTO;
import com.example.order.message.StreamClientInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 廖师兄
 * 2018-02-13 18:20
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClientInput streamClient;

//    @GetMapping("/sendMessage")
//    public void process() {
//        String message = "now " + new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    /**
     * 发送 orderDTO对象
     */
//    @GetMapping("/sendMessage")
//    public void process() {
//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setOrderId("123456");
//        streamClient.input().send(MessageBuilder.withPayload(orderDTO).build());
//    }
}
