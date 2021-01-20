package com.onlinegallery.backend.common.database;

import java.util.Properties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Component
@Configuration
public class DatasourceJpaProperties {

    @Value("${spring.jpa.properties.org.hibernate.envers.audit_table_suffix}")
    private String auditTablesuffix;

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa.hibernate")
    public DatasourceHibernate getDatasourceHibernate() {
        return new DatasourceHibernate();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.jpa.properties.hibernate")
    public DatasourceProperties getDatasourceProperties() {
        return new DatasourceProperties();
    }

    @Getter
    @Setter
    public class DatasourceHibernate {
        private String ddlAuto;
        private String dialect;
    }

    @Getter
    @Setter
    public class DatasourceProperties {
        private String formatSql;
        private String showSql;
        private String useSqlComments;
    }

    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", getDatasourceHibernate().getDialect());
        properties.setProperty("hibernate.format_sql", getDatasourceProperties().getFormatSql());
        properties.setProperty("hibernate.show_sql", getDatasourceProperties().getShowSql());
        properties.setProperty("hibernate.use_sql_comments", getDatasourceProperties().getUseSqlComments());
        return properties;
    }

    public String getAuditTablesuffix() {
        return auditTablesuffix;
    }

}
