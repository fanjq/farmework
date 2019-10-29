package com.base.farmework.core.definition;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.core.io.Resource;

import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * @author     ：fjq
 * @version :     1.0.0
 * createTime       ：2019-10-28 16:44
 * description ： 用于加载默认的配置文件。讲所有的配置信息加载到上下文
 */

public class FarmeWorkPorpertisLoad  implements BeanDefinitionRegistryPostProcessor {

    private static final String DEFAULT_CONFIG_YML = "classpath*:/META-INF/conf/default-config.yml";

    private static final Logger logger = LoggerFactory.getLogger(FarmeWorkPorpertisLoad.class);

    // 上下文
    private ApplicationContext applicationContext;
    // 配置信息
    private SimpleCommandLinePropertySource propertySource;


    public FarmeWorkPorpertisLoad(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public FarmeWorkPorpertisLoad(ApplicationContext applicationContext, SimpleCommandLinePropertySource propertySource) {
        this.applicationContext = applicationContext;
        this.propertySource = propertySource;
    }

    /**
     * @author : fjq
     * @version : 1.0.0
     * createTime : 2019-10-28 16:53
     *
     * 拿到目前环境中的所有默认yml配置文件
     */
    private Properties preparedPath(){
        Resource configResource = this.applicationContext.getResource(DEFAULT_CONFIG_YML);

        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(configResource);
        Properties properties = yaml.getObject();
        return properties;
    }



    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    public static void main(String[] args) {
        int i = 1;
        int b = (++i) + (++i);
        System.out.println(b);
    }
}
