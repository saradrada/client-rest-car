package com.packt.cardatabase.delegate;

import com.packt.cardatabase.domain.Car;

public interface CarDelegateTB {

	public Iterable<Car> getCars();

	public Car addCar(Car newcar);

	public void delCar(Car car);

	public Car getCar(int i);
}
