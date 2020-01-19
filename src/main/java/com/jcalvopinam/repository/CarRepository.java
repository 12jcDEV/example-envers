package com.jcalvopinam.repository;

import com.jcalvopinam.domain.Car;
import com.jcalvopinam.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {
}
