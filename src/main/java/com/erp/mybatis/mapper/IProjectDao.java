package com.erp.mybatis.mapper;

import com.erp.entity.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wang_ on 2016-07-15.
 */
@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface IProjectDao {

    /**
     *
     * @param projectId
     * @return
     * @throws Exception
     */
    public List<Project> queryProjects(String projectId);
}
