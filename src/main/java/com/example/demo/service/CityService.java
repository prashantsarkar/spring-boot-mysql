/**
 * 
 */
package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CityRepository;
import com.example.demo.vo.City;

/**
 * @author Prashant Sarkar
 *
 */
@Service
public class CityService implements ICityService {
	@Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }
    
    @Override
    public City saveCity(City city) {
        return repository.save(city);
    }

    @Override
	public Optional<City> findById(Long cityId) {
		return repository.findById(cityId);
	}
    
    @Override
	public void delete(City city) {
		repository.delete(city);
	}
}
