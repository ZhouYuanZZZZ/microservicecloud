package com.zy.springcloud.microservicecloudfeign.api;

import com.zy.springcloud.microservicecloudfeign.entity.Employees;
import org.springframework.stereotype.Component;

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
        employees.setEmployeeId(id);
        employees.setFirstName("xxxx");
        employees.setLastName("xxxx");

        list.add(employees);

        return list;
    }
}
