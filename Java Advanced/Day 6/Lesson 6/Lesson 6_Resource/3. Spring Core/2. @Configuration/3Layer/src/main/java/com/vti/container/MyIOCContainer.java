package com.vti.container;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vti.utils.HibernateUtils;

@Configuration
public class MyIOCContainer {

	@Bean
	public HibernateUtils getHibernate() {
		return new HibernateUtils();
	}
}

