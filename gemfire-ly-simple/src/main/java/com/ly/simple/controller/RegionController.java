package com.ly.simple.controller;

import com.ly.simple.cao.RegionCao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lany on 2019/6/20.
 */
@RestController
@RequestMapping("/regionA")
public class RegionController {

    @Autowired
    private RegionCao regionCao;

    @GetMapping("/add")
    public String add(String key,String value){
        regionCao.put(key,value);
        return "Key: "+ key + ",Value:"+regionCao.findOne(key);
    }

    @GetMapping("/findOne")
    public String findOne(String id){
        return regionCao.findOne(id);
    }

    @DeleteMapping("/remove")
    public String remove(String id){
        if(regionCao.remove(id)){
            return "ID:" + id +" deleted";
        }
        return "Delete failed";
    }

    @GetMapping("/findAll")
    public List<String> findAll(){
        return regionCao.findAll();
    }

}
