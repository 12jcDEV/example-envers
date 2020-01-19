package com.jcalvopinam.service.impl;

import com.jcalvopinam.domain.Car;
import com.jcalvopinam.domain.Person;
import com.jcalvopinam.dto.CarDTO;
import com.jcalvopinam.dto.PersonDTO;
import com.jcalvopinam.repository.CarRepository;
import com.jcalvopinam.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
    private final CarRepository carRepository;
    private String response;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(String id) {
        return carRepository.findOne(id);
    }

    @Override
    public String save(CarDTO carDTO) {
        response = "Car Saved!";
        carRepository.save(new Car(carDTO));
        logger.info(response);
        return response;
    }

    @Override
    public String update(CarDTO carDTO) {
        response = "Car updated!";
        Car car = carRepository.findOne(carDTO.getId());
        car = this.updateCar(car, carDTO);
        carRepository.save(car);
        logger.info(response);
        return response;

    }

    @Override
    public String deleteById(String id) {
        response = "Car deleted!";
        carRepository.delete(id);
        logger.info(response);
        return response;
    }



    private Car updateCar(Car car, CarDTO dto) {
        car.setColor(dto.getColor());
        car.setName(dto.getName());
        return car;
    }

}
