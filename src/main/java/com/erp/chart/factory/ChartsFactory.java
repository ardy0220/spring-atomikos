package com.erp.chart.factory;

import com.erp.chart.BaseChart;
import com.erp.chart.bean.BaseBean;
import com.erp.chart.bean.ChartBean;
import com.erp.chart.dataset.BaseDataSet;
import com.erp.chart.enums.ChartEnum;
import com.erp.chart.util.ChartsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by wang_ on 2016-06-29.
 */
@Component
public class ChartsFactory {

    @Autowired
    private ChartBeanFactory chartBeanFactory;

    @Autowired
    private BaseDataSet baseDataSet;

    public String createChart(HttpSession session, String chart_lx,
                                     String module_lx, String wlbm, int w, int h) {

        ChartsUtil chartsUtil = new ChartsUtil();

        ChartEnum chartEnum = ChartEnum.getEnumByName(chart_lx);
        BaseChart baseChart = chartEnum.getBaseChart();

        StringBuffer key = new StringBuffer();
        key.append(module_lx).append("_").append(chart_lx);

        BaseBean baseBean = new BaseBean();
        baseBean.setWlbm(wlbm);
        baseDataSet.setBaseBean(baseBean);
        baseDataSet.setChart_lx(chart_lx);
        baseDataSet.setModule_lx(module_lx);

        ChartBean chartBean = chartBeanFactory.getChartBean(key.toString());
        chartBean.setDataset(baseDataSet.createDataSet());
        baseChart.setChartBean(chartBean);

        return chartsUtil.parseChart(baseChart, session, w, h);
    }

}
