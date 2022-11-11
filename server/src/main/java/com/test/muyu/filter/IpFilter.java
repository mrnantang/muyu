package com.test.muyu.filter;


import redis.clients.jedis.Jedis;

import javax.servlet.*;
import java.io.IOException;
import java.util.Set;

public class IpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String ip = servletRequest.getRemoteAddr();
        Jedis jedis = new Jedis("127.0.0.1",6379);
        try {
            jedis.select(1);
            Set<String> keys = jedis.keys("*");
            if (keys.size()>0){
                for (String item:keys) {
                    if (ip.equals(item)){
                        return;
                    }
                }
            }
            jedis.set(ip,"0");
            jedis.expire(ip,3600);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
