package main.model.dao;

import java.util.Collection;

/**
 *
 */
public interface DAO<PK, E> {

    Collection<E> getAll();

    E getById(PK id);

    PK insert(E entity);

    void update(E entity);

    void delete(E entity);
}
