package net.topic.services.impl;

import net.topic.entities.Account;
import net.topic.services.AccountService;
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
    public Optional<Account> create(Account entity) {

        if (entity == null) {
            return Optional.empty();
        }

        entityManager.persist(entity);

        return Optional.of(entity);
    }

    @Override
    public Optional<Account> update(Account entity) {

        if (entity == null) {
            return Optional.empty();
        }

        return Optional.ofNullable(entityManager.merge(entity));
    }

    @Override
    public boolean delete(Account entity) {

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
    public boolean deleteById(Long id) {

        if (id == null) {
            return false;
        }

        Optional<Account> account = find(id);

        if (!account.isPresent()) {
            return false;
        }

        entityManager.remove(account.get());

        if (entityManager.contains(account.get())) {
            return false;
        }

        return true;
    }

    @Override
    public void deleteAll() {
        findAll().forEach(this::delete);
    }

    @Override
    public Optional<Account> find(Long id) {

        Account account = entityManager.find(Account.class, id);

        if (account == null) {
            return Optional.empty();
        }

        return Optional.of(account);
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
