package com.fh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.model.Car;
import com.fh.model.Page;

import java.util.List;

public interface CarMapper extends BaseMapper<Car> {
    List queryList(Page page);

    void updateCar(Car car);
}
