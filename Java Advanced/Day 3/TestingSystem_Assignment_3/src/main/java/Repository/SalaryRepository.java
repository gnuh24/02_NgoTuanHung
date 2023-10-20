package Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtils;
import entity.Salary;
import entity.Salary.SalaryName;

public class SalaryRepository {
    private HibernateUtils hibernateUtils;

    public SalaryRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Salary> getAllSalaries() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Salary> query = session.createQuery("FROM Salary");

            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Salary getSalaryByID(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Salary salary = session.get(Salary.class, id);
            return salary;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Salary getSalaryByName(SalaryName name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Salary> query = session.createQuery("FROM Salary WHERE salaryName = :salaryName");
            query.setParameter("salaryName", name);
            Salary salary = query.uniqueResult();
            return salary;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createSalary(Salary salary) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.save(salary);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateSalary(short id, SalaryName name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Salary salary = session.get(Salary.class, id);

            if (salary != null) {
                salary.setSalaryName(name);
            }

            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateSalary(Salary salary) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.update(salary);
            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteSalary(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            session.beginTransaction();

            Salary salary = session.get(Salary.class, id);

            if (salary != null) {
                session.delete(salary);
                System.out.println("Delete success !!");
            } else {
                System.out.println("Salary with ID " + id + " not found.");
            }

            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isSalaryExistsByID(short id) {
        Salary salary = getSalaryByID(id);

        if (salary == null) {
            return false;
        }

        return true;
    }

    public boolean isSalaryExistsByName(SalaryName name) {
        Salary salary = getSalaryByName(name);

        if (salary == null) {
            return false;
        }

        return true;
    }
}
