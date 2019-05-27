package com.zy.springboot.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.math.BigDecimal;

public interface LocationsRepository extends PagingAndSortingRepository<LocationsEntity, BigDecimal> {

}
