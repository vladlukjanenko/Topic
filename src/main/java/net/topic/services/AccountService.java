package net.topic.services;

import net.topic.entities.Account;
import net.topic.services.exceptions.AccountServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Defines all operations available on {@link Account}.
 *
 * @author Vlad Lukjanenko.
 */
public interface AccountService extends BasicOperationsService<Account, Long> {

    Account create(Account entity) throws AccountServiceException;

    Account update(Account entity) throws AccountServiceException;

    boolean delete(Account entity);

    boolean deleteById(Long id) throws AccountServiceException;

    void deleteAll();

    Account find(Long id) throws AccountServiceException;

    List<Account> findAll();

    int count();
}
