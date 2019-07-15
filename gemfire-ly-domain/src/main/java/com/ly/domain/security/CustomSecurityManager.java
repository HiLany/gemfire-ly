package com.ly.domain.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.geode.security.AuthenticationFailedException;
import org.apache.geode.security.ResourcePermission;
import org.apache.geode.security.SecurityManager;


import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * Authenticator interface that is required to be implemented on a server/peer/locator that will authenticate a new client or peer member.
 * This callback is provided the credentials of the joining member as a set of properties as obtained fromAuthInitialize#getCredentials on the member.
 *
 * Created by lany on 2019/6/26.
 */
public class CustomSecurityManager implements SecurityManager{

    static final String SECURITY_USERNAME_PROP = "security-username";
    static final String SECURITY_PASSWORD_PROP = "security-password";


    public static SecurityManager create(){
        return new CustomSecurityManager();
    }

    public CustomSecurityManager() {
    }

    /**
     * Verify the credentials provided in the properties
     */
    @Override
    public Object authenticate(Properties properties) throws AuthenticationFailedException {

        String username = properties.getProperty(SECURITY_USERNAME_PROP);
        String password = properties.getProperty(SECURITY_PASSWORD_PROP);

        if(username == null || password == null){
            throw new AuthenticationFailedException("Authentication failed due to missing credentials");
        }

//        if(username.equals())

        return null;
    }

    @Override
    public void init(Properties securityProps) {
        String jsonPropertyValue = securityProps != null?securityProps.getProperty("security-json"):null;
        if(jsonPropertyValue == null) {
            jsonPropertyValue = "security.json";
        }
        if(!this.initializeFromJsonResource(jsonPropertyValue)) {
            throw new AuthenticationFailedException("ExampleSecurityManager: unable to find json resource \"" + jsonPropertyValue + "\" as specified by [" + "security-json" + "].");
        }
    }

    public boolean initializeFromJsonResource(String jsonResource) {
        System.out.println(ClassLoader.getSystemClassLoader().toString());
            InputStream input = ClassLoader.getSystemResourceAsStream(jsonResource);
            if(input != null) {
//                this.initializeFromJson(this.readJsonFromInputStream(input));
                return true;
            }
        return false;
    }

//    boolean initializeFromJson(String json) {
//        try {
//            ObjectMapper ex = new ObjectMapper();
//            JsonNode jsonNode = ex.readTree(json);
//            this.userNameToUser = new HashMap();
//            Map roleMap = this.readRoles(jsonNode);
//            this.readUsers(this.userNameToUser, jsonNode, roleMap);
//            return true;
//        } catch (IOException var5) {
//            return false;
//        }
//    }

    /**
     * Authorize the ResourcePermission for a given Principal
     */
    @Override
    public boolean authorize(Object principal, ResourcePermission permission) {
        return false;
    }

    @Override
    public void close() {

    }
}
