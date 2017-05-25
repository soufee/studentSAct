package main.model.dao;

import java.io.IOException;
import java.util.Collection;

/**
 *
 */
public interface DAO<PK, E> {

    Collection<E> getAll() throws IOException;

    E getById(PK id);

    void insert(E entity);

    void update(E entity);

    void delete(E entity);
}
