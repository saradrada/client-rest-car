package com.packt.cardatabase.delegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.packt.cardatabase.domain.Car;

@Component
public class CarDelegateImp implements CarDelegate {

	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";

	public CarDelegateImp() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Car getCar(int id) {
		Car car = restTemplate.getForObject(SERVER + "cars/" + id, Car.class);
		return car;
	}

	@Override
	public Iterable<Car> getCars() {
		Car[] cars = restTemplate.getForObject(SERVER + "cars", Car[].class);
		List<Car> at;
		try {
			at = Arrays.asList(cars);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Car addCar(Car newcar) {
		Car car = restTemplate.postForEntity(SERVER + "cars", newcar, Car.class).getBody();
		return car;
	}

	@Override
	public void delCar(Car car) {
		restTemplate.delete(SERVER + "cars/"+car.getId());
	}

}
