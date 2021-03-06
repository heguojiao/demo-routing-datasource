package com.lichenxing.routingdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(
		exclude = {
				DataSourceAutoConfiguration.class,
				HibernateJpaAutoConfiguration.class,
				JdbcTemplateAutoConfiguration.class
		})
public class DemoRoutingDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRoutingDatasourceApplication.class, args);
	}

}
