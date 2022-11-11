package com.test.muyu.exception;

/**
 * 异常枚举类
 */
public enum MallExceptionEnum {
    NEED_USER_NAME(10001,"用户名不能为空")
    ,NEED_PASSWORD(10002,"密码不能为空")
    ,PASSWORD_TO_SHORT(10003,"密码长度不能小于8位")
    ,NAME_EXISTED(10004,"用户名重复,注册失败")
    ,INSERT_FAILED(10005,"注册失败")
    ,WRONG_PASSWORD(10006,"账号或密码错误")
    ,NEED_LOGIN(10007,"当前未登录")
    ,UPDATE_FAILED(10008,"更新失败")
    ,NEED_ADMIN(10009,"无管理员权限")
    ,ARGS_NOT_NULL(10010,"参数不能为空")
    ,CATEGORY_EXISTED(10011,"目录以存在")
    ,ADD_FAILED(10012,"添加失败")
    ,REQUEST_PARAM_ERROR(10013,"参数错误")
    ,NAME_REPETITION(10014,"名字重复")
    ,SUBMIT_FAILED(10015,"提交数据失败")

    ,SYSTEM_ERROR(20000,"系统异常")
    ;

    MallExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
