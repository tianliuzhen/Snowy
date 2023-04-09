package vip.xiaonuo.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author liuzhen.tian
 * @version 1.0 MybatisConfig.java  2023/4/9 11:29
 */
@Configuration
public class MybatisConfig {
    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Primary
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        BeanUtils.copyProperties(dataSourceProperties, druidDataSource);
        return druidDataSource;
    }
}
