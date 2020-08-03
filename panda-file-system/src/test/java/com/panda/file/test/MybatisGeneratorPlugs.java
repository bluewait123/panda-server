package com.panda.file.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成mybatis Mapper XML文件
 * @author w
 * @date 2020-06-24
 */
public class MybatisGeneratorPlugs {
	public static void main(String[] args) throws Throwable {
		List<String> warnings = new ArrayList<>();
		boolean overwrite = true;
		String path = System.getProperty("user.dir") + "/generatorConfig.xml";// read
		File configFile = new File(path);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
		System.exit(0);
	}
}
