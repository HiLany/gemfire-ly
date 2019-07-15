#!/usr/bin/env bash

LOCATOR_PORT=10334
# HOSTNAME=192.168.0.114

export CLASSPATH=$CLASSPATH:/Users/lany/LearnProjects/gemfire-ly/lib/gemfire-ly-domain-0.0.1-SNAPSHOT.jar
#export CLASSPATH=$CLASSPATH:/Users/lany/LearnProjects/gemfire-ly/lib/gemfire-greenplum-3.1.0.jar

gfsh  start locator --name=locator --dir=../work/locator \
    --properties-file=../config/gflocator.properties \
    --port=$LOCATOR_PORT \
    --security-properties-file=../config/gfsecurity.properties \
    --include-system-classpath
