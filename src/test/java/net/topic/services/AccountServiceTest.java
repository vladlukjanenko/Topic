package net.topic.services;

import net.topic.entities.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

/**
 * Integration test for {@link AccountService}.
 *
 * @author Vlad Lukjanenko.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AccountServiceTest extends BasicTestConfig {

    @Autowired
    private AccountService accountService;


    @Test
    public void testCreateAccount() {

        Account account = getAccount();
        Account created = accountService.create(account).get();

        assertThat(created.getAccountId(), is(1L));
        assertThat(created.getEmail(), is(account.getEmail()));
        assertThat(created.getGender(), is(account.getGender()));
        assertThat(created.getUserName(), is(account.getUserName()));
    }

    @Test
    public void testUpdateAccount() {

        Account account = getAccount();
        Account created = accountService.create(account).get();

        account.setUserName("NewTest");

        Account updated = accountService.update(account).get();

        assertThat(updated.getAccountId(), is(created.getAccountId()));
        assertThat(updated.getEmail(), is(account.getEmail()));
        assertThat(updated.getGender(), is(account.getGender()));
        assertThat(updated.getUserName(), is(account.getUserName()));
    }

    @Test
    public void testDeleteAccount() {

        Account account = getAccount();
        Account created = accountService.create(account).get();
        boolean deleted = accountService.delete(created);

        assertThat(deleted, is(true));
    }

    @Test
    public void testDeleteAccountById() {

        Account account = getAccount();

        accountService.create(account);

        boolean deleted = accountService.deleteById(1L);

        assertThat(deleted, is(true));
    }

    @Test
    public void testFindAccountById() {

        Account account = getAccount();
        Account created = accountService.create(account).get();
        Account found = accountService.find(created.getAccountId()).get();

        assertThat(found.getAccountId(), is(created.getAccountId()));
        assertThat(found.getEmail(), is(account.getEmail()));
        assertThat(found.getGender(), is(account.getGender()));
        assertThat(found.getUserName(), is(account.getUserName()));
    }

    @Test
    public void testFindAllAccounts() {

        Account account1 = getAccount();
        Account account2 = getAccount();

        account1.setUserName("Test1");
        account2.setUserName("Test2");

        Account createdAccount1 = accountService.create(account1).get();
        Account createdAccount2 = accountService.create(account2).get();

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

        accountService.create(account1);
        accountService.create(account2);
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
