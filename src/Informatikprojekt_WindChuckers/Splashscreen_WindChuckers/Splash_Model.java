package Informatikprojekt_WindChuckers.Splashscreen_WindChuckers;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Informatikprojekt_WindChuckers.ServiceLocator;
import javafx.concurrent.Task;

public class Splash_Model {
	
	ServiceLocator serviceLocator;
	final Task<Void> initializer = new Task<Void>() {
	  
		@Override
	    protected Void call() throws Exception {
	
	        // First, take some time, update progress
	        Integer i = 0;
	        for (; i < 1000000000; i++) {
	            if ((i % 1000000) == 0)
	                this.updateProgress(i, 1000000000);
	        }
	
	        // Create the service locator to hold our resources
	        serviceLocator = ServiceLocator.getServiceLocator();
	
	        // Initialize the resources in the service locator
	        serviceLocator.setLogger(configureLogging());
	
	        // ... more resources would go here...
	
	        return null;
	        }
			};

	    public void initialize() {
	        new Thread(initializer).start();
	    }

	    /**
	     * We create a logger with the name of the application, and attach a file
	     * handler to it. All logging should be done using this logger. Messages to
	     * this logger will also flow up to the root logger, and from there to the
	     * console-handler.
	     * 
	     * We set the level of the console-handler to "INFO", so that the console
	     * only receives the more important messages. The levels of the loggers and
	     * the file-handler are set to "FINEST".
	     */
	    
	    private Logger configureLogging() {
	        Logger rootLogger = Logger.getLogger("");
	        rootLogger.setLevel(Level.FINEST);

	        // By default there is one handler: the console
	        Handler[] defaultHandlers = Logger.getLogger("").getHandlers();
	        defaultHandlers[0].setLevel(Level.INFO);

	        // Add our logger
	        Logger ourLogger = Logger.getLogger(serviceLocator.getGAME_NAME());
	        ourLogger.setLevel(Level.FINEST);
	        
	        // Add a file handler, putting the rotating files in the tmp directory
	        try {
	            Handler logHandler = new FileHandler("%t/"
	                    + serviceLocator.getGAME_NAME() + "_%u" + "_%g" + ".log",
	                    1000000, 9);
	            logHandler.setLevel(Level.FINEST);
	            ourLogger.addHandler(logHandler);
	        } catch (Exception e) { // If we are unable to create log files
	            throw new RuntimeException("Unable to initialize log files: "
	                    + e.toString());
	        }

	        return ourLogger;
	    }
	}



