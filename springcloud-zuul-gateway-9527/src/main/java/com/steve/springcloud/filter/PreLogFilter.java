package com.steve.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: STEVE
 * @Description: Zuul过滤器 - pre类型
 * @since: 2024/1/4
 */
@Component
public class PreLogFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        System.out.println("=====> Remote host:{" + host + "},method:{" + method + "},uri:{" + uri + "}");
        System.out.println("********" + System.currentTimeMillis());
        return null;
    }

}
