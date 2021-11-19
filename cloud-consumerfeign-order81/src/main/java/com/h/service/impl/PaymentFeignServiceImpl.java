package com.h.service.impl;

import com.h.conig.CommonResult;
import com.h.entity.Payment;
import com.h.service.PaymentFeignService;

public class PaymentFeignServiceImpl implements PaymentFeignService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return new CommonResult(404,"兜底",new Payment(id,"errorSerial"));
    }
}
