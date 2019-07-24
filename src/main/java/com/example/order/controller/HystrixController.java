package com.example.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @Author: zhouhui.jiang
 * @Date: 2019/5/24 22:33
 * @Version 1.0
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    //超时配置
//    @HystrixCommand(commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000"))

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),   //设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//设置在滚动时间窗口中，断路器的最小请求数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//当断路器打开，会启动一个休眠时窗，将降级逻辑成为临时的主逻辑，当休眠时间窗到期，断路器将进入半开状态，释放一次请求道原来的主逻辑上，如果请求正常返回成功，那么断路器会闭合，主逻辑恢复，如果失败，断路器继续变为打开状态，休眠时间窗重新计时
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")}) //设置断路器打开的百分比条件
//    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("number") Integer number)
    {
        if(number % 2 ==0)
        {
            return "success";
        }

        RestTemplate restTemplate=new RestTemplate();
        return  restTemplate.postForObject("http://127.0.0.1:8703/product/listForOrder", Arrays.asList("157875196366160022"),String.class);
//        throw new RuntimeException("发送异常了");

    }

    private String fallback(){
        return  "太拥挤了，请稍后再试~~";
    }

    private String defaultFallback()
    {
        return "默认提示：太拥挤了，请稍后再试~~";
    }

}

