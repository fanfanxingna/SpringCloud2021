package com.h.service;

import com.h.conig.CommonResult;
import com.h.service.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value ="CLOUD-PAYMENT-HYSTRIX-SERVICE",fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {
    @GetMapping(value = "/ok/{id}")
    public String findByIdPaymentOk(@PathVariable("id")Integer id);
    @GetMapping(value = "/out/{id}")
    public String findByIdPaymentOut(@PathVariable("id")Integer id);
}
