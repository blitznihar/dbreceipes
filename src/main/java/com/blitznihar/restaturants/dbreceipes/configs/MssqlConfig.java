package com.blitznihar.restaturants.dbreceipes.configs;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMssql", entityManagerFactoryRef = "mssqlEntityManager", transactionManagerRef = "mssqlTransactionManager")
public class MssqlConfig {

    public MssqlConfig() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mssqlEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mssqlDataSource());
        em.setPackagesToScan("com.blitznihar.restaturants.dbreceipes.entities.sql");
        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DataSource mssqlDataSource() 
    {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://localhost;databaseName=restaurant");
        dataSource.setUsername("sa");
        dataSource.setPassword("4321~Drowssap");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager mssqlTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mssqlEntityManager().getObject());
        return transactionManager;
    }

}
