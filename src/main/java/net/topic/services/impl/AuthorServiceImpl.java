package net.topic.services.impl;

import net.topic.entities.Author;
import net.topic.services.AuthorService;
import net.topic.services.exceptions.AuthorServiceException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of {@link AuthorService}.
 *
 * @author Vlad Lukjanenko.
 */
@Service
@Repository
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Author create(Author entity) throws AuthorServiceException {

        if (entity == null) {
            throw new AuthorServiceException("Unable to create new author record. Entity is null");
        }

        entityManager.persist(entity);

        return entity;
    }

    @Override
    public Author update(Author entity) throws AuthorServiceException {

        if (entity == null) {
            throw new AuthorServiceException("Unable to update author record. Entity is null");
        }

        return entityManager.merge(entity);
    }

    @Override
    public boolean delete(Author entity) {

        if (entity == null) {
            return false;
        }

        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));

        return !entityManager.contains(entity);
    }

    @Override
    public boolean deleteById(Long id) throws AuthorServiceException {

        if (id == null) {
            return false;
        }

        Author Author = find(id);

        entityManager.remove(Author);

        if (entityManager.contains(Author)) {
            return false;
        }

        return true;
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }

    @Override
    public Author find(Long id) throws AuthorServiceException {


        Author Author = entityManager.find(Author.class, id);

        if (Author == null) {
            throw new AuthorServiceException("Unable to get Author by id=" + id);
        }

        return Author;
    }

    @Override
    public List<Author> findAll() {

        TypedQuery<Author> query = entityManager.createNamedQuery(Author.FIND_ALL_QUERY, Author.class);
        List<Author> Authors = query.getResultList();

        if (Authors == null) {
            return Collections.emptyList();
        }

        return Authors;
    }

    @Override
    public int count() {

        TypedQuery<Integer> query = entityManager.createNamedQuery(Author.COUNT_QUERY, Integer.class);

        return query.getSingleResult();
    }
}
