package com.erp.servlet;

import com.erp.bean.ResponseBean;
import com.erp.entity.YW;
import com.erp.enums.TextEnum;
import com.erp.exception.ServiceException;
import com.erp.service.ReportService;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_ on 2016-06-30.
 */
@Controller("reportServlet")
@Scope("prototype")
public class ReportServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Autowired
    private ReportService reportService;

    public ReportServlet() {
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
        String seq = request.getParameter("seq");
        String random_session = (String) request.getSession().getAttribute("random_session");

//        if (random_session == null || seq == null || !seq.equals(random_session)) {
//            throw new IllegalArgumentException("the request is illegal.");
//        }

        String responseText = "";
        if ("query".equals(param)) {
            responseText = queryReportData();
        } else if ("add".equals(param)
                || "delete".equals(param)) {
            responseText = addOrDeleteReportData(param, request);
        }

        PrintWriter pw = response.getWriter();
        pw.write(responseText);
        pw.close();

    }

    /**
     * 查询
     *
     * @return
     */
    private String queryReportData() {
        JSONArray reportArray = null;
        try {
            reportArray = reportService.queryReportDatas(null);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

        ResponseBean responseBean = new ResponseBean(reportArray);
        return responseBean.getResponseArray(true);
    }

    /**
     * @param param
     * @param request
     * @return
     */
    private String addOrDeleteReportData(String param, HttpServletRequest request) {
        boolean success = false;
        String msg = "";
        try {
            if ("add".equals(param)) {
                String[] dbid = request.getParameterValues("dbid"); // dbid
                String[] wlbm = request.getParameterValues("wlbm"); // 物料编码
                String[] gysbm = request.getParameterValues("gysbm"); // 供应商编码
                String[] price = request.getParameterValues("price"); // 单价
                String[] number = request.getParameterValues("number"); // 数量
                String[] shoppingTime = request.getParameterValues("shoppingtime"); // 购买时间
                String staffId = request.getParameter("staffId"); // 填报人
                List<YW> insertList = new ArrayList<>();
                List<YW> updateList = new ArrayList<>();

                for (int i = 0; i < wlbm.length; i++) {
                    YW yw = new YW();
                    yw.setWlbm(wlbm[i]);
                    yw.setGysbm(gysbm[i]);
                    yw.setPrice(StringUtil.procDouble(price[i]));
                    yw.setNumber(StringUtil.getIntValue(number[i]));
                    yw.setShoppingTime(StringUtil.getDateValue(shoppingTime[i]));
                    yw.setStaffId(StringUtil.getIntValue(staffId));
                    if (!"".equals(dbid[i])) {
                        yw.setDbid(Integer.valueOf(dbid[i]));
                        updateList.add(yw);
                    } else {
                        insertList.add(yw);
                    }

                }

                reportService.insertOrUpdateReportData(insertList, updateList);
            } else if ("delete".equals(param)) {
                String[] dbid = request.getParameterValues("dbid"); // dbid
                reportService.deleteReportData(dbid);
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
