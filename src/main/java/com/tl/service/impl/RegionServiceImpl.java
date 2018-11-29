package com.tl.service.impl;

import com.tl.entity.Region;
import com.tl.mapper.RegionMapper;
import com.tl.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-11-28 16:06
 **/
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<Region> province() {

        return regionMapper.province();
    }

    @Override
    public List<Region> city(Integer provinceId) {
        return regionMapper.city(provinceId);
    }

    @Override
    public List<Region> area(Integer city) {
        return regionMapper.area(city);
    }
}
