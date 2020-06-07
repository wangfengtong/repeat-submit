package com.wft.controller;

import com.wft.constant.ResponseCode;
import com.wft.constant.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 错误相关控制类. <br>
 * <p>
 * Copyright: Copyright (c) 2017/11/17 17:34
 * <p>
 * Company: 南京泰立瑞信息科技有限公司
 * <p>
 *
 * @author ftwang@terrydr.com
 * @version 1.0.0
 */
@RestController
@RequestMapping(value = "/error")
public class ErrorController {
    private static Logger logger = LoggerFactory.getLogger(ErrorController.class);


    @RequestMapping(value = "/{errorType}")
    public ResponseObject error(@PathVariable int errorType) {
        logger.info("errorType = " + errorType);
        ResponseObject ro = new ResponseObject();
        switch (errorType) {
            case 10009:
                ro.setCodeAndMsg(ResponseCode.LOGIN_TIMEOUT);
                break;
            case 10014:
                ro.setCodeAndMsg(ResponseCode.LOGIN_IN_OTHER_PLACES);
                break;
            default:
                ro.setCodeAndMsg(ResponseCode.NO_AUTH);
        }
        return ro;
    }
}
