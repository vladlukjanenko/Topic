package net.topic.services;

import net.topic.config.PersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Integration test for {@link AccountService}.
 *
 * @author Vlad Lukjanenko.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;


    @Test
    public void testCreateAccount() throws Exception {

    }

    @Test
    public void testUpdateAccount() throws Exception {

    }

    @Test
    public void testDeleteAccount() throws Exception {

    }

    @Test
    public void testDeleteAccountById() throws Exception {

    }

    @Test
    public void testDeleteAllAccounts() throws Exception {

    }

    @Test
    public void testFindAccountById() throws Exception {

    }

    @Test
    public void testFindAllAccounts() throws Exception {

    }
}
