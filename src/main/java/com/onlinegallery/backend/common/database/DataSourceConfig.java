package com.onlinegallery.backend.common.database;

import com.zaxxer.hikari.HikariDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class,
    basePackages = {
    "com.onlinegallery.backend.app.artist.repository",
    "com.onlinegallery.backend.app.exhibition.repository",
    "com.onlinegallery.backend.app.notice.repository"}
    
)
public class DataSourceConfig {
    @Autowired
    private DatasourceJpaProperties datasourceJpaProperties;
    
    
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariDataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
    
    @Bean("entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean onlineGalleryEntityManagerFactory(@Qualifier("dataSource") DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setPersistenceProvider(new HibernatePersistenceProvider());
        entityManagerFactory.setPackagesToScan(
            "com.onlinegallery.backend.app.artist.model.entity",
            "com.onlinegallery.backend.app.exhibition.model.entity",
            "com.onlinegallery.backend.app.notice.model.entity"
        );
        entityManagerFactory.setPersistenceUnitName("onlineGalleryPersistenceUnit");
        entityManagerFactory.setDataSource(dataSource);
        
        Properties properties = datasourceJpaProperties.additionalProperties();
        properties.setProperty("org.hibernate.envers.audit_table_suffix", datasourceJpaProperties.getAuditTablesuffix());
        
        entityManagerFactory.setJpaProperties(properties);
        
        return entityManagerFactory;
    }
}
