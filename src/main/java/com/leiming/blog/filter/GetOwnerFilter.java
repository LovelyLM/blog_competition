package com.leiming.blog.filter;

import com.leiming.blog.domain.User;
import com.leiming.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Component
@WebFilter(urlPatterns = "/*",filterName = "ownerFilter")
public class GetOwnerFilter implements Filter {
    @Autowired
    private UserService userService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        User owner = userService.getOwner();
        servletRequest.setAttribute("owner",owner);
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
