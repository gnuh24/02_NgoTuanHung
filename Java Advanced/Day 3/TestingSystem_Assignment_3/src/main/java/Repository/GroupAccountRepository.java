package Repository;

import Utils.HibernateUtils;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entity.GroupAccount;

public class GroupAccountRepository {
    private HibernateUtils hibernateUtils;
    
    public GroupAccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }
    
    @SuppressWarnings("unchecked")
    public List<GroupAccount> getAllGroupAccounts() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<GroupAccount> query = session.createQuery("FROM GroupAccount");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public GroupAccount getGroupAccountById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            GroupAccount groupAccount = session.get(GroupAccount.class, id);
            return groupAccount;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createGroupAccount(GroupAccount groupAccount) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(groupAccount);
            System.out.println("Create success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateGroupAccount(short id, GroupAccount groupAccount) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            
            session.update(groupAccount);

            session.getTransaction().commit();
            System.out.println("Update success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteGroupAccount(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            GroupAccount groupAccount = (GroupAccount) session.load(GroupAccount.class, id);
            session.delete(groupAccount);

            session.getTransaction().commit();
            System.out.println("Delete success !!");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isGroupAccountExistsByID(short id) {
        // get group account
        GroupAccount groupAccount = getGroupAccountById(id);

        // return result
        return groupAccount != null;
    }
}
