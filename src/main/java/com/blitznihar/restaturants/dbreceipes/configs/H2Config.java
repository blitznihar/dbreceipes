package com.blitznihar.restaturants.dbreceipes.configs;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.blitznihar.restaturants.dbreceipes.repositories.restaurantH2",
        entityManagerFactoryRef = "h2EntityManager", transactionManagerRef = "h2TransactionManager")
public class H2Config {

    public H2Config() {
        super();
    }
    @Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter bean = new HibernateJpaVendorAdapter();
		bean.setDatabase(Database.H2);
		bean.setGenerateDdl(true);
        bean.setShowSql(true);
		return bean;
	}
    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean h2EntityManager(){
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(h2DataSource());
		em.setPackagesToScan(new String[] {"com.blitznihar.restaturants.dbreceipes.entities.sql"});
		em.setJpaVendorAdapter(jpaVendorAdapter());
		return em;
	}

    @Primary
    @Bean
    public DataSource h2DataSource() 
    {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("Restaurant")
                .addDefaultScripts()
                .build();
       // final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // dataSource.setDriverClassName("org.h2.Driver");
        // dataSource.setUrl("jdbc:h2:mem:test");
        // dataSource.setUsername("admin");
        // dataSource.setPassword("admin");
        // dataSource.add
        // return dataSource;
    }
    @Primary
    @Bean
    public PlatformTransactionManager h2TransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(h2EntityManager().getObject());
        return transactionManager;
    }

}
