package com.base.farmework.core.definition;

import java.net.URL;
import java.util.List;

/**
 * @author     ：fjq
 * @version :     1.0.0
 * createTime       ：2019-10-28 16:44
 * description ： 用于加载默认的配置文件。
 */

public class FarmeWorkPorpertisLoad {

    private static final String DEFAULT_CONFIG_YML = "classpath*:/META-INF/conf/default-config.yml";

    /**
     * @author : fjq
     * @version : 1.0.0
     * createTime : 2019-10-28 16:53
     *
     * 拿到目前环境中的所有默认yml配置文件
     */
    private List<String> preparedPath(){
        URL resource = this.getClass().getResource(DEFAULT_CONFIG_YML);
        return null;
    }
}
