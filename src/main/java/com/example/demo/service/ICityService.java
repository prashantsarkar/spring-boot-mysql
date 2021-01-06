package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.vo.City;

/**
 * @author Prashant Sarkar
 *
 */
public interface ICityService {
	List<City> findAll();
	City saveCity(City city);
	Optional<City> findById(Long cityId);
	void delete(City city);
}
