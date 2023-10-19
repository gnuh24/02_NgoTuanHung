package Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtils;
import entity.Position;
import entity.TypeQuestion;
import entity.TypeQuestion.TypeName;

public class TypeQuestionRepository {
    private HibernateUtils hibernateUtils;

    public TypeQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<TypeQuestion> getAllTypeQuestions() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public TypeQuestion getTypeQuestionById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            TypeQuestion typeQuestion = (TypeQuestion) session.get(TypeQuestion.class, id);
            return typeQuestion;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public TypeQuestion getTypeQuestionByName(TypeName typeName) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            
            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion WHERE TypeName = :typeName");
            query.setParameter("typeName", Integer.toString(typeName.ordinal() ) );
            TypeQuestion typeQuestion = query.uniqueResult();
            if (typeQuestion != null) {
                return typeQuestion;

            } else return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createTypeQuestion(TypeQuestion typeQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.save(typeQuestion);
            session.getTransaction().commit();
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateTypeQuestion(short id, TypeName typeName) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            TypeQuestion typeQuestion = (TypeQuestion) session.get(TypeQuestion.class, id);
            typeQuestion.setTypeName( typeName );

            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateTypeQuestion(TypeQuestion typeQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.update(typeQuestion);
            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteTypeQuestion(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			session.beginTransaction();
			
			TypeQuestion typeQuestion = (TypeQuestion) session.get(TypeQuestion.class, id);
			
			if (typeQuestion != null) {
				session.delete(typeQuestion);
				System.out.println("Delete success !!");

			} else System.out.println("Không tìm thấy ID");
			session.getTransaction().commit();
			
		}
		finally {
			if (session != null) {
				session.close();
			}
		} 
	}

    public boolean isTypeQuestionExistsById(short id) {
        TypeQuestion typeQuestion = getTypeQuestionById(id);

        if (typeQuestion == null) {
            return false;
        }

        return true;
    }
    
    public boolean isTypeQuestionExistsByUsername(TypeName name) {
    	TypeQuestion typeQuestion = getTypeQuestionByName(name);

		if (typeQuestion == null) {
			return false;
		}
		
		return true;
	}
}
