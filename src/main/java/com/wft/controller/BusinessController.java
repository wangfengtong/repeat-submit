package com.wft.controller;

import com.wft.annotation.AutoIdempotent;
import com.wft.constant.ResponseCode;
import com.wft.constant.ResponseObject;
import com.wft.service.TokenService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BusinessController {
    @Resource
    private TokenService tokenService;


    @PostMapping("/get/token")
    public ResponseObject getToken() {
        ResponseObject ro = new ResponseObject();
        String token = tokenService.createToken();
        if (StringUtils.isEmpty(token)) {
            ro.setCodeAndMsg(ResponseCode.SELECT_FAILURE);
            return ro;
        }
        ro.setSuccessContent(token);
        return ro;
    }


    @AutoIdempotent
    @PostMapping("/test/testIdempotence")
    public ResponseObject testIdempotence(String token){
        ResponseObject ro = new ResponseObject();
        return ro;
    }
}
