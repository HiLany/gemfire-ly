package com.ly.client.controller;

import com.ly.client.cao.OrganizationCao;
import com.ly.client.cao.impl.IOrganizationCao;
import com.ly.domain.entity.Organization;
import org.apache.geode.cache.client.ClientCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lany on 2019/6/20.
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController {

    protected final Logger log = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationCao organizationCao;

    @GetMapping("/findAll")
    public List<Organization> findAll(){
        List<Organization> organizations;
        try {
            organizations = organizationCao.findAll();
            if(organizations == null && !organizations.isEmpty()){
                return organizations;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/deleteAll")
    public boolean deleteAllOrganization(){
        boolean result = false;
        try {
            result = organizationCao.deleteAll();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        return result;
    }

    @PostMapping("/addOrganization")
    public void addOrganization(Organization organization){

    }


}
