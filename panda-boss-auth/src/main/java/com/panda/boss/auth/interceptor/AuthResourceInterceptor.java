package com.panda.boss.auth.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.panda.boss.auth.constant.AuthRedisKey;
import com.panda.boss.auth.enums.AuthErrorEnum;
import com.panda.boss.auth.enums.AuthKeyEnum;
import com.panda.boss.auth.exception.AuthException;
import com.panda.boss.auth.utils.AuthIgnoreResources;
import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.common.enums.BossErrorEnum;
import com.panda.common.exception.BossException;
import com.panda.common.redis.service.RedisService;
import com.panda.common.utils.ResponseUtils;
import com.panda.common.vo.BossResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户拦截器， 检查是否有权限登录
 * @author wujianhui
 * @date 2020-03-05
 */
@Slf4j
public class AuthResourceInterceptor implements HandlerInterceptor {

    @Value("${system.type:common}")
    private String systemType;

    @Autowired
    private RedisService redisService;

    @Autowired
    private AuthIgnoreResources authIgnoreResources;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o){
        String url = null;
        try {
            String contextPath = request.getContextPath();
            String requestUri = request.getRequestURI();
            url = requestUri.substring(contextPath.length());

            // 检查白名单
            List<String> urls = getIgnoreInfo(authIgnoreResources.getUrl());
            if(urls.contains(url)){
                log.info("资源认证完成,URL:[{}],认证结果:[白名单通过]",url);
                return true;
            }

            // 会话检查
            String token = request.getHeader(AuthKeyEnum.TOKEN.getCode());
            if (StringUtils.isBlank(token)) {
                token = request.getParameter(AuthKeyEnum.TOKEN.getCode());
            }

            if (StringUtils.isBlank(token)) {
                throw new AuthException(AuthErrorEnum.TOKEN_NOT_EXIST);
            }

            String key = AuthRedisKey.getSessionUserInfoKey(token);
            SessionUserInfo sessionUserInfo = redisService.getObject(key, SessionUserInfo.class);
            if(null == sessionUserInfo){
                throw new AuthException(AuthErrorEnum.USER_INFO_NOT_EXIST);
            }

            // 检查资源白名单
            List<String> resource = getIgnoreInfo(authIgnoreResources.getResource());
            if(!resource.contains(url)){
                // 资源鉴权
                String resourceKey = AuthRedisKey.getUserAuthResourceKey(sessionUserInfo.getId());
                resource = redisService.getList(resourceKey,String.class);
                if(null == resource || !resource.contains(url)){
                    log.debug("resource:{}",JSONObject.toJSONString(resource));
                    throw new AuthException(AuthErrorEnum.AUTH_RESOURCE_NOT_EXIST);
                }
            }

            // 更新用户信息有效期 默认300秒
            String redisAuthTimeOut = redisService.get(AuthRedisKey.getUserAuthTimeOutKey(sessionUserInfo.getId()));
            Integer authTimeOut = StringUtils.isBlank(redisAuthTimeOut) ? 300 : Integer.valueOf(redisAuthTimeOut);
            redisService.putObject(key,sessionUserInfo,authTimeOut);

            // 如果token验证成功，将token对应的用户id存在request中，便于之后CurrentUser对象注入
            request.setAttribute(AuthKeyEnum.USER_INFO.getCode(), key);
            request.setAttribute(AuthKeyEnum.USER_ID.getCode(), sessionUserInfo.getId());
            log.info("资源认证完成,URL:[{}],认证结果:[认证通过]",url);
        } catch (Exception e) {
            BossResp res = error(response, e, url);
            log.info("资源认证完成,URL:[{}],认证结果:[{}]",url,res.getMsg());
            ResponseUtils.renderJson(response, JSONObject.toJSONString(res));
            return false;
        }
        return true;
    }

    private List<String> getIgnoreInfo(List<String> ignoreInfo){
        if(null == ignoreInfo){
            return new ArrayList<>();
        }

        if(ignoreInfo.size() == 0){
            return ignoreInfo;
        }

        List<String> result = new ArrayList<>();
        for(String s : ignoreInfo){
            String[] arr = s.split(",");
            result.addAll(Arrays.asList(arr));
        }
        return result;
    }

    private BossResp error(HttpServletResponse response, Exception e, String url) {
        log.error(e.getMessage(), e);
        BossResp res = new BossResp();
        res.setSystem(systemType);
        if(e instanceof AuthException){
            AuthException auth = (AuthException)e;
            res.setCode(auth.getRespCode());
            res.setMsg(auth.getRespDesc());
            printSourceException(auth);
        }else if(e instanceof BossException){
            BossException be = (BossException)e;
            res.setCode(be.getRespCode());
            res.setMsg(be.getRespDesc());
            printSourceException(be);
        }else {
            res.setCode(BossErrorEnum.FAIL.getCode());
            res.setMsg(BossErrorEnum.FAIL.getDesc());
        }
        return res;
    }

    private void printSourceException(BossException e){
        if(null != e.getSource()){
            log.error(e.getSource().getMessage(),e.getSource());
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
