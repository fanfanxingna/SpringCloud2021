package com.h.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.entity.Payment;
import com.h.mapper.PaymentMapper;
import com.h.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}
