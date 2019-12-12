package com.packt.cardatabase.services;

import java.util.Optional;

import com.packt.cardatabase.domain.Car;

public interface CarService {
	public Iterable<Car> getCars();

	public void addCar(Car car);

	public void delCar(Car car);

	public Optional<Car> getCar(long id);
}
