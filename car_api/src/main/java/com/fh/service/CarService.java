package com.fh.service;

import com.fh.common.ServerResponse;
import com.fh.model.Car;
import com.fh.model.Page;

public interface CarService {
    ServerResponse queryList(Page page);

    ServerResponse addCar(Car car);

    ServerResponse getIdByCar(Integer id);

    ServerResponse updateCar(Car car);

    ServerResponse getPidByArea(Integer pid);
}
