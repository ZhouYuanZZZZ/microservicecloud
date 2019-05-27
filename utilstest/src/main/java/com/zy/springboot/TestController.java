package com.zy.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@RestController
public class TestController {

    @Resource
    private EntityManager entityManager;

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
}
