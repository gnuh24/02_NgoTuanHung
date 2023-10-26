package Repository;

import Utils.HibernateUtils;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Account;
import entity.Employee;

public class EmployeeRepository {
    private HibernateUtils hibernateUtils;
    
    public EmployeeRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }
    
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Employee> query = session.createQuery("FROM Employee");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employee getEmployeeById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Employee employee = session.get(Employee.class, id);
            return employee;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createEmployee(Employee employee) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(employee);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateEmployee(short id, Employee employee) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            session.update(employee);

            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteEmployee(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Employee employee = (Employee) session.load(Employee.class, id);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("Delete success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isEmployeeExistsByID(short id) {
        // get employee
        Employee employee = getEmployeeById(id);

        // return result
        return employee != null;
    }
}
