package com.rperezv365.util;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Config
 * <p>
 * Created by IntelliJ, Spring Framework Guru.
 *
 * @author architecture - pvraul
 * @version 04/07/2025 - 18:51
 * @since 1.17
 */
public class Config {

    private static final Logger log = LoggerFactory.getLogger(Config.class.getName());
    private static final String DEFAULT_PROPERTIES = "config/default.properties";
    private static Properties properties;

    public static void initialize() {
        // Load the default properties file
        properties = loadProperties();

        // check for amy overrides
        for (String key: properties.stringPropertyNames()) {
            if (System.getProperties().containsKey(key)) {
                log.info("Overriding property: {} with value: {}", key, System.getProperty(key));
                properties.setProperty(key, System.getProperty(key));
            }
        }

        // print
        log.info("Loaded properties:");
        log.info("-----------------");
        for (String key : properties.stringPropertyNames()) {
            log.info("{} = {}", key, properties.getProperty(key));
        }
        log.info("-----------------");
    }

    public static String get(String key) {
        if (properties == null) {
            initialize();
        }
        return properties.getProperty(key);
    }
    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream stream = ResourceLoader.getResource(DEFAULT_PROPERTIES)) {
            properties.load(stream);
        } catch (Exception e) {
            log.error("unable to read the property file: {}", DEFAULT_PROPERTIES, e);
        }

        return properties;
    }

}
