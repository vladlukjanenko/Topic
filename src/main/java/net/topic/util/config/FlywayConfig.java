package net.topic.util.config;

import org.configureme.ConfigurationManager;
import org.configureme.annotations.ConfigureMe;
import org.configureme.annotations.DontConfigure;

/**
 * Provides values from configuration file for datasource configuration.
 *
 * @author Vlad Lukjanenko.
 */
@ConfigureMe(name = "flyway-config", allfields = true)
public class FlywayConfig {

    /**
     * Flyway encoding.
     * */
    private String encoding;

    /**
     * Flyway migration scripts location.
     * */
    private String locations;

    /**
     * Flyway meta table.
     * */
    private String table;

    /**
     * {@link FlywayConfig} instance.
     * */
    @DontConfigure
    private static FlywayConfig INSTANCE;


    /**
     * Default constructor.
     * */
    private FlywayConfig() {
        ConfigurationManager.INSTANCE.configure(this);
    }


    /**
     * Returns {@link FlywayConfig} instance.
     * */
    public static FlywayConfig getInstance() {

        if (INSTANCE == null) {
            synchronized (FlywayConfig.class) {
                INSTANCE = new FlywayConfig();
            }
        }

        return INSTANCE;
    }


    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
