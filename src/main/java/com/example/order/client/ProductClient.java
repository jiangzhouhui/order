package com.example.order.client;

import com.example.order.dataobject.ProductInfo;
import com.example.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author: zhouhui.jiang
 * @Date: 2019/5/6 23:27
 * @Version 1.0
 */
@FeignClient(name="product",fallback = ProductClient.ProductClientFallback.class )
public interface ProductClient {
    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
    @Component
    static class  ProductClientFallback implements ProductClient
    {

        @Override
        public String productMsg() {
            return null;
        }

        @Override
        public List<ProductInfo> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<CartDTO> cartDTOList) {

        }
    }

}
