package vip.xiaonuo.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuzhen.tian
 * @version 1.0 FlowableDataSourceProperties.java  2023/3/27 20:45
 */

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.master")
public class DataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
