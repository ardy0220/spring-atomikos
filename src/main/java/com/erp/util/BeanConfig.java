package com.erp.util;

import com.erp.enums.ResourceXmlEnum;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.List;
import java.util.Set;

/**
 * Created by wang_ on 2016-09-12.
 */
public class BeanConfig {
    private static Logger logger = Logger.getLogger(BeanConfig.class);
    private static BeanConfig instance;
    private String[] packages;
    private Set<Class<?>> classes;

    private BeanConfig() throws Exception {
        String beanConfig = ResourceXmlEnum.path_beanconfig.getValue();
        Document doc = XmlUtil.getDocument(beanConfig);
        Element root = doc.getRootElement();
        List<Element> elements = root.elements();
        if (elements != null && elements.size() > 0) {
            packages = new String[elements.size()];

            for (int i=0; i<elements.size(); i++) {
                Element element = elements.get(i);
                packages[i] = element.getTextTrim();
            }
        }
        loadClasses();

    }

    private void loadClasses() {
        if (packages == null || packages.length == 0) {
            logger.error("not config the bean in bean-package.xml!");
            return;
        }
        if (classes != null) {
            classes.clear();
        }
        for (String pk : packages) {
            classes = ClassesManage.getClassesByPackage(pk, classes);
        }
    }

    public Set<Class<?>> getClasses() {
        return classes;
    }

    public static BeanConfig getInstance() throws Exception {
        if (instance == null) {
            instance = new BeanConfig();
        }
        return instance;
    }

//    public static void main(String[] args) throws Exception {
//        logger.info(BeanConfig.getInstance().getClasses().size());
//    }

}
