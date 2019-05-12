package com.zy.springcloud.microservicecloudfeign.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class DataTransferServiceFallbackFactory implements FallbackFactory<DataTransferService> {
    @Override
    public DataTransferService create(Throwable throwable) {
        return new DataTransferServiceHandler();
    }
}
