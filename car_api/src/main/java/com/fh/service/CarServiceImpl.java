package com.fh.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.common.ServerResponse;
import com.fh.mapper.AreaMapper;
import com.fh.mapper.CarMapper;
import com.fh.model.Area;
import com.fh.model.Car;
import com.fh.model.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    @Resource
    private CarMapper carMapper;

    @Resource
    private AreaMapper areaMapper;

    @Override
    public ServerResponse queryList(Page page) {
        Map map = new HashMap();
        List list = carMapper.queryList(page);
        Integer total = carMapper.selectCount(null);
        map.put("draw", page.getDraw());
        map.put("recordsTotal", total);
        map.put("recordsFiltered", total);
        map.put("data", list);
        return ServerResponse.success(map);
    }

    @Override
    public ServerResponse addCar(Car car) {
        carMapper.insert(car);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse getIdByCar(Integer id) {
        Car car = carMapper.selectById(id);
        return ServerResponse.success(car);
    }

    @Override
    public ServerResponse updateCar(Car car) {
        carMapper.updateCar(car);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse getPidByArea(Integer pid) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("pid", pid);
        List<Area> list = areaMapper.selectList(queryWrapper);
        return ServerResponse.success(list);
    }
}
