package com.zy.springcloud.microservicecloudfeign.controller;

import com.alibaba.fastjson.JSON;
import com.zy.springcloud.microservicecloudfeign.api.DataTransferService;
import com.zy.springcloud.microservicecloudfeign.entity.Employees;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DataController {

    @Resource
    private DataTransferService dataTransferService;

    @RequestMapping(value = "/getEmployees", produces = "application/json;charset=UTF-8")
    public String getEmployees() {

        List<Employees> employees = dataTransferService.getEmployees();

        return JSON.toJSONString(employees);
    }

    @RequestMapping(value = "/getEmployeeById", produces = "application/json;charset=UTF-8")
    public String getEmployeeById(Integer id) throws InterruptedException {

        List<Employees> employees = dataTransferService.getEmployeeById(id);
        if(employees.size() == 0){
           Thread.sleep(3000);
        }

        return JSON.toJSONString(employees);
    }
}
