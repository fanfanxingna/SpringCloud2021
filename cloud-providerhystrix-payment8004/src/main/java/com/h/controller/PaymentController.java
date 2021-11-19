package com.h.controller;

import com.h.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentServiceImpl paymentService;

    @GetMapping("/ok/{id}")
    public String findByIdPaymentOk(@PathVariable("id") Integer id){
        return paymentService.OK(id);

    }
    @GetMapping("/out/{id}")
    public String findByIdPaymentOut(@PathVariable("id") Integer id){
        return paymentService.TimeOut(id);
    }
}
