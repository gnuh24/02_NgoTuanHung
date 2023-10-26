package Repository;

import Utils.HibernateUtils;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.DetailDepartment;

public class DetailDepartmentRepository {
    private HibernateUtils hibernateUtils;
    
    public DetailDepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }
    
    @SuppressWarnings("unchecked")
    public List<DetailDepartment> getAllDetailDepartments() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public DetailDepartment getDetailDepartmentById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            DetailDepartment detailDepartment = session.get(DetailDepartment.class, id);
            return detailDepartment;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createDetailDepartment(DetailDepartment detailDepartment) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(detailDepartment);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateDetailDepartment(short id, DetailDepartment detailDepartment) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            session.update(detailDepartment);

            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteDetailDepartment(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            DetailDepartment detailDepartment = (DetailDepartment) session.load(DetailDepartment.class, id);
            session.delete(detailDepartment);

            session.getTransaction().commit();
            System.out.println("Delete success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isDetailDepartmentExistsByID(short id) {
        // get detail department
        DetailDepartment detailDepartment = getDetailDepartmentById(id);

        // return result
        return detailDepartment != null;
    }
}
