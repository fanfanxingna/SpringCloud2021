package com.h.controller;

import com.h.conig.CommonResult;
import com.h.service.PaymentFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "getPaymentByIdOutTwo")
public class OrderController {
//    @Autowired
//    RestTemplate restTemplate;
//    public static final String PAYMENT_URL = "http://cloud-payment-service";
//
//
    @Resource
    PaymentFeignService paymentFeignService;
    @GetMapping("/order/ok/{id}")
    public String getPaymentByIdOk(@PathVariable("id")Integer id){

        return   paymentFeignService.findByIdPaymentOk(id);
    };
    @GetMapping("/order/out/{id}")
    @HystrixCommand//(fallbackMethod ="getPaymentByIdOutOne" ,commandProperties = {
            //@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    //})
    public String getPaymentByIdOut(@PathVariable("id")Integer id){
        return   paymentFeignService.findByIdPaymentOut(id);
    };
    @GetMapping("/sui/{id}")
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String getPaymentByIdOutthree(@PathVariable("id")Integer id){
        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        return   "id="+ UUID.randomUUID();
    };
    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){

        return   "id="+id+"id不能为负数";
    };
    public String getPaymentByIdOutOne(@PathVariable("id")Integer id){

        return   "消费";
    };
    public String getPaymentByIdOutTwo(){

        return   "消费11";
    };
}
