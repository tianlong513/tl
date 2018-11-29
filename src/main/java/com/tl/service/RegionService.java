package com.tl.service;

import com.tl.entity.Region;

import java.util.List;

public interface RegionService {
    public List<Region> province();

    public List<Region> city(Integer provinceId);

    public List<Region> area(Integer city);
}
