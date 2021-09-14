package com.nujabness.katawemanity.data.configuration;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EntityScan("com.nujabness.katawemanity.data.entity")
@EnableJpaRepositories(basePackages= "com.nujabness.katawemanity.data.dao", entityManagerFactoryRef="entityManagerFactory")
@EnableJpaAuditing
@EnableTransactionManagement
public class RepositoryConfiguration {

  @Autowired
  private ConfigurableEnvironment environment;

  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    return DataSourceBuilder.create()
      .username(environment.getProperty("app.datasource.username"))
      .password(environment.getProperty("app.datasource.password"))
      .url(environment.getProperty("app.datasource.url"))
      .driverClassName(environment.getProperty("app.datasource.driverClassName"))
      .build();
  }

  @Bean(name = "entityManagerFactory")
  public EntityManagerFactory getEntityManagerFactory(DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setPackagesToScan("com.nujabness.katawemanity.data.entity");
    entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    Properties jpaProperties = new Properties();
    jpaProperties.setProperty("hibernate.show_sql", "true");
    entityManagerFactoryBean.setJpaProperties(jpaProperties);
    entityManagerFactoryBean.afterPropertiesSet();
    return entityManagerFactoryBean.getObject();
  }

  @Bean(name = "transactionManager")
  public JpaTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);

  }

  @Bean
  public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
    final DataSourceInitializer initializer = new DataSourceInitializer();
    initializer.setDataSource(dataSource);
    return initializer;
  }
}
