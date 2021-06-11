package com.springJdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springJdbc.Dao.StudentDao;
import com.springJdbc.Dao.StudentDaoImplement;

@Configuration
@ComponentScan(basePackages = {"com.springJdbc.Dao"})
public class javaconfig {
	
	@Bean(name={"datasource"})
	public DataSource getDataSource()
	{
		DriverManagerDataSource dmd=new DriverManagerDataSource();
		dmd.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmd.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dmd.setUsername("root");
		dmd.setPassword("123456");
		return dmd;
	}
	
	@Bean("myjdbctemplete")
	public JdbcTemplate getJdbcTemplet()
	{
		JdbcTemplate templete=new JdbcTemplate();
		templete.setDataSource(getDataSource());
	    return templete;
	}
	
	
	
	// i can do this by autowire ioc container automatically create this object 
//	@Bean(name={"studentdao"})
//	public StudentDao getStudentDao()
//	{
//		//student dao ki implemtation child class 
//		StudentDaoImplement dao=new StudentDaoImplement();
//		dao.setJdbctemplet(getJdbcTemplet());
//		return dao;
//	}
		
	
	

}
