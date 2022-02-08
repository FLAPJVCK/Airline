package by.epamtc.vaskevichartsiom.finalproject.airline.controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "LocaleFilter")
@WebFilter(urlPatterns = {"/*"})
public class LocaleFilter implements Filter {

    public static final String LOCALE = "locale";
    private static final String DEFAULT = "ru";

    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getSession(false) != null && httpRequest.getSession(false).getAttribute(LOCALE) == null) {
            httpRequest.getSession().setAttribute(LOCALE, DEFAULT);
        }
        chain.doFilter(request, response);
    }
}
