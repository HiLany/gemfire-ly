package com.ly.simple.cao.impl;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.ly.simple.cao.RegionCao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by lany on 2019/6/20.
 */
@Service
public class IRegionCao implements RegionCao {

    private ClientCache clientCache;

    private Region<String,String> region;

    public IRegionCao() {
        this.clientCache = new ClientCacheFactory().set("name", "Client1").set("cache-xml-file", "cache-client.xml").create();
        this.region = this.clientCache.getRegion("regionA");
        System.out.println(this.region);
    }


    @Override
    public void put(String id, String value) {
        region.put(id,value);
    }

    @Override
    public boolean remove(String id) {
        String result = findOne(id);
        if(result!=null){
            region.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public String findOne(String id) {
        return region.get(id);
    }

    @Override
    public List<String> findAll() {
//        region.
        Collection<String> colls = region.values();
        System.out.println(region.values().size());
        if(colls.size() > 0){
            return new ArrayList<>(colls);
        }
        return null;
    }
}
