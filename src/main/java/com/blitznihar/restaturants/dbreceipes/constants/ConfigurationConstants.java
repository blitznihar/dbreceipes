package com.blitznihar.restaturants.dbreceipes.constants;

public class ConfigurationConstants {

    public static final String PACKAGES_TO_SCAN = "com.blitznihar.restaturants.dbreceipes.entities.sql";

    
    public static final String CLASSPATH_DATABASE_PROPERTIES = "classpath:database-${spring.profiles.active}.properties";
    public static final String COM_BLITZNIHAR_RESTATURANTS_DBRECEIPES = "com.blitznihar.restaturants.dbreceipes";
    
    
    public static final String BASEPACKAGES_REPOSITORY_H2 = "com.blitznihar.restaturants.dbreceipes.repositories.restaurantH2";
    public static final String BASEPACKAGES_REPOSITORY_MONGO = "com.blitznihar.restaturants.dbreceipes.repositories.restaurantMongo";
    public static final String BASEPACKAGES_REPOSITORY_MSSQL = "com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMssql";
    public static final String BASEPACKAGES_REPOSITORY_MYSQL = "com.blitznihar.restaturants.dbreceipes.repositories.RestaurantMysql";
    public static final String BASEPACKAGES_REPOSITORY_POSTGRESQL = "com.blitznihar.restaturants.dbreceipes.repositories.RestaurantPostgresql";


    public static final String H2_TRANSACTION_MANAGER = "h2TransactionManager";
    public static final String H2_ENTITY_MANAGER = "h2EntityManager";
    public static final String MSSQL_TRANSACTION_MANAGER = "mssqlTransactionManager";
    public static final String MSSQL_ENTITY_MANAGER = "mssqlEntityManager";
    public static final String MYSQL_TRANSACTION_MANAGER = "mysqlTransactionManager";
    public static final String MYSQL_ENTITY_MANAGER = "mysqlEntityManager";
    public static final String POSTGRESQL_TRANSACTION_MANAGER = "postgresqlTransactionManager";
    public static final String POSTGRESQL_ENTITY_MANAGER = "postgresqlEntityManager";
    
}
