package com.javatpoint.config2;

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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "com.javatpoint.Repository2", entityManagerFactoryRef = "teachManagerFactory", transactionManagerRef = "teachTransactionManager")
public class Db2Config {
	@Bean(name = "teachDataSource")
	@ConfigurationProperties(prefix = "spring.second-datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "teachManagerFactory")
	public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("teachDataSource") DataSource dataSource) {

		Map<String, Object> props = new HashMap();
		props.put(Environment.HBM2DDL_AUTO, "update");
		props.put(Environment.SHOW_SQL, true);
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		return builder.dataSource(dataSource).packages("com.javatpoint.model2").persistenceUnit("d2").properties(props)
				.build();
	}

	@Bean(name = "teachTransactionManager")
	public PlatformTransactionManager productTransactionManager(
			@Qualifier("teachManagerFactory") EntityManagerFactory productEntityManagerFactory) {
		return new JpaTransactionManager(productEntityManagerFactory);
	}
}
