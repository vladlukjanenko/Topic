package net.topic.services;

import net.topic.services.exceptions.ServiceException;

import java.io.Serializable;
import java.util.List;

/**
 * Represents basic operation on entities.
 *
 * @author Vlad Lukjanenko.
 */
public interface BasicOperationsService<T, I extends Serializable> {

    /**
     * Creates object into database.
     *
     * @param entity    object to create in database.
     * @return  saved objects as instance  of T.
     * */
    T create(T entity) throws ServiceException;

    /**
     * Update existing object in database.
     *
     * @param entity    existing object to update in database.
     * @return  saved objects as instance  of T.
     * */
    T update(T entity) throws ServiceException;

    /**
     * Removes entity from database.
     *
     * @param entity    object to remove from database.
     * @return  true if object has been deleted.
     * */
    boolean delete(T entity);

    /**
     * Removes entity from database.
     *
     * @param id    id of object to remove from database.
     * @return  true if object has been deleted.
     * */
    boolean deleteById(I id) throws ServiceException;

    /**
     * Removes all entities from database.
     * */
    void deleteAll();

    /**
     * Gets entity from database by specified id.
     *
     * @param id    entity unique id.
     * @return  found object as instance of T.
     * */
    T find(I id) throws ServiceException;

    /**
     * Gets all entities from database.
     *
     * @return  list of  T.
     * */
    List<T> findAll();

    /**
     * Returns the number of elements in database.
     *
     * @return  the number of elements.
     * */
    int count();
}
