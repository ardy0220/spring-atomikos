package com.erp.service;

import com.erp.mybatis.mapper.IProjectDao;
import com.erp.entity.Project;
import com.erp.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wang_ on 2016-07-15.
 */
@Service
public class ProjectService {
    private static Logger logger = Logger.getLogger(ProjectService.class);

    @Autowired
    private IProjectDao projectDao;

    /**
     * 初始化Project
     * @return
     * @throws ServiceException
     */
    public List<Project> initProjects() throws ServiceException{
        List<Project> projects = null;
        try {
            projects = projectDao.queryProjects(null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取项目工程失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return projects;
    }

    /**
     * 初始化Project
     *
     * @param projectId
     * @return
     * @throws ServiceException
     */
    public Project initProject(String projectId) throws ServiceException{
        Project project = null;
        try {
            List<Project> projects = projectDao.queryProjects(projectId);
            if (projects != null && projects.size() > 0) {
                project = projects.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取某一项目工程失败：" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return project;
    }

}
