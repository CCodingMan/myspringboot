package com.ljj.springboot_requestloger.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ljj.springboot_requestloger.dao.LogerJPA;
import com.ljj.springboot_requestloger.entity.LogerEntity;
import com.ljj.springboot_requestloger.util.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: ljj
 * @Date: 2019/6/16 14:01
 * @Description:
 */
public class LogerInterceptor implements HandlerInterceptor {
    private static final String LOGGER_SEND_TIME = "send_time";
    private static final String LOGGER_ENTITY = "logger_entity";
    /**
     * 进入controller之前开始记录日志
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LogerEntity logerEntity = new LogerEntity();
        String sessionId = request.getRequestedSessionId();
        String url = request.getRequestURI();
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        logerEntity.setClientIp(LoggerUtils.getCliectIp(request));
        logerEntity.setMethod(request.getMethod());
        logerEntity.setType(LoggerUtils.getRequestType(request));
        logerEntity.setParamData(paramData);
        logerEntity.setUrl(url);
        logerEntity.setSessionId(sessionId);
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY, logerEntity);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        int status = response.getStatus();
        long currentTime = System.currentTimeMillis();
        long requestStartTime = Long.parseLong(request.getAttribute(LOGGER_SEND_TIME).toString());
        LogerEntity logerEntity = (LogerEntity) request.getAttribute(LOGGER_ENTITY);
        logerEntity.setTimeConsuming(Integer.valueOf((currentTime - requestStartTime) + ""));
        logerEntity.setReturnTime(currentTime + "");
        logerEntity.setHttpStatusCode(status + "");
        logerEntity.setReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        LogerJPA logerJPA = getDAO(LogerJPA.class, request);
        logerJPA.save(logerEntity);

    }

    /**
     * 根据传入的类型获取spring管理的对应dao,拦截器内无法通过SpringBean的方式注入LoggerJPA
     * @param clazz
     * @param request
     * @param <T>
     * @return
     */
    private <T> T getDAO(Class<T> clazz, HttpServletRequest request){
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
