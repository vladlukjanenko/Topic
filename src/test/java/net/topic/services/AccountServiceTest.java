package net.topic.services;

import net.topic.entities.Account;
import net.topic.services.exceptions.AccountServiceException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.fail;

/**
 * Integration test for {@link AccountService}.
 *
 * @author Vlad Lukjanenko.
 */
public class AccountServiceTest extends BasicTestConfig {

    @Autowired
    private AccountService accountService;


    @Test
    public void testCreateAccount() {

        Account account = getAccount();
        Account created = null;

        try {
            created = accountService.create(account);
        } catch (AccountServiceException e) {
            fail();
        }

        assertThat(created.getAccountId(), is(not(0L)));
        assertThat(created.getEmail(), is(account.getEmail()));
        assertThat(created.getGender(), is(account.getGender()));
        assertThat(created.getUserName(), is(account.getUserName()));
    }

    @Test
    public void testUpdateAccount() {

        Account account = getAccount();
        Account created = null;
        Account updated = null;

        try {
            created = accountService.create(account);
        } catch (AccountServiceException e) {
            fail();
        }

        account.setUserName("NewTest");

        try {
            updated = accountService.update(account);
        } catch (AccountServiceException e) {
            fail();
        }

        assertThat(updated.getAccountId(), is(created.getAccountId()));
        assertThat(updated.getEmail(), is(account.getEmail()));
        assertThat(updated.getGender(), is(account.getGender()));
        assertThat(updated.getUserName(), is(account.getUserName()));
    }

    @Test
    public void testDeleteAccount() {

        Account account = getAccount();
        Account created = null;
        boolean deleted = false;

        try {
            created = accountService.create(account);
        } catch (AccountServiceException e) {
            fail();
        }

        deleted = accountService.delete(created);

        assertThat(deleted, is(true));
    }

    @Test
    public void testDeleteAccountById() {

        Account account = getAccount();
        Account created = null;
        boolean deleted = false;

        try {
            created = accountService.create(account);
            deleted = accountService.deleteById(created.getAccountId());
        } catch (AccountServiceException e) {
            fail();
        }

        assertThat(deleted, is(true));
    }

    @Test
    public void testFindAccountById() {

        Account account = getAccount();
        Account created = null;
        Account found = null;

        try {
            created = accountService.create(account);
            found = accountService.find(created.getAccountId());
        } catch (AccountServiceException e) {
            fail();
        }

        assertThat(found.getAccountId(), is(created.getAccountId()));
        assertThat(found.getEmail(), is(account.getEmail()));
        assertThat(found.getGender(), is(account.getGender()));
        assertThat(found.getUserName(), is(account.getUserName()));
    }

    @Test
    public void testFindAllAccounts() {

        Account account1 = getAccount();
        Account account2 = getAccount();
        Account createdAccount1 = null;
        Account createdAccount2 = null;

        account1.setUserName("Test1");
        account2.setUserName("Test2");

        try {
            createdAccount1 = accountService.create(account1);
            createdAccount2 = accountService.create(account2);
        } catch (AccountServiceException e) {
            fail();
        }

        List<Account> accounts = accountService.findAll();

        assertThat(accounts.size(), is(not(0)));
        assertThat(accounts, hasItem(createdAccount1));
        assertThat(accounts, hasItem(createdAccount2));
    }

    @Test
    public void testDeleteAllAccounts() {

        Account account1 = getAccount();
        Account account2 = getAccount();

        account1.setUserName("Test1");
        account2.setUserName("Test2");

        try {
            accountService.create(account1);
            accountService.create(account2);
        } catch (AccountServiceException e) {
            fail();
        }

        accountService.deleteAll();

        int size = accountService.findAll().size();

        assertThat(size, is(0));
    }


    private Account getAccount() {

        Account account = new Account();

        account.setAuthor(false);
        account.setEmail("test@account.com");
        account.setGender("Male");
        account.setUserName("Test");

        return account;
    }
}
