package Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtils;
import entity.Exam;
import entity.ExamQuestion;
import entity.ExamQuestionPK;
public class ExamQuestionRepository {
    private HibernateUtils hibernateUtils;

    public ExamQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<ExamQuestion> getAllExamQuestions() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<ExamQuestion> query = session.createQuery("FROM ExamQuestion");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createExamQuestion(ExamQuestion examQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(examQuestion);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // Add other methods as needed
}
