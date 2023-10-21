package Repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import entity.Address;
import Utils.HibernateUtils;

public class AddressRepository {
    private HibernateUtils hibernateUtils;

    public AddressRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Address> getAllAddresses() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Address> query = session.createQuery("FROM Address");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Address getAddressById(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Address address = session.get(Address.class, id);
            return address;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Address getAddressByName(String name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<Address> query = session.createQuery("FROM Address WHERE AddressName = :addressName");
            query.setParameter("addressName", name);
            Address address = query.uniqueResult();
            return address;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAddress(Address address) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.save(address);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAddress(short id, String name) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Address address = (Address) session.load(Address.class, id);
            address.setAddressName(name);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAddress(Address address) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.update(address);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteAddress(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            Address address = (Address) session.load(Address.class, id);
            session.delete(address);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isAddressExistsById(short id) {
        Address address = getAddressById(id);
        return address != null;
    }

    public boolean isAddressExistsByName(String name) {
        Address address = getAddressByName(name);
        return address != null;
    }
}
