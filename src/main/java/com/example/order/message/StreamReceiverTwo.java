package com.example.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Author: zhouhui.jiang
 * @Date: 2019/5/12 16:59
 * @Version 1.0
 */
@Component
@EnableBinding({StreamClientOutput.class})
@Slf4j
public class StreamReceiverTwo {
    @StreamListener(StreamClientOutput.INPUT2)
    public void process2(String message) {
        log.info("StreamReceiver2: {}", message);
    }
}

