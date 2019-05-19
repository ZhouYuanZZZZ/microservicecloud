package com.zy.springboot.test;

import com.zy.springboot.conf.entity.Entity0;
import com.zy.springboot.conf.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test0 {

    @Resource
    private Person person;

    @Resource
    private Entity0 entity0;

    @Test
    public void test0(){
        System.out.println(person);
    }

    @Test
    public void test1(){
        System.out.println(entity0);
    }

}
