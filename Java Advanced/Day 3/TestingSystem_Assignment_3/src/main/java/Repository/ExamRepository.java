package Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtils;
import entity.Exam;

public class ExamRepository {
	private HibernateUtils hibernateUtils;

    public ExamRepository() {
        hibernateUtils = HibernateUtils.getInstance();             
    }

    @SuppressWarnings("unchecked")
    public List<Exam> getAllExam() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Exam> query = session.createQuery("FROM Exam");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public Exam getExamByID(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Exam exam = session.get(Exam.class, id);
            return exam;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createExam(Exam exam) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(exam);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateExam(short id, String title, short duration) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Exam exam = session.get(Exam.class, id);

            
            exam.setTitle(title);
            exam.setDuration(duration);
            

            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateExam(Exam exam) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.update(exam);
            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteExam(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.beginTransaction();

            Exam exam = session.get(Exam.class, id);

            if (exam != null) {
                session.delete(exam);
                System.out.println("Delete success !!");
            } else {
                System.out.println("Exam with ID " + id + " not found.");
            }

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isExamExistsByID(short id) {
        Exam exam = getExamByID(id);

        if (exam == null) {
            return false;
        }

        return true;
    }


}
