package com.jcalvopinam.web;


import com.jcalvopinam.domain.Car;
import com.jcalvopinam.domain.Person;
import com.jcalvopinam.dto.CarDTO;
import com.jcalvopinam.dto.PersonDTO;
import com.jcalvopinam.service.CarService;
import com.jcalvopinam.service.PersonService;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> findAllCars() {
        logger.info("Find all persons");
        return carService.findAll();
    }

    @PostMapping
    public String saveCar(@RequestBody CarDTO carDTO) {
        Validate.notNull(carDTO, "The car cannot be null");
        logger.info(String.format("Saving car: %s", carDTO.toString()));
        return carService.save(carDTO);
    }

    @PutMapping
    public String updateCar(@RequestBody CarDTO carDTO) {
        Validate.notNull(carDTO, "The car cannot be null");
        logger.info(String.format("Updating car: %s", carDTO.toString()));
        return carService.update(carDTO);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCar(@PathVariable String id) {
        logger.info(String.format("Deleting car: %s", id));
        return carService.deleteById(id);
    }

}
