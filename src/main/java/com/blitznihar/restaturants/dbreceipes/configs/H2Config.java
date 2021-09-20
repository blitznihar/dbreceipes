package com.blitznihar.restaturants.dbreceipes.configs;

import javax.sql.DataSource;

import com.blitznihar.restaturants.dbreceipes.constants.ConfigurationConstants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = ConfigurationConstants.BASEPACKAGES_REPOSITORY_H2,
        entityManagerFactoryRef = ConfigurationConstants.H2_ENTITY_MANAGER, transactionManagerRef = ConfigurationConstants.H2_TRANSACTION_MANAGER)
@PropertySource(ConfigurationConstants.CLASSPATH_DATABASE_PROPERTIES)
public class H2Config {

    @Value("${h2.databasename}")
    private String databaseNameH2;

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
		em.setPackagesToScan(new String[] {ConfigurationConstants.PACKAGES_TO_SCAN});
		em.setJpaVendorAdapter(jpaVendorAdapter());
		return em;
	}

    @Primary
    @Bean
    public DataSource h2DataSource() 
    {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName(databaseNameH2)
                .addDefaultScripts()
                .build();
    }
    @Primary
    @Bean
    public PlatformTransactionManager h2TransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(h2EntityManager().getObject());
        return transactionManager;
    }

}
