package com.example.demo.User;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class Log4j {

    static{
        init();
    }

    private final static Logger logger = Logger.getLogger(Log4j.class);

    public static void main(String[] args) {

        logger.debug("My Debug Log");
        logger.info("My Info Log");
        logger.warn("My Warn Log");
        logger.error("My error log");
        logger.fatal("My fatal log");

    }

    /**
     * method to init log4j configurations
     */
    private static void init() {
        PropertyConfigurator.configure("resources/log4j.properties");
    }

}
