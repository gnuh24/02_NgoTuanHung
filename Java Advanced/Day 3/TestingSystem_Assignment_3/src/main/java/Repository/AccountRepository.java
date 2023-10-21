package Repository;

import Utils.HibernateUtils;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.Account;
import entity.Department;

public class AccountRepository {
    private HibernateUtils hibernateUtils;
    
    public AccountRepository() {
    	hibernateUtils = HibernateUtils.getInstance();
    }
    
	@SuppressWarnings("unchecked")
    public List<Account> getAllAccount() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Account> query = session.createQuery("FROM Account");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Account getAccountById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Account account = session.get(Account.class, id);
            return account;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public Account getAccountByUsername(String username) {
    	Session session = null;
        try {
            session = hibernateUtils.openSession();
            
            Query <Account> query = session.createQuery("FROM Account WHERE username = :accountUserName");
            query.setParameter("accountUserName", username);
            Account account = query.uniqueResult();
            return account;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void createAccount(Account account) {
    	Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(account);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
	
	public void updateAccount(short id, String lastname, String firstname, String email, String username) {
		Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            Account account = (Account) session.load(Account.class, id);
            account.setEmail(email);
            account.setFirstname(firstname);
            account.setLastname(lastname);
            account.setUsername(username);
            
            session.getTransaction().commit();
            System.out.println("Delete success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
	}
	
	public void updateAccount(Account account) {
		Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            session.update(account);
         
            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
	}
	
	public void deleteAccount(short id) {
		Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            Account account = (Account) session.load(Account.class, id);
            session.delete(account);
         
            session.getTransaction().commit();
            System.out.println("Delete success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
	}
	
	public boolean isAccountExistsByID(short id) {

		// get department
		Account account = getAccountById(id);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}

	public boolean isAccountExistsByUsername(String username) {
		Account account = getAccountByUsername(username);

		if (account == null) {
			return false;
		}
		
		return true;
	}
    
}

