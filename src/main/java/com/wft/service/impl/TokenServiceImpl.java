package com.wft.service.impl;

import com.wft.constant.Constant;
import com.wft.service.RedisService;
import com.wft.service.TokenService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    private RedisService redisService;

    private final long EXPIRE_TIME = 10000L;

    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString();
        redisService.setEx(Constant.Redis.TOKEN_PREFIX + str, str, EXPIRE_TIME);
        return str;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader(Constant.RequestHeadsName.TOKEN);
        if(StringUtils.isEmpty(token)){
            token = request.getParameter(Constant.RequestHeadsName.TOKEN);
            if(StringUtils.isEmpty(token)){
                throw new Exception("paramenter token not exist.");
            }
        }

        String key = Constant.Redis.TOKEN_PREFIX + token;
        if (!redisService.exists(key)){
            throw new Exception("token not exist.");
        }
        boolean remove = redisService.remove(key);
        if(!remove){
            throw new Exception("delete token failed.");
        }
        return true;
    }
}
