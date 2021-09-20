package com.blitznihar.restaturants.dbreceipes.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import com.blitznihar.restaturants.dbreceipes.constants.ConfigurationConstants;
@Configuration
@EnableJpaRepositories(basePackages = ConfigurationConstants.BASEPACKAGES_REPOSITORY_POSTGRESQL, 
                        entityManagerFactoryRef = ConfigurationConstants.POSTGRESQL_ENTITY_MANAGER, 
                        transactionManagerRef = ConfigurationConstants.POSTGRESQL_TRANSACTION_MANAGER)
@PropertySource(ConfigurationConstants.CLASSPATH_DATABASE_PROPERTIES)
public class PostgresqlConfig {

    @Value("${mssql.driverClassName}")
    private String driverClassName;
    @Value("${mssql.connectionstring}")
    private String url;
    @Value("${mssql.password}")
    private String password;
    @Value("${mssql.username}")
    private String username;

    public PostgresqlConfig() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(postgresqlDataSource());
        em.setPackagesToScan(ConfigurationConstants.PACKAGES_TO_SCAN);

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DataSource postgresqlDataSource() 
    {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager postgresqlTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(postgresqlEntityManager().getObject());
        return transactionManager;
    }

}
