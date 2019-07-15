package com.ly.client.config;

import com.ly.client.common.RegionConstants;
import com.sun.deploy.util.SessionState;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.Pool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gemfire ClientCache Configuration
 * Created by lany on 2019/6/20.
 */
public class GFRegions {

    protected static final Logger log = LoggerFactory.getLogger(GFRegions.class);


    private static ClientCache clientCache = new ClientCacheFactory()
            .set("security-client-auth-init", "com.ly.client.security.UserPasswordAuthInit.create")
            .set("security-username","admin")
            .set("security-password","passw0rd")
            .create();

    /** Organization Region **/
    public static Region<String,Object> org_region = getRegion(RegionConstants.ORGANIZATION);


    /**
     * Get region by region's name.
     * @param regionName
     * @return
     * @throws Exception
     */
    public static Region getRegion(String regionName){
        log.info(clientCache.getDistributedSystem().toString());
        log.info("RegionName ---> {}",regionName);
        Region region = clientCache.getRegion(regionName);
        log.info("Region ---> {}",region);
        if(region == null)
            log.warn("Can't get Region By RegionName : [ {} ]",regionName);
        return region;
    }

    /**
     * Get default pool
     * @return
     */
    public static Pool getPool(){
        log.info("Get Pool Method");
        Pool pool = clientCache.getDefaultPool();
        if(pool == null){
            log.warn("Get Pool Unsuccessful!");
        }
        return pool;
    }


}
