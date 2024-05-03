package com.restapi.springbandapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.springbandapi.model.Band;


public interface SpringDataRepository extends CrudRepository<Band, Integer> {

}