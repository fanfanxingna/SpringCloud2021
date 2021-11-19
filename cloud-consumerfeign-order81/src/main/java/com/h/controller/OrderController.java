package com.h.controller;

import com.h.conig.CommonResult;
import com.h.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
//    @Autowired
//    RestTemplate restTemplate;
//    public static final String PAYMENT_URL = "http://cloud-payment-service";
//
//
    @Resource
    PaymentFeignService paymentFeignService;
    @GetMapping("/order/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return   paymentFeignService.getPaymentById(id);
    };
}
