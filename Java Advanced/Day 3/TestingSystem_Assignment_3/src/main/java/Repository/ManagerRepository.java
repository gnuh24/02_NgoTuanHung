package Repository;

import Utils.HibernateUtils;
import entity.Manager;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ManagerRepository {
    private HibernateUtils hibernateUtils;

    public ManagerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Manager> getAllManagers() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Manager> query = session.createQuery("FROM Manager");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Manager getManagerById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Manager manager = session.get(Manager.class, id);
            return manager;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createManager(Manager manager) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(manager);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateManager(short id, Manager manager) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(manager);

            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteManager(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Manager manager = (Manager) session.load(Manager.class, id);
            session.delete(manager);

            session.getTransaction().commit();
            System.out.println("Delete success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isManagerExistsByID(short id) {
        // get manager
        Manager manager = getManagerById(id);

        // return result
        return manager != null;
    }
}