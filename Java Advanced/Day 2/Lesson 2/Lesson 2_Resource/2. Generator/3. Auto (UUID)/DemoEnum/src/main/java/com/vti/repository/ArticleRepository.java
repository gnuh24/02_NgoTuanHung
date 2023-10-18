package com.vti.repository;

import org.hibernate.Session;

import com.vti.entity.Article;
import com.vti.utils.HibernateUtils;

public class ArticleRepository {

	private HibernateUtils hibernateUtils;

	public ArticleRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	public void createArticle(Article article) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(article);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
