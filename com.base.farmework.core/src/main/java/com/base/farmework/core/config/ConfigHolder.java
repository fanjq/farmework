package com.base.farmework.core.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author     ：fjq
 * @version : 1.0.0
 * createTime       ：2019-10-28 15:27
 * description ： 系统的配置文件
 */
public class ConfigHolder {

    private final Properties properties;

    /**
     * @author : fjq
     * createTime : 2019-10-28
     */
    public ConfigHolder (Properties properties){
        this.properties = properties;
    }


    private Properties getProperties(){
        return this.properties;
    }

    public String getProperty(String key){
        return this.properties.getProperty(key);
    }

    public Properties getProperties(String prefix) {
        return this.getProperties(prefix,false);
    }

    public Properties getProperties(String prefix,boolean shortKey) {
        return this.getProperties(this.getProperties(), prefix, shortKey);
    }
    private Properties getProperties(Properties properties,String prefix,boolean shortKey) {
        if(!prefix.endsWith(".")){
            prefix = prefix+".";
        }

        Properties ret = new Properties();
        Set<Map.Entry<Object, Object>> set = properties.entrySet();
        for (Map.Entry<Object, Object> ent : set) {
            String key = ent.getKey().toString();
            if(key.startsWith(prefix)){
                if(shortKey){
                    key = key.substring(prefix.length());
                }
                ret.put(key, ent.getValue());
            }
        }
        return ret;
    }

    public Map<String, Properties> getSubProperties(String prefix) {
        return this.getSubProperties(prefix, false);
    }

    public Map<String, Properties> getSubProperties(String prefix,boolean shortKey) {
        Map<String, Properties> map = new HashMap<String, Properties>();
        if(!prefix.endsWith(".")){
            prefix = prefix+".";
        }
        Properties prop = this.getProperties(prefix);
        Set<Map.Entry<Object, Object>> set = prop.entrySet();
        int length = prefix.length();
        for (Map.Entry<Object, Object> ent : set) {
            String key = ent.getKey().toString();
            String subKey = key.substring(length, key.indexOf(".",length+1));
            Properties p2 = map.get(subKey);
            if(p2==null){
                p2 = new Properties();
                map.put(subKey, p2);
            }
            if(shortKey){
                p2.put(key.substring(length+subKey.length()+1), ent.getValue());
            }else{
                p2.put(key, ent.getValue());
            }
        }
        return map;
    }
}
