package net.topic.services;

import net.topic.config.PersistenceConfig;
import org.springframework.test.context.ContextConfiguration;

/**
 * Perform common config for all tests.
 *
 * @author Vlad Lukjanenko.
 */
@ContextConfiguration(classes = PersistenceConfig.class)
public class BasicTestConfig {
}
