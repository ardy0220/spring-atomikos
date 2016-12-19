package com.erp.chart.service;

import com.erp.chart.dao.IChartDao;
import com.erp.chart.povo.DatasetVO;
import com.erp.util.StringUtil;
import org.apache.log4j.Logger;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by wang_ on 2016-06-30.
 */
@Service
public class ChartDatasetService {
    private static final Logger logger = Logger.getLogger(ChartDatasetService.class);

    @Autowired
    private IChartDao chartDao;

    /**
     *
     * @param wlbm
     * @param chart_lx
     * @param module_lx
     * @return
     */
    public Dataset getDataset(String wlbm, String chart_lx, String module_lx) {
        Dataset dataset = null;
        if ("pie".equalsIgnoreCase(chart_lx)) {
            if ("chart".equalsIgnoreCase(module_lx)) {
                dataset = getWlPieDataset(wlbm);
            } else {
                dataset = getYjPieDataset();
            }
        } else {
            if ("chart".equalsIgnoreCase(module_lx)) {
                dataset = getWlCategoryDataset(wlbm);
            } else {
                dataset = getYjCategoryDataset();
            }
        }

        return dataset;
    }

    /**
     * @param wlbm
     * @return
     */
    public DefaultCategoryDataset getWlCategoryDataset(String wlbm) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            List<DatasetVO> datasetVOList = chartDao.getWlCategoryDataset(wlbm);
            Iterator<DatasetVO> iterator = datasetVOList.iterator();
            while (iterator.hasNext()) {
                DatasetVO datasetVO = iterator.next();
                dataset.addValue(datasetVO.getPrice(), datasetVO.getWlmc(), datasetVO.getShopping_time());
            }
        } catch (Exception e) {
            logger.error("获取数据失败：" + e.getMessage(), e);
            e.printStackTrace();
        }

        return dataset;
    }

    /**
     * @param wlbm
     * @return
     */
    public DefaultPieDataset getWlPieDataset(String wlbm) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        if (StringUtil.isEmpty(wlbm)) return dataset;
        try {
            List<DatasetVO> datasetVOList = chartDao.getWlPieDataset(wlbm);
            Iterator<DatasetVO> iterator = datasetVOList.iterator();
            while (iterator.hasNext()) {
                DatasetVO datasetVO = iterator.next();
                dataset.setValue(datasetVO.getShopping_time(), datasetVO.getPrice());
            }
        } catch (Exception e) {
            logger.error("获取饼状数据失败：" + e.getMessage(), e);
            e.printStackTrace();
        }

        return dataset;
    }

    /**
     *
     * @return
     */
    public DefaultCategoryDataset getYjCategoryDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            List<DatasetVO> datasetVOList = chartDao.getYjCategoryDataset();
            Iterator<DatasetVO> iterator = datasetVOList.iterator();
            while (iterator.hasNext()) {
                DatasetVO datasetVO = iterator.next();
                dataset.addValue(datasetVO.getYjye(), "月度结算", datasetVO.getYjyf());
            }
        } catch (Exception e) {
            logger.error("获取数据失败：" + e.getMessage(), e);
            e.printStackTrace();
        }

        return dataset;
    }

    /**
     *
     * @return
     */
    public DefaultPieDataset getYjPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        try {
            List<DatasetVO> datasetVOList = chartDao.getYjCategoryDataset();
            Iterator<DatasetVO> iterator = datasetVOList.iterator();
            while (iterator.hasNext()) {
                DatasetVO datasetVO = iterator.next();
                dataset.setValue(datasetVO.getYjyf(), datasetVO.getYjye());
            }
        } catch (Exception e) {
            logger.error("获取饼状数据失败：" + e.getMessage(), e);
            e.printStackTrace();
        }

        return dataset;
    }

}
