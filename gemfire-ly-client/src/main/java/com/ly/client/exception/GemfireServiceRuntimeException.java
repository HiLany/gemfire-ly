package com.ly.client.exception;

/**
 * Custom Exception for GemfireServiceRuntime
 * Created by lany on 2019/6/25.
 */
public class GemfireServiceRuntimeException extends RuntimeException {

    private String retCd ;  //异常对应的返回码
    private String funId;  //异常对应的描述信息

    public GemfireServiceRuntimeException() {
        super();
    }

    public GemfireServiceRuntimeException(String message){
        super(message);
        this.funId = message;
    }

    public GemfireServiceRuntimeException(String retCd,String funId) {
        super();
        this.retCd = retCd;
        this.funId = funId;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getFunId() {
        return funId;
    }
}
