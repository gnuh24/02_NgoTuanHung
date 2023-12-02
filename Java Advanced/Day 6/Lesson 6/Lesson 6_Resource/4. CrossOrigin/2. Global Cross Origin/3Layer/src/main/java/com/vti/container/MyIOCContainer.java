package com.vti.container;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.vti.utils.HibernateUtils;

@Configuration
public class MyIOCContainer {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public HibernateUtils getHibernate() {
		return new HibernateUtils();
	}
}

