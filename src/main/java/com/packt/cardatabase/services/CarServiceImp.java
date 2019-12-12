package com.packt.cardatabase.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.repositories.CarRepository;

@Service
public class CarServiceImp implements CarService {
	@Autowired
	private CarRepository repository;

	@Override
	public Iterable<Car> getCars() {
		return repository.findAll();
	}

	@Override
	public void addCar(Car car) {
		repository.save(car);
	}

	@Override
	public void delCar(Car car) {
		repository.delete(car);
	}

	@Override
	public Optional<Car> getCar(long id) {
		return repository.findById(id);
	}
}
