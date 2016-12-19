package com.erp.listener;

import com.erp.entity.YJ;
import com.erp.util.SystemConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by wang_ on 2016-08-04.
 */
@WebListener
public class StartUpListener implements ServletContextListener {

    public StartUpListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        /**
         * 初始化配置文件
         */
        SystemConfig.init();

//        /**
//         * 初始化ChartBean
//         */
//        ChartBeanFactory.init();

        /**
         *
         */
        ServletContext context = servletContextEvent.getServletContext();
        initYJ(context);

    }

    /**
     *
     * @return
     */
    private void initYJ(ServletContext context) {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
        SqlSessionFactory factory = (SqlSessionFactory) wac.getBean("sqlSessionFactory");
        SqlSession session = factory.openSession();
        String initYJ = "0"; // 0为未初始化，1为初始化
        try {
            YJ yj = session.selectOne("Yj.initYJ");
            if (yj != null) {
                initYJ = "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        context.setAttribute("initYJ", initYJ);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
