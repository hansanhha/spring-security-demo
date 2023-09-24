package study.security.this_will_protect_you.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var httpRequest = (HttpServletRequest) request;

        var requestId = httpRequest.getHeader("Request-Id");

        logger.info("Successfully authenticated request with id " + requestId);

        filterChain.doFilter(request, response);
    }



}
