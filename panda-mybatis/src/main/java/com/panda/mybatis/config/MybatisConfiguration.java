package com.panda.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Slf4j
@Configuration
@Import({ DruidDataSourceConfiguration.class })
@MapperScan(basePackages = "com.panda.mybatis.mapper", sqlSessionFactoryRef = "druidSqlSessionFactory")
@Primary
public class MybatisConfiguration {

	@Resource(name = "druidDataSource")
	private DataSource druidDataSource;

	@Value("${mybatis.mapper-locations}")
	private String mapperLocations;

	@Value("${mybatis.config-location}")
	private String configLocation;

	@Value("${mybatis.type-aliases-package}")
	private String typeAliasesPackage;

	@Bean("druidSqlSessionFactory")
	@Primary
	public SqlSessionFactory druidSqlSessionFactory() throws Exception {
		log.info("-----------------Custom SqlSessionFactory init-----------------");
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(druidDataSource);
		sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasesPackage);

		PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setConfigLocation(pathMatchingResourcePatternResolver.getResource(configLocation));
		sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(mapperLocations));

		return sqlSessionFactoryBean.getObject();
	}
}
