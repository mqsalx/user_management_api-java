// /src/main/java/com/usermanagement/utils/LoggerUtil.java

package com.usermanagement.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.*;

public class LoggerUtil {

    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    private static final String DEFAULT_LOG_LEVEL = "INFO";
    private static final String LOG_DIRECTORY = "logs";
    private static final String LOG_FILE_NAME = "usermanagement.log";

    static {
        configureLogger();
    }

    private static void configureLogger() {
        try {
            Files.createDirectories(Paths.get(LOG_DIRECTORY));

            Handler fileHandler = new FileHandler(LOG_DIRECTORY + "/" + LOG_FILE_NAME, true);
            Handler consoleHandler = new ConsoleHandler();

            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            consoleHandler.setFormatter(formatter);

            Level logLevel = getLogLevelFromEnv();
            logger.setLevel(logLevel);
            fileHandler.setLevel(logLevel);
            consoleHandler.setLevel(logLevel);

            logger.setUseParentHandlers(false);
            logger.addHandler(fileHandler);
            logger.addHandler(consoleHandler);

        } catch (IOException e) {
            System.err.println("Failed to set up logger: " + e.getMessage());
        }
    }

    private static Level getLogLevelFromEnv() {
        String level = System.getenv("LOG_LEVEL");
        if (level == null || level.isBlank()) {
            System.out.println("\u001B[33mLOG_LEVEL not set, using default: INFO\u001B[0m");
            return Level.INFO;
        }

        switch (level.toUpperCase()) {
            case "DEBUG" :
                return Level.FINE;
            case "INFO" :
                return Level.INFO;
            case "WARNING" :
                return Level.WARNING;
            case "ERROR" :
                return Level.SEVERE;
            case "CRITICAL" :
                return Level.SEVERE;
            default :
                System.out.println("\u001B[33mInvalid LOG_LEVEL: " + level + ", defaulting to INFO\u001B[0m");
                return Level.INFO;
        }
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }

    public static void error(String message) {
        logger.severe(message);
    }

    public static void debug(String message) {
        logger.fine(message);
    }

    private LoggerUtil() {
        // Utility class — prevent instantiation
    }
}
