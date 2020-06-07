package com.wft.constant;

/**
 * 错误码及对应消息
 * HttpServletResponse的status（状态码），
 * Success/0表示Action执行成功，[其他]表示Action执行失败。. <br>
 * <p>
 * Copyright: Copyright (c) 2017/11/17 17:02
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 *
 * @author ftwang@terrydr.com
 * @version 1.0.0
 */
public enum ResponseCode {
    /**
     * 通用模块
     */
    SUCCESS(0, "成功"),
    INVALID_REQUEST(1, "客户端请求无效"),
    INVALID_PARAM(2, "参数违规"),

    NO_AUTH(8, "当前无权限进行此操作"),

    OPERATION_FAILURE(9, "操作失败"),
    SELECT_FAILURE(10, "查询失败"),
    ADD_FAILURE(11, "添加失败"),
    UPDATE_FAILURE(12, "更新失败"),
    DELETE_FAILURE(13, "删除失败"),

    STATUS_FREEZED(14, "抱歉！你的账户被禁用一个月！请一个月后再尝试操作"),
    STATUS_DROPED(15, "抱歉！你的账户已被注销"),
    UNSPECIFY_CLIENT_TYPE(16, "未指定客户端类型"),
    UNSPECIFY_USER_TYPE(17, "未指定用户类型"),
    UNSPECIFY_PARAMETER(18, "未指定参数"),
    WRONG_PARAM_FORMAT(19, "参数格式不对"),

    UNSPECIFY_TELE_NO(10000, "手机号为空"),
    INVALID_TELENO(10001, "手机号格式不对"),
    TELENO_NO_REGISTER(10002, "手机号未注册"),
    UNSPECIFY_NAME(10003, "姓名为空"),
    UNSPECIFY_PASSWD(10004, "密码为空"),
    PASSWORD_ERROR(10005, "密码错误"),
    LOGIN_FAILURE_TELENO_PASSWORD(10006, "身份认证错误"),
    RESET_PASSWD_FAILURE(10007, "重置密码失败"),
    LOGIN_FAILURE(10008, "登录失败"),
    LOGIN_TIMEOUT(10009, "登录失效"),
    LOGIN_OUT_FAILURE(10010, "登出失效"),
    UNSPECIFY_IDCARD(10011, "未指定身份证号"),
    IDCARD_NO_EXIST(10012, "身份证号不合法"),
    OLD_PASSWORD_ERROR(10013, "原始密码不正确"),
    LOGIN_IN_OTHER_PLACES(10014, "您的账号已在其他设备上登录"),
    REGIST_FAILURE(10015, "注册失败"),
    TELENO_ALREADY_REGISTED(10016, "手机号码已被注册"),
    UNSPECIFY_SEX(10017, "性别为空"),
    UNSPECIFY_BIRTHDAY(10018, "生日为空"),
    UNSPECIFY_KEYWORD(10019, "未指定关键字"),
    UNSPECIFY_MENU(10020, "未指定角色权限"),
    MINIPROGRAM_USER_NO_EXIST(10021, "小程序第一次登录"),
    MINIPROGRAM_LOGIN_FAILURE(100221, "小程序登录失败"),
    UNSPECIFY_OPENID(10023, "OpenId为空"),
    UNSPECIFY_ID(10024, "Id为空"),

    /**
     * 验证码模块
     */
    SEND_CODE_FAILURE(20000, "验证码发送失败"),
    UNSPECIFY_VERIFICATION_CODE(20001, "验证码为空"),
    VERIFICATION_CODE_TIMEOUT(20002, "验证码超时"),
    VERIFICATION_CODE_ERROR(20003, "验证码错误"),

    /**
     * 用户模块
     */
    SPECIFY_USER_NO_EXIST(30000, "指定的用户不存在"),
    UNSPECIFY_USER(30001, "用户对象为空"),
    UNSPECIFY_USER_ID(30002, "用户ID为空");


    private Integer code;
    private String message;

    ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
