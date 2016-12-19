package com.erp.chart.dataset;

import com.erp.chart.bean.BaseBean;
import com.erp.chart.service.ChartDatasetService;
import org.jfree.data.general.Dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by wang_ on 2016-08-13.
 */
@Component
public class BaseDataSet implements Serializable {
    private BaseBean baseBean;
    private String chart_lx;
    private String module_lx;

    @Autowired
    private ChartDatasetService chartDatasetService;

    public Dataset createDataSet() {
        return chartDatasetService.getDataset(baseBean.getWlbm(), chart_lx, module_lx);
    }

    public BaseBean getBaseBean() {
        return baseBean;
    }

    public void setBaseBean(BaseBean baseBean) {
        this.baseBean = baseBean;
    }

    public String getChart_lx() {
        return chart_lx;
    }

    public void setChart_lx(String chart_lx) {
        this.chart_lx = chart_lx;
    }

    public String getModule_lx() {
        return module_lx;
    }

    public void setModule_lx(String module_lx) {
        this.module_lx = module_lx;
    }
}
