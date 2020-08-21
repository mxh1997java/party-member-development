package cn.sus.edu.partymemberdevelopment.configuration.Interceptor;

import cn.sus.edu.partymemberdevelopment.configuration.annotation.LoginRequired;
import cn.sus.edu.partymemberdevelopment.util.AssertUtils;
import cn.sus.edu.partymemberdevelopment.util.EmptyUtils;
import cn.sus.edu.partymemberdevelopment.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 这里会出现redisUtils为null的情况，
     * 因为拦截器加载于IOC之前，所以这个时候注入RedisTemplate时是null
     */
    @Resource
    private RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否为ResourceHttpRequestHandler
        if(!(handler instanceof HandlerMethod)) {
            logger.warn("HandlerMethod=" + handler.getClass().getName() + ",request=" + request.getQueryString());
            return true;
        }

        //获取请求上的登陆注解
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        LoginRequired annotation = handlerMethod.getMethod().getAnnotation(LoginRequired.class);
        if(null != annotation) {
            //判断注解里的默认值
            boolean required = annotation.loginRequired();
            if(!required) {
                logger.info("调用路径: {} 不需要登陆", request.getRequestURI());
                return true;
            }
        }

        AssertUtils.assertTrue(EmptyUtils.isEmpty(request.getHeader("token")), "token不存在!");
        String token = request.getHeader("token");
        Object userInfo = redisUtils.get(token);
        if(EmptyUtils.isEmpty(userInfo)) {
            logger.info("登录信息不存在!请重新登录!");
            //return false;
            throw new RuntimeException("登录信息不存在!请重新登录!");
        } else {
            //每次请求通过验证，延长token过期时间
            redisUtils.expire(token, 3600);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
