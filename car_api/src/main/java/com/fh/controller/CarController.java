package com.fh.controller;

import com.fh.common.ServerResponse;
import com.fh.model.Car;
import com.fh.model.Page;
import com.fh.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("queryList")
    public ServerResponse queryList(Page page) {
        return carService.queryList(page);
    }

    @RequestMapping("addCar")
    public ServerResponse addCar(Car car) {
        return carService.addCar(car);
    }

    @RequestMapping("getIdByCar")
    public ServerResponse getIdByCar(Integer id) {
        return carService.getIdByCar(id);
    }

    @RequestMapping("updateCar")
    public ServerResponse updateCar(Car car) {
        return carService.updateCar(car);
    }

    @RequestMapping("getPidByArea")
    public ServerResponse getPidByArea(Integer pid) {
        return carService.getPidByArea(pid);
    }
}
