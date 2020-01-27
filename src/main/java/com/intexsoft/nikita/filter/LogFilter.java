package com.intexsoft.nikita.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

public class LogFilter implements Filter {

    public void destroy() {
        System.out.println("Log filter destroy!");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;

        String servletPath = req.getServletPath();

        System.out.println("#INFO " + new Date() + " - ServletPath :" + servletPath
                + ", URL = " + req.getRequestURL());
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
