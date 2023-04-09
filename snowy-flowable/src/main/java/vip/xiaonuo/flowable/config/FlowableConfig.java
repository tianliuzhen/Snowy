package vip.xiaonuo.flowable.config;

import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.cfg.HttpClientConfig;
import org.flowable.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.flowable.engine.impl.db.DbIdGenerator;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 流程id生成处理
 * @author Tony
 * @date 2022-12-26 10:24
 */
@Configuration
public class FlowableConfig {

    @Autowired
    @Qualifier(value = "flowableDataSource")
    private DataSource dataSource;

    @Resource
    private PlatformTransactionManager transactionManager;
    // @Resource
    // private IdWorkerIdGenerator idWorkerIdGenerator;


    @Bean
    public SpringProcessEngineConfiguration getSpringProcessEngineConfiguration() {
        SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
        config.setActivityFontName("宋体");
        config.setAnnotationFontName("宋体");
        config.setLabelFontName("黑体");
        config.setDataSource(dataSource);
        config.setTransactionManager(transactionManager);
        config.setDisableIdmEngine(true);
        config.setDatabaseType(ProcessEngineConfigurationImpl.DATABASE_TYPE_MYSQL);
        config.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        // config.setDelegateExpressionFieldInjectionMode(DelegateExpressionFieldInjectionMode.MIXED);
        config.setIdGenerator(new DbIdGenerator());
        config.setAsyncExecutorActivate(Boolean.TRUE);
        HttpClientConfig httpClientConfig=new HttpClientConfig();
        //连接超时
        httpClientConfig.setConnectTimeout(10000);
        //连接请求超时
        httpClientConfig.setConnectionRequestTimeout(10000);
        //双端建立socket连接
        httpClientConfig.setSocketTimeout(10000);
        //请求失败之后重试次数
        httpClientConfig.setRequestRetryLimit(3);
        config.setHttpClientConfig(httpClientConfig);
        config.setKnowledgeBaseCacheLimit(200);
        config.setProcessDefinitionCacheLimit(200);
        //  执行自定义定时任务
        // List<JobHandler> customJobHandlers =new ArrayList<>();
        // customJobHandlers.add(new CustomJobHandler());
        // config.setCustomJobHandlers(customJobHandlers);
        return config;
    }
}
