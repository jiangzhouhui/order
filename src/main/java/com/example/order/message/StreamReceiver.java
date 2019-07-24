package com.example.order.message;

import com.example.order.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by 廖师兄
 * 2018-02-13 18:17
 */
@Component
@EnableBinding({StreamClientInput.class,StreamClientOutput.class})
@Slf4j
public class StreamReceiver {

//    @StreamListener(value = StreamClient.INPUT)
//    public void process(Object message) {
//        log.info("StreamReceiver: {}", message);
//    }

    /**
     * 接收orderDTO对象 消息
     * @param message
     */
    @StreamListener(StreamClientInput.INPUT)
    @SendTo({StreamClientOutput.INPUT2})
    public String process(OrderDTO message) {
        log.info("StreamReceiver: {}", message);
        return "received.";
    }
}