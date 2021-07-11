package com.schlumberger.app.repositories;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class ConnectDataBaseSingleton {

    private static ConnectDataBaseSingleton INSTANCE;

    private static Logger log;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
        log =Logger.getLogger(ConnectDataBaseSingleton.class.getName());
    }

    private ConnectDataBaseSingleton() {
    }

    public static ConnectDataBaseSingleton getInstance() throws SQLException, IOException {
        if(INSTANCE == null) {
            INSTANCE = new ConnectDataBaseSingleton();

            Properties properties = new Properties();
            properties.load(ConnectDataBaseSingleton.class.getClassLoader().getResourceAsStream("application.properties"));

            Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
            log.info("Database connection test: " + connection.getCatalog());
            log.info("Database connection test: " + connection.getSchema());
        }

        return INSTANCE;
    }
}
