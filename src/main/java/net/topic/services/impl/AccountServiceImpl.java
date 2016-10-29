package net.topic.services.impl;

import net.topic.entities.Account;
import net.topic.services.AccountService;
import net.topic.services.exceptions.AccountServiceException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link AccountService}.
 *
 * @author Vlad Lukjanenko.
 */
@Service
@Repository
@Transactional
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Account create(Account entity) throws AccountServiceException {

        if (entity == null) {
            throw new AccountServiceException("Unable to create new account. Account is null");
        }

        entityManager.persist(entity);

        return entity;
    }

    @Override
    public Account update(Account entity) throws AccountServiceException {

        if (entity == null) {
            throw new AccountServiceException("Unable to update new account. Account is null");
        }

        return entityManager.merge(entity);
    }

    @Override
    public boolean delete(Account entity){

        if (entity == null) {
            return false;
        }

        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));

        if (entityManager.contains(entity)) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteById(Long id) throws AccountServiceException {

        if (id == null) {
            return false;
        }

        Account account = find(id);

        entityManager.remove(account);

        if (entityManager.contains(account)) {
            return false;
        }

        return true;
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }

    @Override
    public Account find(Long id) throws AccountServiceException {


        Account account = entityManager.find(Account.class, id);

        if (account == null) {
            throw new AccountServiceException("Unable to get account by id=" + id);
        }

        return account;
    }

    @Override
    public List<Account> findAll() {

        TypedQuery<Account> query = entityManager.createNamedQuery(Account.FIND_ALL_QUERY, Account.class);
        List<Account> accounts = query.getResultList();

        if (accounts == null) {
            return Collections.emptyList();
        }

        return accounts;
    }

    @Override
    public int count() {

        TypedQuery<Integer> query = entityManager.createNamedQuery(Account.COUNT_QUERY, Integer.class);

        return query.getSingleResult();
    }
}
