package com.product.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.CarEntity;
import com.product.exceptions.WrongProductIdException;
import com.product.repository.CarRepository;
import com.product.service.ProductService;
import com.product.to.CarTO;

@Service
public class CarServiceImpl implements ProductService<CarTO> {

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public List<CarTO> findAll() {
		
		List<CarEntity> cartEntities = carRepository.findAll();
		
		return cartEntities.stream()
						   .map(car -> new CarTO(car))
						   .collect(Collectors.toList());
	}

	@Override
	public List<CarTO> findByModel(String model) {
		List<CarEntity> cartEntities = carRepository.findByModel(model);
		
		return cartEntities.stream()
						   .map(car -> new CarTO(car))
						   .collect(Collectors.toList());
	}

	@Override
	public CarTO findById(Long id) {
		CarEntity car = carRepository.findById(id).orElse(new CarEntity());
		
		return new CarTO(car);
	}

	
}
