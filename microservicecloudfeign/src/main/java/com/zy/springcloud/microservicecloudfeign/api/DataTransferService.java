package com.zy.springcloud.microservicecloudfeign.api;

import com.zy.springcloud.microservicecloudfeign.entity.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service0",fallbackFactory = DataTransferServiceFallbackFactory.class)
public interface DataTransferService {

    @RequestMapping(value = "/getEmployees")
    List<Employees> getEmployees();

    @RequestMapping(value = "/getEmployeeById")
    List<Employees> getEmployeeById(@RequestParam("id") Integer id);
}
