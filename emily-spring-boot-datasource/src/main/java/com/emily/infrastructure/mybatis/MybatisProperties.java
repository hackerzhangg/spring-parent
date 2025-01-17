package com.emily.infrastructure.mybatis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: 数据源配置文件
 * @author: Emily
 * @create: 2020/05/14
 */
@ConfigurationProperties(prefix = MybatisProperties.PREFIX)
public class MybatisProperties {
    /**
     * mybatis前缀
     */
    public static final String PREFIX = "spring.emily.mybatis";
    /**
     * 是否开启数据源组件, 默认：true
     */
    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
