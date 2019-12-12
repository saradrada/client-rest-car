package com.packt.cardatabase.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.TransactionBody;
import com.packt.cardatabase.services.CarService;

@RestController
public class CarControllerImp implements CarController {
	@Autowired
	private CarService service;

	@GetMapping("/cars/{id}")
	public Optional<Car> getCar(@PathVariable long id) {
		return service.getCar(id);
	}

	@GetMapping("/cars")
	public Iterable<Car> getCars() {
		return service.getCars();
	}

	@PostMapping("/cars")
	public Car addCar(@RequestBody Car car) {
		service.addCar(car);
		return car;
	}

	@DeleteMapping("/cars/{id}")
	public Car delCar(@PathVariable long id) {
		Optional<Car> car = service.getCar(id);
		service.delCar(car.get());
		return car.get();
	}

	@GetMapping("/carstb/{id}")
	public ResponseEntity<TransactionBody<Car>> getCarTb(@PathVariable long id) {
		Optional<Car> car = service.getCar(id);
		TransactionBody<Car> transaction = new TransactionBody<Car>("NewCar", car.get());
		ResponseEntity<TransactionBody<Car>> response = new ResponseEntity<TransactionBody<Car>>(transaction,
				HttpStatus.SEE_OTHER);

		return response;
	}

	@GetMapping("/carstb")
	public TransactionBody<Iterable<Car>> getCarsTb() {
		TransactionBody<Iterable<Car>> tb = new TransactionBody<Iterable<Car>>();
		tb.setBody(service.getCars());
		return tb;
	}

	@PostMapping("/carstb")
	public ResponseEntity<TransactionBody<Car>> addCarTb(@RequestBody TransactionBody<Car> newCar) {
		Car car = newCar.getBody();
		service.addCar(car);
		TransactionBody<Car> transaction = new TransactionBody<Car>("NewCar", car);
		ResponseEntity<TransactionBody<Car>> response = new ResponseEntity<TransactionBody<Car>>(transaction,
				HttpStatus.SEE_OTHER);
		return response;
	}

	@DeleteMapping("/carstb")
	public ResponseEntity<TransactionBody<Car>> delCarTb(@RequestBody TransactionBody<Car> delCar) {
		Car car = delCar.getBody();
		service.delCar(car);
		TransactionBody<Car> transaction = new TransactionBody<Car>("DelCar", car);
		ResponseEntity<TransactionBody<Car>> response = new ResponseEntity<TransactionBody<Car>>(transaction,
				HttpStatus.SEE_OTHER);
		return response;
	}
}