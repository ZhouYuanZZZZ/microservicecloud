package com.zy.springboot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.springboot.jpa.EmployeesEntity;
import com.zy.springboot.jpa.EmployeesRepository0;
import com.zy.springboot.validation.LoginForm;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.validation.Valid;
import java.util.*;

@RestController
public class TestController {

    @Resource
    private EntityManager entityManager;

    @Resource
    private EmployeesRepository0 employeesRepository0;

    @RequestMapping(value = "test0")
    public Integer test0(){
        StoredProcedureQuery store = entityManager.createNamedStoredProcedureQuery("procedurep0");

        store.registerStoredProcedureParameter("arg", Integer.class,ParameterMode.IN);
        store.registerStoredProcedureParameter("res000", Integer.class,ParameterMode.OUT);

        store.setParameter("arg", 10);
        store.execute();

        Integer outputParameterValue = (Integer) store.getOutputParameterValue("res000");

        return outputParameterValue;

    }

    @RequestMapping(value = "getAllEmps")
    public List<EmployeesEntity> getAllEmps(){

        Iterable<EmployeesEntity> iterable = employeesRepository0.findAll();
        Iterator<EmployeesEntity> iterator = iterable.iterator();

        List<EmployeesEntity> employeesEntities = new ArrayList<>();

        while (iterator.hasNext()){
            employeesEntities.add(iterator.next());
        }

        return employeesEntities;
    }

    @RequestMapping(value = "test1")
    public String test1(String name){
        return name;
    }

    @RequestMapping(value = "test2",produces = "application/json;charset=UTF-8")
    public String test2(@Valid LoginForm loginForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            List<String> errors = new ArrayList<>();
            for(ObjectError error:allErrors){
                errors.add(error.getDefaultMessage());
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error",errors);

            return jsonObject.toJSONString();
        }

        return JSON.toJSONString(loginForm);
    }

    @RequestMapping(value = "test3",produces = "application/json;charset=UTF-8")
    public String test3(@RequestBody @Valid LoginForm loginForm,BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            List<String> errors = new ArrayList<>();
            for(ObjectError error:allErrors){
                errors.add(error.getDefaultMessage());
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error",errors);

            return jsonObject.toJSONString();
        }

        return JSON.toJSONString(loginForm);

    }
}
