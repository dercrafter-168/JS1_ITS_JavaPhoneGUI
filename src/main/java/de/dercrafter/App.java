package de.dercrafter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void master() {
        new JavaPhoneGUI();
        logger.info("started the Phone GUI class");
    }

}

