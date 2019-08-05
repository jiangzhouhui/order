package com.example.order.service;

import com.example.order.dto.OrderDTO;
import javafx.scene.Camera;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * Created by 廖师兄
 * 2017-12-10 16:39
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);

}
