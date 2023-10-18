package com.vti;

import com.vti.entity.Article;
import com.vti.repository.ArticleRepository;

public class Program {
	public static void main(String[] args) {
		ArticleRepository repository = new ArticleRepository();

		System.out.println("\n\n***********CREATE ARTICLE***********");

		Article article = new Article();
		article.setTitle("Article 5");
		article.setStatus(Article.Status.REVIEW);
		repository.createArticle(article);

	}
}

