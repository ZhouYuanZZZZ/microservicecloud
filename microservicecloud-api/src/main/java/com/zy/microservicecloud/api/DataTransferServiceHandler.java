package com.zy.microservicecloud.api;

import com.zy.microservicecloud.entity.Employees;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


public class DataTransferServiceHandler implements DataTransferService {


    @Override
    public List<Employees> getEmployees() {

        List<Employees> list = new ArrayList<>();
        return list;
    }

    @Override
    public List<Employees> getEmployeeById(Integer id) {
        List<Employees> list = new ArrayList<>();

        Employees employees = new Employees();
        employees.setFirstName("xxxx");
        employees.setLastName("xxxx");

        list.add(employees);

        return list;
    }
}
