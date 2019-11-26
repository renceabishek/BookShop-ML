package com.book.bookShop.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ResponseHeaderFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    /*HttpServletResponse httpServletResponse=(HttpServletResponse) response;
    httpServletResponse.setHeader("Access-Control-Allow-Origin","http://localhost:4200");*/
    chain.doFilter(request,response);
  }

  @Override
  public void destroy() {

  }
}
