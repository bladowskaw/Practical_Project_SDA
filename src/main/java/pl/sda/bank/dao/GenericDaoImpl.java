package pl.sda.bank.dao;

import org.hibernate.Session;
import pl.sda.bank.util.HibernateUtil;

public class GenericDaoImpl<T> implements GenericDao<T> {

    private Class<T> entityClass;

    public GenericDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T findById(int id) {
        Session session = openSession();
        T result = session.find(entityClass, id);
        session.close();
        return result;
    }


    @Override
    public void insertObject(T t) {
        Session session = openSession();
        session.beginTransaction();
        session.persist(t);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteObject(T t) {
        Session session = openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();

    }
}
