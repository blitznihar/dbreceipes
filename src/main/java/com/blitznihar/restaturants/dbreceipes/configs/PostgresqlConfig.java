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
@EnableJpaRepositories(basePackages = "com.blitznihar.restaturants.dbreceipes.repositories.restaurantPostgresql",
        entityManagerFactoryRef = "postgresqlEntityManager", transactionManagerRef = "postgresqlTransactionManager")
public class PostgresqlConfig {

    public PostgresqlConfig() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManager() {
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(postgresqlDataSource());
        em.setPackagesToScan("com.blitznihar.restaturants.dbreceipes.entities.sql");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        return em;
    }

    @Bean
    public DataSource postgresqlDataSource() 
    {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/restaurant");
        dataSource.setUsername("postgres");
        dataSource.setPassword("docker");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager postgresqlTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(postgresqlEntityManager().getObject());
        return transactionManager;
    }

}
