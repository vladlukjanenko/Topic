package net.topic.services;

import net.topic.entities.Author;
import net.topic.services.exceptions.AuthorServiceException;

import java.util.List;

/**
 * Defines all operations available on {@link Author}.
 *
 * @author Vlad Lukjanenko.
 */
public interface AuthorService extends BasicOperationsService<Author, Long> {

    Author create(Author entity) throws AuthorServiceException;

    Author update(Author entity) throws AuthorServiceException;

    boolean delete(Author entity);

    boolean deleteById(Long id) throws AuthorServiceException;

    void deleteAll();

    Author find(Long id) throws AuthorServiceException;

    List<Author> findAll();

    int count();
}
