package com.erp.servlet;

import com.erp.entity.Project;
import com.erp.entity.StaffInfo;
import com.erp.service.LoginService;
import com.erp.service.ProjectService;
import com.erp.util.SystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wang_ on 2016-06-28.
 */
@Controller("loginServlet")
@Scope("prototype")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ProjectService projectService;

    public LoginServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String param = request.getParameter("param");
        if (param == null) {
            throw new IllegalArgumentException("the request parameter param is null, please check your request path is correct.");
        }


        if ("login".equals(param)) {
            String staffCode = request.getParameter("username");
            String pwd = request.getParameter("password");

            try {
                StaffInfo staffInfo = loginService.queryStaffByCode("", staffCode);
                Project project = projectService.initProject(SystemConfig.getValue("project.id"));
                if (staffInfo != null && pwd.equals(staffInfo.getPassword())) {
                    loginService.updateStaffByCode(staffCode);
                    request.getSession().setAttribute("staffinfo", staffInfo);
                    request.getSession().setAttribute("project", project);
                    response.sendRedirect(request.getServletContext().getContextPath()+"/index.jsp");
                } else {
                    request.setAttribute("msg", "<span style='color:red'>�û������������</span>");
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            } catch (Exception e) {
                request.setAttribute("msg", "<span style='color:red'>" + e.getMessage() + "</span>");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                e.printStackTrace();
            }
        } else if ("loginout".equals(param)) {
            HttpSession session = request.getSession();
            session.removeAttribute("staffinfo");
            session.invalidate();
            response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");
        }

    }

}
