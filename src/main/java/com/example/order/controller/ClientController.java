package com.example.order.controller;

import com.example.order.client.ProductClient;
import com.example.order.dataobject.ProductInfo;
import com.example.order.dto.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zhouhui.jiang
 * @Date: 2019/5/6 22:30
 * @Version 1.0
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public  String getProductMsg()
    {
        //第一种方式(直接使用)RestTemplate,url写死)
//        RestTemplate restTemplate=new RestTemplate();
//        String response= restTemplate.getForObject("http://localhost:8701/msg",String.class);


        //第二种方式（利用loadBalancerClient 通过应用名获取URL，然后再使用RestTemplate）
//        RestTemplate restTemplate=new RestTemplate();
//        ServiceInstance serviceInstance=loadBalancerClient.choose("PRODUCT");
//        String usl=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort() + "/msg");
//        String response= restTemplate.getForObject(usl,String.class);

        //第三种方式
//        String response= restTemplate.getForObject("http://PRODUCT/msg",String.class);
//        log.info("response={}",response);
        String response=  productClient.productMsg();
        log.info("response={}",response);
        return  response;


    }

    @GetMapping("/getProductList")
    public String  getProductList()
    {
       List<ProductInfo> productlist= productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
       log.info("response={}",productlist);
       return  "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock()
    {
        productClient.decreaseStock(Arrays.asList(new CartDTO("164103465734242707",3)));
        return "OK";
    }

}
