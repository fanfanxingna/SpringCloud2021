package com.h.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl {
    public String OK(Integer id){
        return id.toString();
    }
    @HystrixCommand(fallbackMethod ="TimeOutOne" ,commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String TimeOut(Integer id){
        try {
            Thread.sleep(5000);
            System.out.println(222);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int a=1/0;
        return id.toString();
    }

    public String TimeOutOne(Integer id){

        return "错误"+id;
    }
}
