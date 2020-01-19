package com.jcalvopinam.service;

import com.jcalvopinam.domain.Car;
import com.jcalvopinam.dto.CarDTO;

import java.util.List;

public interface CarService {


    List<Car> findAll();

    Car findById(String id);

    String save(CarDTO carDTO);

    String update(CarDTO carDTO);

    String deleteById(String id);



}
