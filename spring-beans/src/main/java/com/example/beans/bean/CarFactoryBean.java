package com.example.beans.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

/**
 *@ClassName VehicleFactoryBean
 *@Description TODO
 *@Author 11214
 *@Date 2021/5/20 23:53
 *@Version 1.0
 **/
@Setter
@Getter
public class CarFactoryBean implements FactoryBean<Car> {
    private String carInfo;
    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setPrice(Double.valueOf(infos[1]));
        return car;
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
