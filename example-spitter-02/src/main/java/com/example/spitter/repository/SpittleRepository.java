package com.example.spitter.repository;

import com.example.spitter.entity.Spittle;

import java.util.List;

/**
 *
 * Created by Richard on 2017/3/20.
 */
public interface SpittleRepository {
    /**
     * 获取Spittle列表
     * @return
     */
    List<Spittle> findSpittleAll();
}
