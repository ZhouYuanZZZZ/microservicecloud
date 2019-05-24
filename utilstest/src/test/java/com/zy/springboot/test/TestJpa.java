package com.zy.springboot.test;

import com.zy.springboot.jpa.EmployeesEntity;
import com.zy.springboot.jpa.EmployeesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Iterator;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJpa {

    @Resource
    private EmployeesRepository employeesRepository;

    @Test
    public void test0(){
        Iterable<EmployeesEntity> employeesEntityIterable = employeesRepository.findAll();
        Iterator iterator = employeesEntityIterable.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
