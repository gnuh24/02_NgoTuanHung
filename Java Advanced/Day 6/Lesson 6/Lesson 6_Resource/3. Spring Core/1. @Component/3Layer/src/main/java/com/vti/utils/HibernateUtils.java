package com.vti.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import com.vti.entity.Department;

@Component
public class HibernateUtils {

	private Configuration configuration;
	private SessionFactory sessionFactory;

	public HibernateUtils() {
		configure();
	}

	/**
	 * This method is created configuration object.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 20, 2020
	 */
	private void configure() {
		// load configuration
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		configuration.addAnnotatedClass(Department.class);
	}

	/**
	 * This method is got SessionFactory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jan 20, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jan 20, 2020
	 */
	private SessionFactory buildSessionFactory() {
		if (null == sessionFactory || sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}

		return sessionFactory;
	}

	/**
	 * This method closes Factory session .
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Dec 8, 2019
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Dec 8, 2019
	 */
	public void closeFactory() {
		if (null != sessionFactory && sessionFactory.isOpen()) {
			sessionFactory.close();
		}
	}

	/**
	 * This method is opened session from SessionFactory.
	 * 
	 * @Description: .
	 * @author: NNDuy
	 * @create_date: Jun 25, 2020
	 * @version: 1.0
	 * @modifer: NNDuy
	 * @modifer_date: Jun 25, 2020
	 */
	public Session openSession() {
		buildSessionFactory();
		return sessionFactory.openSession();
	}

}
