package com.packt.cardatabase.delegatetest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.packt.cardatabase.delegate.CarDelegate;
import com.packt.cardatabase.domain.Car;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class CarDelegateTest {
	
	@Autowired
	private CarDelegate carDelegate;
	
	@Test
	public void testCars()
	{
		Iterable<Car> cars = carDelegate.getCars();
		for (Car car : cars) {
			log.info(car.getRegisterNumber());
			
		}
	}
	
	@Test
	public void testAddCar() {
		Car newcar = new Car("Ford", "Mustang", "Red", "PDF-1121", 2017, 59000);
		Car car = carDelegate.addCar(newcar);
		log.info(car.getRegisterNumber());
	}

	@Test
	public void testDelCar() {
		Iterable<Car> cars = carDelegate.getCars();
		for (Car car : cars) {
			log.info(car.getId() +"-" + car.getRegisterNumber());
		}
			
		Car delcar = carDelegate.getCar(2);
		carDelegate.delCar(delcar);

		cars = carDelegate.getCars();
		for (Car car2 : cars) {
			log.info(car2.getId() +"-" +car2.getRegisterNumber());
		}
	}
	
}
