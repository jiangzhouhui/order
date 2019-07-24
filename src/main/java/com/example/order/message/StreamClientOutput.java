package com.example.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: zhouhui.jiang
 * @Date: 2019/5/12 16:55
 * @Version 1.0
 */
public interface StreamClientOutput {
    String INPUT2 = "outMessage";

    @Input(StreamClientOutput.INPUT2)
    SubscribableChannel input();
}
