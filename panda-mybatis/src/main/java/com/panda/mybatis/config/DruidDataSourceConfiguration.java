package com.panda.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 构造 durid 连接池
 * @author wujianhui
 * @date 2019/2/18
 */
@Configuration
@Slf4j
public class DruidDataSourceConfiguration {

	@Value("${spring.datasource.druid.type}")
	private Class<? extends DataSource> dataSourceType;

	@Bean(name = "druidDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid")
	@Primary
	public DataSource druidDataSource() {
		log.info("-------------------- Druid Data Source init ---------------------");
		return DataSourceBuilder.create().type(dataSourceType).build();
	}
}
