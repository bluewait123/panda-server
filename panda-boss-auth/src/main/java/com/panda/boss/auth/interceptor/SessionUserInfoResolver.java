package com.panda.boss.auth.interceptor;

import com.panda.boss.auth.annotation.SessionUser;
import com.panda.boss.auth.enums.AuthErrorEnum;
import com.panda.boss.auth.enums.AuthKeyEnum;
import com.panda.boss.auth.exception.AuthException;
import com.panda.boss.auth.vo.SessionUserInfo;
import com.panda.common.redis.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 给controller层中添加@SessionUser SessionUserInfo 注解的对象封装数据
 * @author wujianhui
 * @date 2020-03-05
 */
@Component
public class SessionUserInfoResolver implements HandlerMethodArgumentResolver {
    /**
     * 获取缓存接口实现
     */
    @Autowired
    private RedisService redisService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 如果参数类型是CurrentUser并且有CurrentSession注解则支持
        return parameter.getParameterType().isAssignableFrom(SessionUserInfo.class)
                && parameter.hasParameterAnnotation(SessionUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        // 取出鉴权时存入的登录用户Id
        String sessionKey = (String) webRequest.getAttribute(AuthKeyEnum.USER_INFO.getCode(), RequestAttributes.SCOPE_REQUEST);
        if (StringUtils.isNotEmpty(sessionKey)) {
            // 从缓存中查询并返回
            SessionUserInfo session = redisService.getObject(sessionKey, SessionUserInfo.class);
            if (session != null) {
                return session;
            }
        }
        throw new AuthException(AuthErrorEnum.USER_INFO_NOT_EXIST);
    }
}
