package com.packt.cardatabase.delegatetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.packt.cardatabase.delegate.CarDelegateTB;
import com.packt.cardatabase.domain.Car;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class CarDelegateTBTest {

	@Autowired
	private CarDelegateTB carDelegate;

	@Test
	public void testGetCars() {
		Iterable<Car> cars = carDelegate.getCars();
		for (Car car : cars) {
			log.info(car.getRegisterNumber());

		}
	}

	@Test
	public void testAddCar() {
		Car newcar = new Car("Ford", "Mustang", "Red", "FDF-1121", 2017, 59000);
		Car car = carDelegate.addCar(newcar);
		log.info(car.getId()+"-"+car.getRegisterNumber());
	}

	@Test
	public void testDelCar() {
		Iterable<Car> cars = carDelegate.getCars();
		for (Car car : cars) {
			log.info(car.getId() + "- "+ car.getRegisterNumber());

		}
		Car delcar = carDelegate.getCar(1);
		carDelegate.delCar(delcar);

		cars = carDelegate.getCars();
		for (Car car : cars) {
			log.info(car.getRegisterNumber());

		}
	}
}
