package com.erp.util;

import com.erp.mybatis.mapper.IModuleDao;
import com.erp.entity.Module;
import com.erp.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by wang_ on 2016-09-21.
 */
@Service
public class ModuleUtil {
    private static Logger logger = Logger.getLogger(ModuleUtil.class);
    private static Map<Integer, Set<Module>> projectModuleMaps;
    private static Map<Integer, Module> moduleMaps;

    @Autowired
    private IModuleDao moduleDao;

    /**
     * @param flag
     * @param moduleId
     * @return
     * @throws ServiceException
     */
    public List<Module> initModules(boolean flag, String[] moduleId) throws ServiceException {
        List<Module> modules = null;
        try {
            modules = moduleDao.queryModules(flag);

            if (projectModuleMaps == null) {
                projectModuleMaps = new HashMap<Integer, Set<Module>>();
                moduleMaps = new HashMap<Integer, Module>();
            } else {
                projectModuleMaps.clear();
                moduleMaps.clear();
            }

            if (moduleId == null || moduleId.length == 0) {
                initWithoutArray(modules);
            } else {
                initByArray(modules, moduleId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("»ñÈ¡Ä£¿éÊ§°Ü£º" + e.getMessage(), e);
            throw new ServiceException(e);
        }
        return modules;
    }

    /**
     * @param modules
     */
    private void initWithoutArray(List<Module> modules) {
        for (Module m : modules) {
            if (m.getParentType().equalsIgnoreCase("P")) {
                Set<Module> ms = projectModuleMaps.get(m.getParentId());
                if (ms == null) {
                    ms = new TreeSet<Module>();
                    projectModuleMaps.put(m.getParentId(), ms);
                }
                ms.add(m);
            }
            moduleMaps.put(m.getModuleId(), m);
        }

        for (Module m : modules) {
            if (m.getParentType().equalsIgnoreCase("m")) {
                moduleMaps.get(m.getParentId()).addChild(m);
            }
        }
    }

    /**
     * @param modules
     * @param moduleId
     */
    private void initByArray(List<Module> modules, String[] moduleId) {
        for (Module m : modules) {
            if (Arrays.asList(moduleId).contains(m.getModuleId()+"")) {
                if (m.getParentType().equalsIgnoreCase("P")) {
                    Set<Module> ms = projectModuleMaps.get(m.getParentId());
                    if (ms == null) {
                        ms = new TreeSet<Module>();
                        projectModuleMaps.put(m.getParentId(), ms);
                    }
                    ms.add(m);
                }
                moduleMaps.put(m.getModuleId(), m);
            }
        }

        for (Module m : modules) {
            if (Arrays.asList(moduleId).contains(m.getModuleId()+"")) {
                if (m.getParentType().equalsIgnoreCase("m")) {
                    moduleMaps.get(m.getParentId()).addChild(m);
                }
            }
        }

    }

    /**
     * @return
     */
    public Set<Module> getModuleByProjectId() {
        return getModuleByProjectId(Integer.valueOf(SystemConfig.getValue("project.id")));
    }

    /**
     * @param id
     * @return
     */
    public Set<Module> getModuleByProjectId(int id) {
        Set<Module> children = projectModuleMaps.get(id);
        if (children == null) {
            children = new HashSet<Module>();
            projectModuleMaps.put(id, children);
        }
        return children;

    }
}
