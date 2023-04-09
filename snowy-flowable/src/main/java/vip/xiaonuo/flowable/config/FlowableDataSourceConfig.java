package vip.xiaonuo.flowable.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author liuzhen.tian
 * @version 1.0 FlowableDataSourceConfig.java  2023/3/27 21:34
 */
@Configuration
@MapperScan(basePackages = "vip.xiaonuo.flowable.dal", sqlSessionFactoryRef = "flowableSqlSessionFactory")
public class FlowableDataSourceConfig {
    @Autowired
    private FlowableDataSourceProperties flowableDataSourceProperties;

    private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();


    @Bean(name = "flowableDataSource")
    public DataSource flowableDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        BeanUtils.copyProperties(flowableDataSourceProperties, druidDataSource);
        return druidDataSource;
    }


    //配置第一个sqlsessionFactory
    @Bean(name = "flowableSqlSessionFactory")
    public SqlSessionFactory flowableSqlSessionFactory(@Qualifier("flowableDataSource") DataSource flowableDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(flowableDataSource);
        bean.setMapperLocations(resolveMapperLocations(new String[]{"classpath*:mapper/fw/*Mapper.xml", "classpath*:mapper/*Mapper.xml"}));
        bean.setTypeAliasesPackage("com.ruoyi.system.domain.vo,vip.xiaonuo.flowable.domain");
        return bean.getObject();
    }


    public Resource[] resolveMapperLocations(String[] mapperLocations) {
        return Stream.of(Optional.ofNullable(mapperLocations).orElse(new String[0]))
                .flatMap(location -> Stream.of(getResources(location))).toArray(Resource[]::new);
    }

    private Resource[] getResources(String location) {
        try {
            return resourceResolver.getResources(location);
        } catch (IOException e) {
            return new Resource[0];
        }
    }
}
