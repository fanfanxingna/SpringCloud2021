package com.h.service.impl;

import com.h.conig.CommonResult;
import com.h.entity.Payment;
import com.h.service.PaymentFeignService;
import org.springframework.stereotype.Service;

@Service
public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public String findByIdPaymentOk(Integer id) {
        return "404";
    }
    @Override
    public String findByIdPaymentOut(Integer id) {
        return "400";
    }
}
