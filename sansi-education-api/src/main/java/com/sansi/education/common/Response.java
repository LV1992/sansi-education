package com.sansi.education.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yihang.lv 2018/8/22、17:37
 */
@Data
public class Response<T> extends BaseResultDto{

    private boolean success;
    private T result;
    private int errorCode;
    private String errorMsg;

    public Response(boolean success, T result, int errorCode, String errorMsg) {
        this.success = success;
        this.result = result;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private Response(){
        this.success = true;
    }

    public Response(T result){
        this.result = result;
        this.success = true;
    }

    private Response(int errorCode, String errorMsg ,T result){
        this.result = result;
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private Response(int errorCode, String errorMsg){
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    private Response(int errorCode, String errorMsg,String requestIp){
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        super.setRequestIp(requestIp);
    }

    public static Response ok(){
        return new Response();
    }

    public static Response error(int errorCode, String errorMsg){
        return new Response(errorCode, errorMsg);
    }

    public static Response error(int errorCode, String errorMsg,String requestIp){
        return new Response(errorCode, errorMsg , requestIp);
    }

    public static Response error(){
        return new Response(-1, "未知异常");
    }

    public static Response error(String requestIp){
        return new Response(-1, "未知异常", requestIp);
    }

}
