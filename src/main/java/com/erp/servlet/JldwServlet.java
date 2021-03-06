package com.erp.servlet;

import com.erp.bean.ResponseBean;
import com.erp.entity.Jldw;
import com.erp.enums.TextEnum;
import com.erp.exception.ServiceException;
import com.erp.service.JldwService;
import com.erp.util.StringUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wang_ on 2016-09-02.
 */
@Controller("jldwServlet")
@Scope("prototype")
public class JldwServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private JldwService jldwService;

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

        String seq = request.getParameter("seq");
        String random_session = (String) request.getSession().getAttribute("random_session");

//        if (!"query-combo".equals(param) && (random_session == null || seq == null || !seq.equals(random_session))) {
//            throw new IllegalArgumentException("the request is illegal.");
//        }
        String reponseText = "";
        if ("query".equals(param)) {
            reponseText = queryJldw(true);
        } else if ("delete".equals(param) || "add".equals(param)) {
            reponseText = editJldw(request, param);
        } else if ("valid".equals(param)) {
            reponseText = isValid(request);
        } else if ("query-combo".equals(param)) {
            reponseText = queryJldw(false);
        }

        PrintWriter writer = response.getWriter();
        writer.write(reponseText);
        writer.close();

    }

    /**
     *
     * @param flag
     * @return
     */
    private String queryJldw(boolean flag) {
        JSONArray array = null;
        try {
            array = jldwService.queryJldw();
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        ResponseBean responseBean = new ResponseBean(array);
        return responseBean.getResponseArray(flag);
    }

    /**
     * @param request
     * @return
     */
    private String isValid(HttpServletRequest request) {
        String jldwmc = request.getParameter("jldwmc");
        String jldwId = request.getParameter("jldwId");
        boolean success = false;
        try {
            Jldw jldw = jldwService.queryJldwByJldwId(jldwmc, jldwId);
            if (jldw == null) {
                success = true;
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        ResponseBean responseBean = new ResponseBean(success, "");
        return responseBean.getResponseBool();
    }

    /**
     * @param request
     * @param param
     * @return
     */
    private String editJldw(HttpServletRequest request, String param) {
        boolean success = false;
        String msg = "";
        try {
            if ("delete".equals(param)) {
                String[] jldwIds = request.getParameterValues("jldwId");
                String staffId = request.getParameter("staffId");
                jldwService.deleteJldw(jldwIds, staffId);
            } else if ("add".equals(param)) {
                Jldw jldw = new Jldw();
                String jldwId = request.getParameter("jldwId");
                String jldwmc = request.getParameter("jldwmc");
                String jldwms = request.getParameter("jldwms");
                String create_by = request.getParameter("create_by");
                String update_by = request.getParameter("update_by");
                jldw.setJldwId(StringUtil.isEmpty(jldwId) ? null : Integer.valueOf(jldwId));
                jldw.setJldwmc(jldwmc);
                jldw.setJldwms(jldwms);
                jldw.setIs_del("0");
                jldw.setCreate_staffId(Integer.valueOf(create_by));
                jldw.setUpdate_staffId(Integer.valueOf(update_by));
                jldwService.insertOrUpdateJldw(jldw);
            }
            success = true;
            msg = TextEnum.getText(param, success);
        } catch (Exception e) {
            msg = TextEnum.getText(param, success) + e.getMessage();
            e.printStackTrace();
        }

        ResponseBean responseBean = new ResponseBean(success, msg);
        return responseBean.getResponseText();
    }

}
