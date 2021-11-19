package com.h.conig;

import com.h.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private  T data;

    public CommonResult(long i, String no, Payment payment) {
    }
}
