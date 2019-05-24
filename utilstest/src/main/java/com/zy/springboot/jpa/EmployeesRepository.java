package com.zy.springboot.jpa;


import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<EmployeesEntity,Integer> {

}
