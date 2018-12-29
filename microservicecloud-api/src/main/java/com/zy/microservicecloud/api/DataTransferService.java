package com.zy.microservicecloud.api;

import com.zy.microservicecloud.entity.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "service0")
public interface DataTransferService {

    @RequestMapping(value = "/getEmployees")
    List<Employees> getEmployees();

    @RequestMapping(value = "/getEmployeeById")
    List<Employees> getEmployeeById(@RequestParam("id") Integer id);
}
