package com.packt.cardatabase.restcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.TransactionBody;

public interface CarController {
	public Iterable<Car> getCars();

	public Car addCar(Car car);

	public Car delCar(long id);

	public TransactionBody<Iterable<Car>> getCarsTb();

	public ResponseEntity<TransactionBody<Car>> addCarTb(TransactionBody<Car> newCar);

	public ResponseEntity<TransactionBody<Car>> delCarTb(TransactionBody<Car> newCar);
}
