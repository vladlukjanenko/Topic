package net.topic.services;

import net.topic.config.PersistenceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Perform common config for all tests.
 *
 * @author Vlad Lukjanenko.
 */
@ContextConfiguration(classes = PersistenceConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BasicTestConfig {
}
