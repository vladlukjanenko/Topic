package net.topic.config;

import net.topic.util.config.DatabaseConfig;
import net.topic.util.config.FlywayConfig;
import org.apache.commons.dbcp2.BasicDataSource;
import org.flywaydb.core.Flyway;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Persistence configuration.
 *
 * @author Vlad Lukjanenko.
 */
@Configuration
public class PersistenceConfig {

    /**
     * Configure database migration tool.
     *
     * @param dataSource    datasource.
     * @return {@link Flyway} instance.
     * */
    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {

        FlywayConfig flywayConfig = FlywayConfig.getInstance();
        Flyway flyway = new Flyway();

        flyway.setDataSource(dataSource);
        flyway.setEncoding(flywayConfig.getEncoding());
        flyway.setLocations(flywayConfig.getLocations());
        flyway.setTable(flywayConfig.getTable());

        return flyway;
    }

    /**
     * Configure datasource.
     *
     * @return {@link DataSource} instance.
     * */
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {

        DatabaseConfig dbConfig = DatabaseConfig.getInstance();
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(dbConfig.getDriverClassName());
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setUsername(dbConfig.getUsername());
        dataSource.setPassword(dbConfig.getPassword());

        return dataSource;
    }

    /**
     * Configure JPA vendor adapter.
     *
     * @return {@link EntityManagerFactory} instance.
     * */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {

        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
        jpaVendorAdapter.setShowSql(true);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabasePlatform(PostgreSQL95Dialect.class.getName());

        return jpaVendorAdapter;
    }

    /**
     * Configure entity manager factory.
     *
     * @param dataSource    datasource.
     * @return {@link EntityManagerFactory} instance.
     * */
    @Bean
    @DependsOn("flyway")
    public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        entityManagerFactoryBean.setPackagesToScan("net.topic.entities");

        entityManagerFactoryBean.afterPropertiesSet();

        return entityManagerFactoryBean.getObject();
    }

    /**
     * Configure transaction manager.
     *
     * @param entityManagerFactory  entity manager factory.
     * @return  {@link PlatformTransactionManager} instance.
     * */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {

        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }
}
