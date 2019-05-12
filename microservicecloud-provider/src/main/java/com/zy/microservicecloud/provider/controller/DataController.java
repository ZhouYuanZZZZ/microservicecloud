package com.zy.microservicecloud.provider.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zy.microservicecloud.entity.Employees;
import com.zy.microservicecloud.mapper.EmployeesMapper;
import com.zy.microservicecloud.provider.Application;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {

    @Resource
    private EmployeesMapper employeesMapper;

    @RequestMapping(value = "/getEmployees")
    public ResponseEntity<String> getEmployees(){

        List<Employees> employees = employeesMapper.selectAll();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String result = JSON.toJSONString(employees);
        ResponseEntity responseEntity = new ResponseEntity(result, httpHeaders, HttpStatus.OK);

        return responseEntity;
    }

    @RequestMapping(value = "/getEmployeeById")
    public ResponseEntity<String> getEmployeeById(Integer id){

        Example example = new Example(Employees.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("employeeId",id);

        List<Employees> employees = employeesMapper.selectByExample(example);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String result = JSON.toJSONString(employees);
        ResponseEntity responseEntity = new ResponseEntity(result, httpHeaders, HttpStatus.OK);

        return responseEntity;

    }

    @RequestMapping(value = "/getEmployeeByIdHystrix")
    @HystrixCommand(fallbackMethod = "getEmployeeByIdHystrixHandler")
    public ResponseEntity<String> getEmployeeByIdHystrix(Integer id) throws InterruptedException {

        Example example = new Example(Employees.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("employeeId",id);

        List<Employees> employees = employeesMapper.selectByExample(example);
        if(employees.size() == 0){
            Thread.sleep(3000);
        }

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String result = JSON.toJSONString(employees);
        ResponseEntity responseEntity = new ResponseEntity(result, httpHeaders, HttpStatus.OK);

        return responseEntity;

    }

    public ResponseEntity<String> getEmployeeByIdHystrixHandler(Integer id){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        List<Employees> employees = new ArrayList<>();
        Employees employees1 = new Employees();
        employees1.setFirstName("xxx");
        employees1.setLastName("xxx");
        employees.add(employees1);
        String result = JSON.toJSONString(employees);

        ResponseEntity responseEntity = new ResponseEntity(result, httpHeaders, HttpStatus.OK);

        return responseEntity;
    }
}
