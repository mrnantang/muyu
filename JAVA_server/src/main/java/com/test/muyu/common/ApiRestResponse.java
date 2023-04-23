package com.test.muyu.common;

import com.test.muyu.exception.MallExceptionEnum;

/**
 * api统一响应返回类
 * @param <T>
 */
public class ApiRestResponse<T> {

    private Integer code;
    private String msg;
    private T data;

    private static final int OK_Cood = 10000;
    private static final String OK_Msg = "SUCCESS";

    public ApiRestResponse() {
        this(OK_Cood,OK_Msg);
    }

    public ApiRestResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ApiRestResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> ApiRestResponse<T> success(){
        return new ApiRestResponse<>();
    }

    public static <T> ApiRestResponse<T> success(T data){
        ApiRestResponse<T> response = new ApiRestResponse<T>(OK_Cood,OK_Msg);
        response.setData(data);
        return response;
    }

    public static <T> ApiRestResponse<T> error(MallExceptionEnum ex){
        return new ApiRestResponse<T>(ex.getCode(),ex.getMsg());
    }

    public static <T> ApiRestResponse<T> error(Integer code,String msg){
        return new ApiRestResponse<T>(code,msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ApiRestResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
