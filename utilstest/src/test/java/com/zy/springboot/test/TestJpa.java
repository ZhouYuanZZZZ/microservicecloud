package com.zy.springboot.test;

import com.zy.springboot.jpa.*;
import com.zy.utils.CollectionUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJpa {

    @Resource
    private EmployeesRepository employeesRepository;

    @Resource
    private EmployeesRepository0 employeesRepository0;

    @Resource
    private EmployeesRepository1 employeesRepository1;

    @Resource
    private EntityManager entityManager;

    @Resource
    private LocationsRepository locationsRepository;

    @Test
    public void test0(){
        Iterable<EmployeesEntity> employeesEntityIterable = employeesRepository.findAll();
        Iterator iterator = employeesEntityIterable.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        Optional<EmployeesEntity> entity = employeesRepository.findById(100);
        EmployeesEntity employeesEntity = entity.get();

        System.out.println(employeesEntity);
    }

    @Test
    public void test2(){

        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<EmployeesEntity> page = employeesRepository0.findAll(pageRequest);

        System.out.println("总记录数: "+page.getTotalElements());
        System.out.println("总页数: "+page.getTotalPages());
        System.out.println("当前第几页: "+page.getNumber());
        System.out.println("当前页面记录数: "+page.getNumberOfElements());
        System.out.println("当前页面数据: "+page.getContent());

    }

    @Test
    public void test3(){

        Sort.Order salary = new Sort.Order(Sort.Direction.DESC, "salary");
        Sort.Order employeeId = new Sort.Order(Sort.Direction.DESC, "employeeId");
        Sort sort = new Sort(salary,employeeId);


        Iterable<EmployeesEntity> all = employeesRepository0.findAll(sort);
        Iterator<EmployeesEntity> iterator = all.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        List<EmployeesEntity> emps = employeesRepository0.findByFirstNameLike("K%");

       for(EmployeesEntity entity:emps){
           System.out.println(entity);
       }
    }

    @Test
    public void test5(){

        StoredProcedureQuery store = entityManager.createNamedStoredProcedureQuery("procedurep0");
        store.setParameter("arg", 10);
        store.execute();

        store.getOutputParameterValue(1);

    }

    @Test
    public void test6(){

        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<LocationsEntity> page = locationsRepository.findAll(pageRequest);

        System.out.println("总记录数: "+page.getTotalElements());
        System.out.println("总页数: "+page.getTotalPages());
        System.out.println("当前第几页: "+page.getNumber());
        System.out.println("当前页面记录数: "+page.getNumberOfElements());
        System.out.println("当前页面数据: "+page.getContent());

    }

    @Test
    public void test7(){

        //查询条件数据对象
        EmployeesEntity entity = new EmployeesEntity();
        entity.setFirstName("k");

        //创建匹配器 即如何使用查询条件
        ExampleMatcher matching = ExampleMatcher.matching()
        //采用以xxx开始模式进行匹配
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.startsWith())
                //忽略不参与
                .withIgnorePaths("employeeId");

        //创建实例
        Example<EmployeesEntity> ex = Example.of(entity, matching);


        //执行查询
        List<EmployeesEntity> all = employeesRepository1.findAll(ex);

        CollectionUtil.showCollection(all);


    }
}
