package com.ly.client.cao.impl;

import com.ly.client.cao.OrganizationCao;
import com.ly.client.common.RegionConstants;
import com.ly.client.config.GFRegions;
import com.ly.client.utils.GenericCAO;
import com.ly.domain.entity.Organization;
import org.apache.geode.pdx.PdxInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *  Implementation of OrganizationCao.
 * Created by lany on 2019/6/20.
 */
@Service
public class IOrganizationCao extends GFRegions implements OrganizationCao {

    protected final Logger log = LoggerFactory.getLogger(IOrganizationCao.class);

    @Override
    public void put(String id, Organization organization) {
        org_region.put(id,organization);
    }

    @Override
    public boolean delete(String id) {

        Organization organization = findOne(id);
        if(organization != null){

            org_region.remove(organization);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAll() throws Exception{
        return GenericCAO.clearRegion(RegionConstants.ORGANIZATION);
    }

    @Override
    public Organization findOne(String id) {
        Object object;

        try {
            object = org_region.get(id);
            Objects.requireNonNull(object);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Can not find Entry by Key -->> {}",id);
            return null;
        }
        Organization organization = (Organization)((PdxInstance) object).getObject();
        return organization;
    }

    @Override
    public List<Organization> findAll() throws Exception{

        String oql = "select * from /organization";
        Map<String,String> params = new HashMap<>();
        params.put("OQL",oql);
        params.put("RegionName","organization");
        List<PdxInstance> results = GenericCAO.execQuery(params);
        if(results.size() <= 0){
            return null;
        }
        List<Organization> organizations = new ArrayList<>();
        for(PdxInstance pdxInstance: results){
            Object object = pdxInstance.getObject();
            if(object instanceof PdxInstance)
                organizations.add((Organization)object);
            else
                log.warn("Object is not instanceof PdxInstance");
        }
        return organizations;
    }
}
