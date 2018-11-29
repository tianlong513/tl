package com.tl.mapper;

import com.tl.entity.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: tl
 * @description: 地区
 * @author:
 * @create: 2018-11-28 14:22
 **/
public interface RegionMapper {

    public List<Region> province();

    public List<Region> city(@Param("provinceId") Integer provinceId);

    public List<Region> area(@Param("city") Integer city);

}
