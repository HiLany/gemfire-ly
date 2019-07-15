#!/usr/bin/env bash

LOCATOR_PORT=10334
SERVER_PORT=40404

echo "Export CLASSPATH..."

export CLASSPATH=$CLASSPATH:/Users/lany/LearnProjects/gemfire-ly/lib/gemfire-ly-domain-0.0.1-SNAPSHOT.jar
#export CLASSPATH=$CLASSPATH:/Users/lany/LearnProjects/gemfire-ly/lib/gemfire-greenplum-3.1.0.jar

gfsh start server --name=server --dir=../work/server --locators=localhost[$LOCATOR_PORT] \
    --properties-file=../config/gfserver.properties \
    --security-properties-file=/Users/lany/LearnProjects/gemfire-ly/gflocator/config/gfsecurity.properties \
    --user=admin --password=passw0rd \
    --include-system-classpath

