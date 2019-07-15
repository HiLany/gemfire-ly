package com.ly.client.utils;

import com.ly.client.collections.OrganizationOQLQueryFunctionCollection;
import com.ly.client.common.ExceptionCodeConstants;
import com.ly.client.config.GFRegions;
import com.ly.client.exception.GemfireServiceRuntimeException;
import com.ly.domain.common.FunctionConstants;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;
import org.apache.geode.pdx.PdxInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * Created by lany on 2019/6/20.
 */
public class GenericCAO extends GFRegions{

    private static Logger log = LoggerFactory.getLogger(GenericCAO.class);

    /**
     * 根据传入的sql，来进行oql查询
     * * @param params 调用oql查询所需要传入的参数
     * @param params Map<String,String> inputParams
     * @return
     * @throws Exception
     */
    public static List<PdxInstance> execQuery(Map<String,String> params) throws Exception{

        log.info("Params ----> {}",params);
        try {

            String oql = params.get("OQL");
            String regionName = params.get("RegionName");
            if(oql.equals("")||regionName.equals("")){
                log.error("The parameters do not conform to the specification");
                return null;
            }
            ResultCollector resultCollector = FunctionService.onRegion(getRegion(regionName))
                    .withCollector(new OrganizationOQLQueryFunctionCollection())
                    .setArguments(oql)
                    .execute(FunctionConstants.OQL_QUERY_FUNCTION);

            ArrayList<PdxInstance> results = (ArrayList<PdxInstance>) resultCollector.getResult();
            return results;
        } catch (Exception e) {
            log.error("Exception : {}",e);
            throw new GemfireServiceRuntimeException(ExceptionCodeConstants.ERR_OQL_QUERY_CODE,FunctionConstants.OQL_QUERY_FUNCTION);
        }

    }

    /**
     * 根据region的名称清空该region上的所有数据
     * @param regionName
     */
    public static boolean clearRegion(String regionName) throws Exception{

        log.info("RegionName --->>>>  {}",regionName);

        try {
            if(regionName.equals("")||regionName == null){
                log.error("Invalid RegionName");
                return false;
            }
            ResultCollector resultCollector = FunctionService.onServers(getPool())
                    .setArguments(regionName)
                    .execute(FunctionConstants.CLEAR_REGION_FUNCTION);
            Map<String,Object> results = (Map<String, Object>) ((List) resultCollector.getResult()).get(0);
            log.info("Remove {} rows",results.get("Size"));
            return Boolean.parseBoolean(results.get("Flag").toString());
        } catch (Exception e) {
            log.error("Exception : {}",e);
            throw new GemfireServiceRuntimeException(ExceptionCodeConstants.ERR_CLEAR_REGION_CODE,FunctionConstants.CLEAR_REGION_FUNCTION);
        }


    }

}
