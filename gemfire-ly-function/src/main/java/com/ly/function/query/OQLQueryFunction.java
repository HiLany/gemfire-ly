package com.ly.function.query;

import com.ly.domain.common.FunctionConstants;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.query.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by lany on 2019/6/20.
 */
public class OQLQueryFunction implements Function,Declarable{

    protected final Logger log = LoggerFactory.getLogger(OQLQueryFunction.class);

    private static final String id = FunctionConstants.OQL_QUERY_FUNCTION;

    @Override
    public void execute(FunctionContext functionContext) {
        if(functionContext instanceof RegionFunctionContext){
            RegionFunctionContext rfc = (RegionFunctionContext)functionContext;
            String sql = (String) rfc.getArguments();
            QueryService queryService = CacheFactory.getAnyInstance().getQueryService();
            Query query = queryService.newQuery(sql);
            try {
                SelectResults selectResults = (SelectResults) query.execute();
                log.debug("SelectResults ---> {}",selectResults.asList().toString());
                rfc.getResultSender().lastResult(selectResults.asList());
            } catch (Exception e) {
                log.error("Function Exception : {}",e);
                throw new RuntimeException(e);
            }
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
