package Utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.*;

public class HibernateUtils {
	private static HibernateUtils instance;
	private Configuration configuration;
	private SessionFactory sessionFactory;
	
	public static HibernateUtils getInstance() {
		if (HibernateUtils.instance == null) {
			HibernateUtils.instance = new HibernateUtils();
		}
		return HibernateUtils.instance;
	}
	
	private HibernateUtils() {
		configure();
	}
	
	private void configure() {
		configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		//Add entity
		configuration.addAnnotatedClass(Account.class);
		
		configuration.addAnnotatedClass(Answer.class);

		configuration.addAnnotatedClass(CategoryQuestion.class);
		
		configuration.addAnnotatedClass(Department.class);

		configuration.addAnnotatedClass(Exam.class);

		configuration.addAnnotatedClass(Group.class);

		configuration.addAnnotatedClass(Position.class);

		configuration.addAnnotatedClass(Question.class);

		configuration.addAnnotatedClass(Salary.class);

		configuration.addAnnotatedClass(TypeQuestion.class);


	}
	
	private SessionFactory buildSessionFactory() {
		if (this.sessionFactory == null || this.sessionFactory.isClosed()) {
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return this.sessionFactory;
	}
	
	public void closeSessionFactory() {
		if (this.sessionFactory != null || this.sessionFactory.isOpen()) {
			this.sessionFactory.isClosed();
		}
	}
	
	public Session openSession() {
		buildSessionFactory();
		return this.sessionFactory.openSession();
	}
	
	
}
