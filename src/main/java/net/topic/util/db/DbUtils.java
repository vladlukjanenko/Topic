package net.topic.util.db;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.H2Dialect;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.springframework.orm.jpa.vendor.Database;

/**
 * Util class for persistence configuration.
 *
 * @author Vlad Lukjanenko.
 */
public final class DbUtils {

    /**
     * Default constructor.
     * */
    private DbUtils () {

    }


    /**
     * Returns {@link Database} according to driver name.
     *
     * @param driverName    driver name.
     * @return {@link Database}.
     * */
    public static Database getDatabase(String driverName) {

        if (driverName.contains("h2")) {
            return Database.H2;
        }

        if (driverName.contains("postgresql")) {
            return Database.POSTGRESQL;
        }

        return Database.DEFAULT;
    }

    /**
     * Returns {@link Dialect} according to {@link Database}.
     * @param database  {@link Database}.
     * @return  {@link Class} instance for {@link Dialect}.
     * */
    public static Class<? extends Dialect> getHibernateDialect(Database database) {

        switch (database) {
            case H2:
                return H2Dialect.class;
            case POSTGRESQL:
                return PostgreSQL95Dialect.class;
            default:
                return PostgreSQL95Dialect.class;
        }
    }
}
