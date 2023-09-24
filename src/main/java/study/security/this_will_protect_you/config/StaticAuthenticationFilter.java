package study.security.this_will_protect_you.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class StaticAuthenticationFilter implements Filter {


    public StaticAuthenticationFilter() {
    }

//    @Value("${authorization.key}")
//    private String authorizationKey;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authorization = httpRequest.getHeader("Authorization");

//        if (authorization.equals(authorizationKey)) {
//            chain.doFilter(request, response);
//        } else {
//            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        }
    }

}
