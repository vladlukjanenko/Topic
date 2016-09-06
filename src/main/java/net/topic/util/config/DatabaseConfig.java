package net.topic.util.config;

import org.configureme.ConfigurationManager;
import org.configureme.annotations.ConfigureMe;
import org.configureme.annotations.DontConfigure;

/**
 * Provides values from configuration file for datasource configuration.
 *
 * @author Vlad Lukjanenko.
 */
@ConfigureMe(name = "database-config", allfields = true)
public class DatabaseConfig {

    /**
     * Database driver class.
     * */
    private String driverClassName;

    /**
     * Database connection url.
     * */
    private String url;

    /**
     * Database username.
     * */
    private String username;

    /**
     * Database password.
     * */
    private String password;

    /**
     * {@link DatabaseConfig} instance.
     * */
    @DontConfigure
    private static DatabaseConfig INSTANCE;


    /**
     * Default constructor.
     * */
    private DatabaseConfig() {
        ConfigurationManager.INSTANCE.configure(this);
    }


    /**
     * Returns {@link DatabaseConfig} instance.
     * */
    public static DatabaseConfig getInstance() {

        if (INSTANCE == null) {
            synchronized (DatabaseConfig.class) {
                INSTANCE = new DatabaseConfig();
            }
        }

        return INSTANCE;
    }


    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
