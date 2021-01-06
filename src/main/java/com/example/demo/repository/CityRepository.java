package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.City;

/**
 * @author Prashant Sarkar
 *
 */
@Repository
public interface CityRepository extends CrudRepository<City, Long> {

}