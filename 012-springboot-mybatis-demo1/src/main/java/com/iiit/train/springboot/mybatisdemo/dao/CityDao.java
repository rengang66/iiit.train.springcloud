package com.iiit.train.springboot.mybatisdemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iiit.train.springboot.mybatisdemo.vo.City;

public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}