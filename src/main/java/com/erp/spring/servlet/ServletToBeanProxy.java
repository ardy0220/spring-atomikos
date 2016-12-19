package com.erp.spring.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wang_ on 2016-11-14.
 */
public class ServletToBeanProxy extends GenericServlet {

    // 当前客户端请求的Servlet名字
    private String targetBean;
    // 代理Servlet
    private Servlet proxy;

    @Override
    public void init() throws ServletException {
        super.init();
        // 初始化Spring容器
//        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        ServletContext servletContext = getServletContext();
        WebApplicationContext wac = (WebApplicationContext) servletContext.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springmvc");
        // 获取Servlet名
        this.targetBean = getServletName();
        // 调用ServletBean
        this.proxy = (Servlet) wac.getBean(targetBean);
        // 调用初始化方法将ServletConfig传给Bean
        proxy.init(getServletConfig());
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // 在service方法中调用bean的service方法，servlet会根据客户的请求去调用相应的请求方法(Get/Post)
        proxy.service(request, response);
    }
}
