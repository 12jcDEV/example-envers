package com.jcalvopinam.domain;

import com.jcalvopinam.dto.CarDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Audited
@Table(name = "env_car")
public class Car implements Serializable {


    @Id
    @Column(name = "car_id", length = 36)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uuid_seq")
    @GenericGenerator(name = "uuid_seq", strategy = "com.jcalvopinam.domain.AppSequenceGenerator", parameters = {})
    private String id;

    private String name;

    private String color;

    public Car() {}

    public Car(CarDTO dto) {
        this.name = dto.getName();
        this.color = dto.getColor();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) &&
                Objects.equals(name, car.name) &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
