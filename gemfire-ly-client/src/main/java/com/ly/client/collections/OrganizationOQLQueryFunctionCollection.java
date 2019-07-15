package com.ly.client.collections;

import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.ResultCollector;
import org.apache.geode.distributed.DistributedMember;
import org.apache.geode.pdx.PdxInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by lany on 2019/6/20.
 */
public class OrganizationOQLQueryFunctionCollection implements ResultCollector<Object,List<Collection<PdxInstance>>> {

    protected final Logger log = LoggerFactory.getLogger(OrganizationOQLQueryFunctionCollection.class);

    private ArrayList results = new ArrayList();

    @Override
    public List<Collection<PdxInstance>> getResult() throws FunctionException {
        return results;
    }

    @Override
    public List<Collection<PdxInstance>> getResult(long l, TimeUnit timeUnit) throws FunctionException, InterruptedException {
        return getResult();
    }

    @Override
    public void addResult(DistributedMember distributedMember, Object o) {
        List<Collection<PdxInstance>> result = (List<Collection<PdxInstance>>)o;
        log.info("DistributedMemberName ---> {}, Results -----> {}", distributedMember.getName(),result.toString());
        results.addAll(new ArrayList(result));
    }

    @Override
    public void endResults() {

    }

    @Override
    public void clearResults() {
        results = new ArrayList();
    }
}
