package com.ly.function.operation;

import com.ly.domain.common.FunctionConstants;
import com.ly.function.query.OQLQueryFunction;
import org.apache.commons.collections.map.HashedMap;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.partition.PartitionRegionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * The function of Clear Region by Region's name
 * Created by lany on 2019/6/20.
 */
public class ClearRegionFunction implements Function,Declarable {

    protected final Logger log = LoggerFactory.getLogger(OQLQueryFunction.class);

    private String id = FunctionConstants.CLEAR_REGION_FUNCTION;

    @Override
    public void execute(FunctionContext functionContext) {
        // TODO: 2018/7/21 根据传入的region名称清空该region上的数据
        int size;
        boolean flag;
        try {
            String regionName = (String) functionContext.getArguments();
            Region region = CacheFactory.getAnyInstance().getRegion(regionName);

            if(PartitionRegionHelper.isPartitionedRegion(region)){
                region = PartitionRegionHelper.getLocalPrimaryData(region);
            }
            final Region lambdaRegin = region;
            lambdaRegin.removeAll(region.keySet());
            flag = true;
            size = region.size();
            log.debug(" Remove "+size+" keys ,Flag ->> "+flag);
            Map<String,Object> results = new HashedMap();
            results.put("Size",size);
            results.put("Flag",flag);
            functionContext.getResultSender().lastResult(results);
        } catch (Exception e) {
            log.error("Server Exception : {}", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean optimizeForWrite() {
        return false;
    }

    @Override
    public boolean isHA() {
        return false;
    }
}
