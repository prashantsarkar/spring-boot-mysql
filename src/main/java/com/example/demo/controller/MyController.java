package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ICityService;
import com.example.demo.vo.City;

/**
 * @author Prashant Sarkar
 *
 */
@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	private ICityService cityService;

	@GetMapping("/cities")
	public List<City> findCities() {
		return cityService.findAll();
	}

	@PostMapping("/cities")
	public City createCity(@RequestBody City city) {
		return cityService.saveCity(city);
	}

	@GetMapping("/cities/{id}")
	public City getCityById(@PathVariable(value = "id") Long cityId) {
		return cityService.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));
	}

	@PutMapping("/cities/{id}")
	public City updateCity(@PathVariable(value = "id") Long cityId, @RequestBody City cityDetails) {

		City city = getCityById(cityId);
		city.setName(cityDetails.getName());
		city.setPopulation(cityDetails.getPopulation());

		return cityService.saveCity(city);
	}
	
	@DeleteMapping("/cities/{id}")
	public ResponseEntity<?> deleteCity(@PathVariable(value = "id") Long cityId) {
		City city = cityService.findById(cityId).orElseThrow(() -> new ResourceNotFoundException("City", "id", cityId));

		cityService.delete(city);

		return ResponseEntity.ok().build();
	}
}
