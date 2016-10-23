package net.topic.services;

import net.topic.entities.Account;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Defines all operations available on {@link Account}.
 *
 * @author Vlad Lukjanenko.
 */
public interface AccountService extends BasicOperationsService<Account, Long> {

    Optional<Account> create(Account entity);

    Optional<Account> update(Account entity);

    boolean delete(Account entity);

    boolean deleteById(Long id);

    void deleteAll();

    Optional<Account> find(Long id);

    List<Account> findAll();

    int count();
}
