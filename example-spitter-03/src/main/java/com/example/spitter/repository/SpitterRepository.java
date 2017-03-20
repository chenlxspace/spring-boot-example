package com.example.spitter.repository;


import com.example.spitter.entity.Spitter;

public interface SpitterRepository {

  /**
   * 保存
   * @param spitter
   * @return
   */
  Spitter save(Spitter spitter);

  /**
   * 根据名称查找
   * @param username
   * @return
   */
  Spitter findByUsername(String username);

}
