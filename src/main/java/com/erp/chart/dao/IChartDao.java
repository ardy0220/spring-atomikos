package com.erp.chart.dao;

import com.erp.chart.povo.DatasetVO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * IChartDao
 *
 * @author wang_
 * @date 2016-11-24
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IChartDao {

    /**
     *
     * @param wlbm
     * @return
     */
    public List<DatasetVO> getWlCategoryDataset(String wlbm);

    /**
     *
     * @param wlbm
     * @return
     */
    public List<DatasetVO> getWlPieDataset(String wlbm);

    /**
     *
     * @return
     */
    public List<DatasetVO> getYjCategoryDataset();
}
