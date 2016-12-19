package com.erp.spring.servlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wang_ on 2016-11-14.
 */
public class ServletToBeanProxy extends GenericServlet {

    // ��ǰ�ͻ��������Servlet����
    private String targetBean;
    // ����Servlet
    private Servlet proxy;

    @Override
    public void init() throws ServletException {
        super.init();
        // ��ʼ��Spring����
//        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        ServletContext servletContext = getServletContext();
        WebApplicationContext wac = (WebApplicationContext) servletContext.getAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.springmvc");
        // ��ȡServlet��
        this.targetBean = getServletName();
        // ����ServletBean
        this.proxy = (Servlet) wac.getBean(targetBean);
        // ���ó�ʼ��������ServletConfig����Bean
        proxy.init(getServletConfig());
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // ��service�����е���bean��service������servlet����ݿͻ�������ȥ������Ӧ�����󷽷�(Get/Post)
        proxy.service(request, response);
    }
}
