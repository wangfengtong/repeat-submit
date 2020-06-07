package com.wft.service;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    /**
     * 创建token
     * @return token
     */
    String createToken();

    /**
     * 校验token
     * @param request
     * @return 校验成功返回true，失败返回false
     * @throws Exception
     */
    boolean checkToken(HttpServletRequest request) throws Exception;
}
