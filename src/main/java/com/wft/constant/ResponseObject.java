package com.wft.constant;

import java.io.Serializable;
import java.util.Objects;

/**
 * 向移动端返回的Json模板. <br>
 * <p>
 * Copyright: Copyright (c) 2017/11/17 17:02
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 *
 * @author ftwang@terrydr.com
 * @version 1.0.0
 */
public class ResponseObject<T> implements Serializable {

    /**
     * 执行Action返回的状态码
     */
    private Integer responseCode = -1;
    /**
     * 执行Action返回的数据对象
     */
    private T returnObject;
    /**
     * 执行Action返回的数据对象
     */
    private String returnMsg = "客户端请求无效";

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public T getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(T returnObject) {
        this.returnObject = returnObject;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }


    public void setSuccessContent(T content) {
        setSuccess();
        this.returnObject = content;
    }

    public void setSuccess() {
        setCodeAndMsg(ResponseCode.SUCCESS);
    }

    public void setCodeAndMsg(ResponseCode responseCode) {
        this.responseCode = responseCode.getCode();
        this.returnMsg = responseCode.getMessage();
    }

    public boolean checkSuccess() {
        if (Objects.equals(this.getResponseCode(), ResponseCode.SUCCESS.getCode())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "{\"responseCode\":" + responseCode + "," +
                "\"returnObject\":\"" + returnObject + "\"," +
                "\"returnMsg\":\"" + returnMsg + "\"}";
    }
}
