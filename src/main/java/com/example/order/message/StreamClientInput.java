package com.example.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Author: zhouhui.jiang
 * @Date: 2019/5/12 15:24
 * @Version 1.0
 */
public interface StreamClientInput {
    String INPUT = "myMessage";

//    String InputTwo="InputTwo";

    @Input(StreamClientInput.INPUT)
    SubscribableChannel input();
//
//    @Input(StreamClientInput.InputTwo)
//    SubscribableChannel inputTwo();

}
