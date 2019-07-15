package com.ly.client.utils;

import com.ly.client.common.ExceptionCodeConstants;
import com.ly.client.config.GFRegions;
import com.ly.client.exception.GemfireServiceRuntimeException;
import org.apache.geode.cache.execute.Execution;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * utils ->  call function
 * Created by lany on 2019/6/24.
 */
public class FunctionCAO extends GFRegions{

    protected static Logger log = LoggerFactory.getLogger(FunctionCAO.class);

    /**
     * call function on all servers
     * @param funcName  function's name
     * @param inputParam  input parameters
     * @param isOnServers whether call on servers
     * @param hasResult whether return results
     */
    public static List<Map> callFunctionOnServers(String funcName, Map inputParam, boolean isOnServers, boolean hasResult) throws Exception{
         try {
            Execution ext;
            if(isOnServers){
                ext = FunctionService.onServers(getPool());
            }else
                ext = FunctionService.onServer(getPool());

            if(inputParam != null){
                ext.setArguments(inputParam);
            }
            if(hasResult){
                ResultCollector rc = ext.execute(funcName);
                List<Map> result_list = (List<Map>)rc.getResult();
                return result_list;
            }else {
                ext.execute(funcName);
                return null;
            }
        } catch (Exception e) {
            log.error("ExecuteFunction Error : {}",e);
            throw new GemfireServiceRuntimeException(ExceptionCodeConstants.ERR_CALL_FUNCTION_ON_SERVERS,funcName);
        }

    }

    /**
     * call function on region
     * @param funcName function's name
     * @param regionName region's name
     * @param inputParam input parameters
     * @return
     */
    public static List<Map> callFunctionOnRegion(String funcName,String regionName,Map inputParam) throws Exception{
        try {
            Execution ext = FunctionService.onRegion(getRegion(regionName));
            if(inputParam != null){
                ext.setArguments(inputParam);
            }
            ResultCollector rc = ext.execute(funcName);
            List<Map> result_list = (List<Map>)rc.getResult();
            return result_list;
        } catch (Exception e) {
            log.error("ExecuteFunction Error : {}",e);
            throw new GemfireServiceRuntimeException(ExceptionCodeConstants.ERR_CALL_FUNCTION_ON_REGION,funcName);
        }
    }
}
