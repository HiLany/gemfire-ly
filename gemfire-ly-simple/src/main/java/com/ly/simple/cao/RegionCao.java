package com.ly.simple.cao;

import java.util.List;

/**
 * Created by lany on 2019/6/20.
 */
public interface RegionCao {

    void put(String id,String value);

    boolean remove(String id);

    String findOne(String id);

    List<String> findAll();

}
