package pl.sda.bank.dao;

public interface GenericDao<T> {

    T findById(int id);
    void insertObject(T t);
    void deleteObject(T t);

}
