package com.teste.teste;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DbConfig {
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/crypto");
		//dataSource.setUsername("root");
		//dataSource.setPassword("");

		dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/crypto");
		dataSource.setUsername("postgres");
		dataSource.setPassword("1234");
		//config postgre heroku
		//dataSource.setUrl("jdbc:postgresql://ec2-34-233-214-228.compute-1.amazonaws.com:5432/d7jdltsp7qvc2j");
		//dataSource.setUsername("ntpaffegzeijzy");
		//dataSource.setPassword("1010f6207135a061f0dfc05eee096fca818933fb8d0bdfead7c0daffa7ce918b");
        return dataSource;
    }
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		//adapter.setDatabase(Database.MYSQL);
		//adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setPrepareConnection(true);
		return adapter;
	}

}
