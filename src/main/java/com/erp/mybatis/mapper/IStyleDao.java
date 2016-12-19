package com.erp.mybatis.mapper;

import com.erp.entity.Style;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang_ on 2016-08-18.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IStyleDao {

    /**
     * ��ȡ��ʽ�б�
     * @return
     * @throws Exception
     */
    public List<Style> queryStyleList();

    /**
     * ������ʽ
     * @param style
     * @throws Exception
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void updateStyle(Style style);
}
