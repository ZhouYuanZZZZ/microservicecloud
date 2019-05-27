package com.zy.springboot.jpa;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeesRepository0 extends PagingAndSortingRepository<EmployeesEntity,Integer> {


    List<EmployeesEntity> findByFirstNameLike(String firstName);


}
