package Repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import entity.*;

import Utils.HibernateUtils;

public class GroupRepository {
	private HibernateUtils hibernateUtils;
	
	public GroupRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Group> getAllGroup(){
	    Session session = null;
	    try {
	        session = hibernateUtils.openSession();
	        Query<Group> query = session.createQuery("FROM Group ");
	        return query.list();
	    }
	    finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}
	
	public Group getGroupByID(short id) {
		Session session = null;
	    try {
	        session = hibernateUtils.openSession();
	        Group groupResult = session.get(Group.class, id);
	        return groupResult;
	    }
	    finally {
	        if (session != null) {
	            session.close();
	        }
	    }
				
	}
	
	@SuppressWarnings("unchecked")
	public Group getGroupByName(String name) {
	    Session session = null;
	    try {
	        session = hibernateUtils.openSession();

	        Query<Group> query = session.createQuery("FROM Group WHERE groupName = :groupName");

	        query.setParameter("groupName", name);

	        Group groupResult = query.uniqueResult();
	        return groupResult;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}
	
	public void createGroup(Group newGroup) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(newGroup);
			System.out.println("Create success !!");

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public boolean isGroupExistsByID(short id) {

		Group group = getGroupByID(id);

		// return result
		if (group == null) {
			return false;
		}

		return true;
	}

	public boolean isGroupExistsByName(String name) {
		Group group = getGroupByName(name);

		if (group == null) {
			return false;
		}
		return true;
	}
	
	public void updateGroup(short id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Group group = (Group) session.load(Group.class, id);

			// update
			group.setGroupName(newName);
			
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateGroup(Group group) {

		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// update
			session.update(group);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteGroup(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			// get department
			Group group = (Group) session.load(Group.class, id);

			// delete
			session.delete(group);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
