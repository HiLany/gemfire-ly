package com.ly.client.cao;

import com.ly.domain.entity.Organization;

import java.util.List;

/**
 * Operation Interface of Organization.
 * Created by lany on 2019/6/20.
 */
public interface OrganizationCao {

    void put(String id, Organization organization);

    boolean delete(String id);

    boolean deleteAll() throws Exception;

    Organization findOne(String id);

    List<Organization> findAll() throws Exception;

}
