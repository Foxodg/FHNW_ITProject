package Informatikprojekt_WindChuckers;

import java.util.logging.Logger;

public class ServiceLocator {
	   
		private static ServiceLocator serviceLocator; // singleton

	    // Globale Konstanten
	    final private String GAME_NAME = "Kamisado_WindChuckers";

	    // Resources
	    private Logger logger;

	    /**
	     * Factory method for returning the singleton
	     * @param mainClass The main class of this program
	     * @return The singleton resource locator
	     */
	    public static ServiceLocator getServiceLocator() {
	        if (serviceLocator == null)
	            serviceLocator = new ServiceLocator();
	        return serviceLocator;
	    }

	    /**
	     * Private constructor, because this class is a singleton
	     * @param appName Name of the main class of this program
	     */
	    private ServiceLocator() {
	        // Currently nothing to do here. We must define this constructor anyway,
	        // because the default constructor is public
	    }

	    public String getGAME_NAME() {
	        return GAME_NAME;
	    }

	    public Logger getLogger() {
	        return logger;
	    }

	    public void setLogger(Logger logger) {
	        this.logger = logger;
	    }
	}

