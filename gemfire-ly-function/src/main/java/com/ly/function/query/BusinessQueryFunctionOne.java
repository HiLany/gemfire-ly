package com.ly.function.query;

import com.ly.domain.common.FunctionConstants;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;

import java.util.Properties;

/**
 * BusinessQueryFunctionOne --
 * Created by lany on 2019/7/8.
 */
public class BusinessQueryFunctionOne implements Function,Declarable {

    private static final String id = FunctionConstants.BUSINESS_QUERY_FUNCTION_ONE;

    @Override
    public void execute(FunctionContext functionContext) {

    }

    @Override
    public void init(Properties props) {

    }

    @Override
    public boolean hasResult() {
        return false;
    }

    @Override
    public String getId() {
        return null;
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
