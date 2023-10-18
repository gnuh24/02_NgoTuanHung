package Repository;

import java.util.List;
import entity.Position;
import entity.Position.PositionName;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Utils.HibernateUtils;

public class PositionRepository {
	private HibernateUtils hibernateUtils;
	
	public PositionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}
	
	@SuppressWarnings("unchecked")
	public List<Position> getAllPosition(){
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Query <Position> query = session.createQuery("FROM Position");
			
			return query.list();
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public Position getPositionByID(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Position position = session.get(Position.class, id);
			return position;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Position getPositionByName(PositionName name) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			Query <Position> query = session.createQuery("FROM Position WHERE PositionName = :positionName");
			query.setParameter("positionName", name);
			Position position = query.uniqueResult();
			return position;
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createPosition(Position position) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			session.save(position);
			System.out.println("Create success !!");
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updatePosition(short id, PositionName name) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			Position position = (Position) session.load(Position.class, id);
			
			position.setPositionName(name);
			
			
			session.getTransaction().commit();
			System.out.println("Update  success !!");
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updatePosition(Position position) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			session.beginTransaction();
			session.update(position);
			session.getTransaction().commit();
			System.out.println("Update success !!");
		}
		finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void deletePosition(short id) {
		Session session = null;
		try {
			session = hibernateUtils.openSession();
			
			session.beginTransaction();
			
			Position position = (Position) session.load(Position.class, id);
			
			session.delete(position);
			
			session.getTransaction().commit();
			
			System.out.println("Delete success !!");
		}
		finally {
			if (session != null) {
				session.close();
			}
		} 
	}
	
	public boolean isPositionExistsByID(short id) {

		// get department
		Position position = getPositionByID(id);

		// return result
		if (position == null) {
			return false;
		}

		return true;
	}

	public boolean isPositionExistsByUsername(PositionName name) {
		Position position = getPositionByName(name);

		if (position == null) {
			return false;
		}
		
		return true;
	}
	
	
}
