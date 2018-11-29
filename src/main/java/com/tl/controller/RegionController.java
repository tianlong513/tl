package com.tl.controller;

import com.tl.entity.Region;
import com.tl.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tl
 * @description:
 * @author:
 * @create: 2018-11-28 16:09
 **/
@Controller
@RequestMapping(value = "sys")
public class RegionController {
    @Autowired
    RegionService regionService;

    @RequestMapping(value = "sendRegion")
    public ModelAndView RegionInfo() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        List<Region> regions = regionService.province();
        mav.addObject("regions", regions);
        return mav;
    }

    @RequestMapping(value = "city")
    @ResponseBody
    public Object city(Integer provinceId) {
        System.out.println("请求查询");
        Map<String, Object> resultMap = new HashMap<>();
        List<Region> regions = regionService.city(provinceId);
        resultMap.put("result", regions);
        return resultMap;
    }

    @RequestMapping(value = "area")
    @ResponseBody
    public Object area(Integer cityId) {
        System.out.println("请求查询");
        Map<String, Object> resultMap = new HashMap<>();
        List<Region> regions = regionService.city(cityId);
        resultMap.put("result", regions);
        return resultMap;
    }
}
