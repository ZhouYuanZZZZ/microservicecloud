package com.zy.microservicecloud.api;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


public class DataTransferServiceFallbackFactory implements FallbackFactory<DataTransferService> {
    @Override
    public DataTransferService create(Throwable throwable) {
        return new DataTransferServiceHandler();
    }
}
