package com.h.controller;

import com.h.conig.CommonResult;
import com.h.entity.Payment;
import com.h.service.impl.PaymentServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentServiceImpl paymentService;

    @GetMapping("/payment/{id}")
    public CommonResult findByIdPayment(@PathVariable("id") Long id){
        Payment payment = paymentService.getById(id);
        System.out.println(1);
        if (payment==null){
            return new CommonResult(404,"出现了意外情况",payment);
        }else{
            return new CommonResult(200,"查询出来的数据为:",payment);
        }
    }
}
