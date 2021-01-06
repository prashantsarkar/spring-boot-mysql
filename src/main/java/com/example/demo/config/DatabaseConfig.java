package com.example.demo.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
	
	@Bean
	public DataSource dataSource() throws SQLException {
		return DataSourceBuilder.create()
				.url("jdbc:mysql://www.db4free.net:3306/testdb007")
				.username("mysplitwise")
				.password("splitwise")
				.build();
	}
}
