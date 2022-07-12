package com.zdx.transaction;

import com.zdx.transaction.service.AService;
import org.h2.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

@EnableTransactionManagement
@ComponentScan("com.zdx.transaction")
public class MyTxMain {

	@Test
	public void test() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyTxMain.class);
//		context.register(MyBDRPP.class);
		AService aService = context.getBean(AService.class);
		aService.query();
	}

	@Bean
	public DataSourceTransactionManager transactionManager(DataSource dataSource){
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public DataSource dataSource(){
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriver(new Driver());
		dataSource.setUrl("jdbc:h2:mem:test;MODE=mysql;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) throws IOException {
		final DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);
		initializer.setDatabasePopulator(databasePopulator());
		initializer.setEnabled(true);
		return initializer;
	}

	private DatabasePopulator databasePopulator() throws IOException {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.setContinueOnError(false);
		resourceDatabasePopulator.addScripts(
				new PathMatchingResourcePatternResolver().getResources("classpath:/h2/*.sql")
		);
		return resourceDatabasePopulator;
	}
}
