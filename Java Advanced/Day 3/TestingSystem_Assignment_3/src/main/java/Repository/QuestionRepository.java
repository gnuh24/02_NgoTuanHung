package Repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Utils.HibernateUtils;
import entity.Question;

import java.util.List;

public class QuestionRepository {

    private HibernateUtils hibernateUtils;

    public QuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Question> getAllQuestions() {
        Session session = hibernateUtils.openSession();
        try {
            Query<Question> query = session.createQuery("FROM Question", Question.class);
            return query.list();
        } finally {
            session.close();
        }
    }

    public Question getQuestionById(int id) {
        Session session = hibernateUtils.openSession();
        try {
            return session.get(Question.class, id);
        } finally {
            session.close();
        }
    }

    public void createQuestion(Question question) {
        Session session = hibernateUtils.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(question);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateQuestion(Question question) {
        Session session = hibernateUtils.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(question);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteQuestion(int id) {
        Session session = hibernateUtils.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Question question = session.get(Question.class, id);
            if (question != null) {
                session.delete(question);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public boolean isQuestionExistsById(int id) {
        return getQuestionById(id) != null;
    }
}
