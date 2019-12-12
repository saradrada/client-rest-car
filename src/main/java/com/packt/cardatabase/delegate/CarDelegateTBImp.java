package com.packt.cardatabase.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.TransactionBody;

@Component
public class CarDelegateTBImp implements CarDelegateTB {

	RestTemplate restTemplate;
	final String SERVER = "http://localhost:8080/";

	public CarDelegateTBImp() {
		restTemplate = new RestTemplate();
	}

	@Override
	public Car getCar(int id) {
		TransactionBody<Long> transaction = new TransactionBody<>("carid", new Long(id));
		HttpEntity<TransactionBody<Long>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Car>> response = null;

		response = restTemplate.exchange(SERVER + "/carstb/"+id, HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<Car>>() {
				});
		try {

			Car at = response.getBody().getBody();
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	}

	@Override
	public Iterable<Car> getCars() {
		TransactionBody<List<Car>> transaction = new TransactionBody<>("carList", new ArrayList<Car>());
		HttpEntity<TransactionBody<List<Car>>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<List<Car>>> response = null;

		response = restTemplate.exchange(SERVER + "/carstb", HttpMethod.GET, request,
				new ParameterizedTypeReference<TransactionBody<List<Car>>>() {
				});
		try {

			Iterable<Car> at = response.getBody().getBody();
			return at;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Car addCar(Car newcar) {
		TransactionBody<Car> transaction = new TransactionBody<>("newCar", newcar);
		HttpEntity<TransactionBody<Car>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Car>> response = null;

		response = restTemplate.exchange(SERVER + "/carstb", HttpMethod.POST, request,
				new ParameterizedTypeReference<TransactionBody<Car>>() {
				});

		return newcar;
	}

	@Override
	public void delCar(Car delcar) {
		TransactionBody<Car> transaction = new TransactionBody<>("delCar", delcar);
		HttpEntity<TransactionBody<Car>> request = new HttpEntity<>(transaction);
		ResponseEntity<TransactionBody<Car>> response = null;

		response = restTemplate.exchange(SERVER + "/carstb", HttpMethod.DELETE, request,
				new ParameterizedTypeReference<TransactionBody<Car>>() {
				});
	}
}
