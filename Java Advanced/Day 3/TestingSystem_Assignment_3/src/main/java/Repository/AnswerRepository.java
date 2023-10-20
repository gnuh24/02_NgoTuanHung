package Repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtils;
import entity.Answer;

public class AnswerRepository {
	private HibernateUtils hibernateUtils;
	
	public AnswerRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	public List<Answer> getAllAnswer(){
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Query <Answer> query = session.createQuery("FROM Answer");
			
			return query.list();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	public Answer getAnswerByID(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Answer answer = (Answer) session.get(Answer.class, id);
			
			return answer;
			
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createAnswer(Answer answer) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			session.save(answer);
            System.out.println("Create success !!");

			
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateAnswer(short id, String content) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			session.beginTransaction();
			
			Answer answer = (Answer) session.get(Answer.class, id);
			answer.setContent(content);
						
			session.getTransaction().commit();
			
			
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateAnswer(Answer answer) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			session.beginTransaction();
			
			session.update(answer);
			
			session.getTransaction().commit();
			
			
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deleteAnswer(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			session.beginTransaction();
			
			Answer answer = (Answer) session.load(Answer.class, id);
			
			session.delete(answer);
			
			session.getTransaction().commit();
            System.out.println("Delete success !!");

			
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	public boolean isAnswerExistsByID(short id) {
		Answer answer = getAnswerByID(id);
		if (answer == null) {
			return false;
		}
		return true;
	}
	
}
