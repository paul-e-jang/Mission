package com.sjwp.mission.config.servlet;

import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

public class HistoryModeFilter extends OncePerRequestFilter {

    private Pattern patt = Pattern.compile("^/([^\\.])*");
    private String endpoint = "/";

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        if(this.patt.matcher(request.getRequestURI()).matches()) {
            RequestDispatcher rd = request.getRequestDispatcher(endpoint);
            rd.forward(request, response);
        } else {
            filterChain.doFilter(request, response);
        }
    }

}
