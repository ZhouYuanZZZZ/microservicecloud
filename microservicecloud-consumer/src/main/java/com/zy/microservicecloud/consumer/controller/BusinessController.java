package com.zy.microservicecloud.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.zy.microservicecloud.entity.Employees;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BusinessController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/getEmployees", produces = "application/json;charset=UTF-8")
    public String getEmployees() {
        String url = "http://SERVICE0/getEmployees";
        List employees = restTemplate.getForObject(url, List.class);

        return JSON.toJSONString(employees);
    }
}
