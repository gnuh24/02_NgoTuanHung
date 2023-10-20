package Repository;

import Utils.HibernateUtils;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.CategoryQuestion;

public class CategoryQuestionRepository {
    private HibernateUtils hibernateUtils;
    
    public CategoryQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }
    
    @SuppressWarnings("unchecked")
    public List<CategoryQuestion> getAllCategoryQuestion() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public CategoryQuestion getCategoryQuestionById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            CategoryQuestion categoryQuestion = session.get(CategoryQuestion.class, id);
            return categoryQuestion;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public CategoryQuestion getCategoryQuestionByName(String categoryName) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            
            Query <CategoryQuestion> query = session.createQuery("FROM CategoryQuestion WHERE CategoryName = :categoryName");
            query.setParameter("categoryName", categoryName);
            CategoryQuestion categoryQuestion = query.uniqueResult();
            return categoryQuestion;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public void createCategoryQuestion(CategoryQuestion categoryQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(categoryQuestion);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void updateCategoryQuestion(short id, String categoryName) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);
            categoryQuestion.setCategoryName(categoryName);
            
            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void updateCategoryQuestion(CategoryQuestion categoryQuestion) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            session.update(categoryQuestion);
         
            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void deleteCategoryQuestion(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            CategoryQuestion categoryQuestion = (CategoryQuestion) session.load(CategoryQuestion.class, id);
            session.delete(categoryQuestion);
         
            session.getTransaction().commit();
            System.out.println("Delete success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public boolean isCategoryQuestionExistsByID(short id) {
    
        // get department
        CategoryQuestion categoryQuestion = getCategoryQuestionById(id);
    
        // return result
        if (categoryQuestion == null) {
            return false;
        }
    
        return true;
    }
    
    public boolean isCategoryQuestionExistsByName(String categoryName) {
        CategoryQuestion categoryQuestion = getCategoryQuestionByName(categoryName);
    
        if (categoryQuestion == null) {
            return false;
        }
        
        return true;
    }
}




