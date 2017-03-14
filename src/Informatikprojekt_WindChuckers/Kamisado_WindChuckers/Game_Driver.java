package Informatikprojekt_WindChuckers.Kamisado_WindChuckers;

import Informatikprojekt_WindChuckers.ServiceLocator;
import Informatikprojekt_WindChuckers.Splashscreen_WindChuckers.Splash_Controller;
import Informatikprojekt_WindChuckers.Splashscreen_WindChuckers.Splash_Model;
import Informatikprojekt_WindChuckers.Splashscreen_WindChuckers.Splash_View;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class Game_Driver extends Application{
	
	private static Game_Driver mainProgram;
	
	private Game_Model game_Model;
	private Game_View game_View;
	private Game_Controller game_Controller;
	private Splash_Model splash_Model;
	private Splash_View splash_View;
	private Splash_Controller splash_Controller;
	
	private ServiceLocator serviceLocator; // resources, after initialization
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	 /**
     * Note: This method is called on the main thread, not the JavaFX
     * Application Thread. This means that we cannot display anything to the
     * user at this point. Since we want to show a splash screen, this means
     * that we cannot do any real initialization here.
     * 
     * This implementation ensures that the application is a singleton; only one
     * per JVM-instance. On client installations this is not necessary (each
     * application runs in its own JVM). However, it can be important on server
     * installations.
     * 
     * Why is it important that only one instance run in the JVM? Because our
     * initialized resources are a singleton - if two programs instances were
     * running, they would use (and overwrite) each other's resources!
     */
	@Override
    public void init() {
        if (mainProgram == null) {
            mainProgram = this;
        } else {
            Platform.exit();
        }
    }
	
	/**
     * This method is called after init(), and is called on the JavaFX
     * Application Thread, so we can display a GUI. We have two GUIs: a splash
     * screen and the application. Both of these follow the MVC model.
     * 
     * We first display the splash screen. The model is where all initialization
     * for the application takes place. The controller updates a progress-bar in
     * the view, and (after initialization is finished) calls the startApp()
     * method in this class.
     */
	

	@Override
	public void start(Stage primaryStage) {
		splash_Model = new Splash_Model();
		splash_View = new Splash_View(primaryStage, splash_Model);
		splash_Controller = new Splash_Controller(splash_Model, splash_View, this);
		splash_View.start();
		splash_Model.initialize();

	}
	
	

	 /**
     * This method is called when the splash screen has finished initializing
     * the application. The initialized resources are in a ServiceLocator
     * singleton. Our task is to now create the application MVC components, to
     * hide the splash screen, and to display the application GUI.
     * 
     * Multitasking note: This method is called from an event-handler in the
     * Splash_Controller, which means that it is on the JavaFX Application
     * Thread, which means that it is allowed to work with GUI components.
     * http://docs.oracle.com/javafx/2/threads/jfxpub-threads.htm
     */
	
	public void startGame() {
		Stage gameStage = new Stage();

        // Initialize the application MVC components. Note that these components
        // can only be initialized now, because they may depend on the
        // resources initialized by the splash screen
		game_Model = new Game_Model();
		game_View = new Game_View(gameStage, game_Model);
		game_Controller = new Game_Controller(game_Model, game_View);

        // Resources are now initialized
        serviceLocator = ServiceLocator.getServiceLocator();

        // Close the splash screen, and set the reference to null, so that all
        // Splash_XXX objects can be garbage collected
        splash_View.stop();
        splash_View = null;

        game_View.start();
		
	}
	
	@Override
	public void stop(){
		if (game_View != null) {
            // Make the view invisible
           game_View.stop();
        }
        // More cleanup code as needed
        serviceLocator.getLogger().info("Application terminated");
    }
	
}


