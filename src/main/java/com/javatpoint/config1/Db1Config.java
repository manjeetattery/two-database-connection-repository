package com.javatpoint.config1;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
@Configuration
@EnableJpaRepositories(basePackages = "com.javatpoint.repository1",
        entityManagerFactoryRef = "studentManagerFactory",
        transactionManagerRef = "studentTransactionManager")
public class Db1Config {
	@Primary
	@Bean(name = "studentDataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource customerDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "studentManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("studentDataSource") DataSource dataSource) {
		Map<String, Object> props = new HashMap();
		props.put(Environment.HBM2DDL_AUTO, "update");
		props.put(Environment.SHOW_SQL, true);
		props.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
		props.put("spring.h2.console.enabled", true);
		
		return builder.dataSource(dataSource).packages("com.javatpoint.model1").persistenceUnit("d1").properties(props).build();
	}

	@Primary
	@Bean(name = "studentTransactionManager")
	public PlatformTransactionManager customerTransactionManager(
			@Qualifier("studentManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
		return new JpaTransactionManager(customerEntityManagerFactory);
	}
}
