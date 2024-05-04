package com.restapi.SpringBandAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.SpringBandAPI.model.Band;


public interface SpringDataRepository extends CrudRepository<Band, Integer> {

}