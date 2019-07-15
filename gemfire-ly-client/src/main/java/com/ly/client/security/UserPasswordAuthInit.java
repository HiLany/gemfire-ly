package com.ly.client.security;

import org.apache.geode.LogWriter;
import org.apache.geode.distributed.DistributedMember;
import org.apache.geode.security.AuthInitialize;
import org.apache.geode.security.AuthenticationFailedException;

import java.util.Properties;

/**
 * Created by lany on 2019/6/25.
 */
public class UserPasswordAuthInit implements AuthInitialize {

    static final String USERNAME = "security-username";
    static final String PASSWORD = "security-password";

    private LogWriter securitylog;
    private LogWriter systemlog;

    public static AuthInitialize create(){
        return new UserPasswordAuthInit();
    }


    @Override
    public void init(LogWriter securitylog, LogWriter systemlog) throws AuthenticationFailedException {
        this.securitylog = securitylog;
        this.systemlog = systemlog;
    }



    @Override
    public Properties getCredentials(Properties securityProps, DistributedMember distributedMember, boolean b) throws AuthenticationFailedException {
        Properties credentials = new Properties();
        String userName = securityProps.getProperty(USERNAME);
        if(userName == null){
            throw new AuthenticationFailedException("UserPasswordAuthInit : user name property ["+userName+"] not set.");
        }
        credentials.setProperty(USERNAME, userName);
        String passwd = securityProps.getProperty(PASSWORD);
        if(passwd == null){
            throw  new AuthenticationFailedException("UserPasswordAuthInit : password property ["+passwd+"] not set.");
        }
        credentials.setProperty(PASSWORD, passwd);
        systemlog.info("username : "+userName+" ---  password : "+passwd);
        securitylog.info("SampleAuthInit: successfully obtained credentials for user "
                + userName);
        return credentials;
    }

    @Override
    public void close() {

    }
}
