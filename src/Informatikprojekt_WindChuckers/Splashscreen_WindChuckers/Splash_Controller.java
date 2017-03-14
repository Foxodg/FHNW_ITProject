package Informatikprojekt_WindChuckers.Splashscreen_WindChuckers;

import Informatikprojekt_WindChuckers.ServiceLocator;
import Informatikprojekt_WindChuckers.Kamisado_WindChuckers.Game_Driver;
import javafx.concurrent.Worker;

public class Splash_Controller {
	
	final private Splash_Model splash_Model;
	final private Splash_View splash_View;
	final private Game_Driver game_Driver;
	
	ServiceLocator serviceLocator;
	
	public Splash_Controller(Splash_Model splash_Model, Splash_View splash_View, Game_Driver game_Driver){
		this.splash_Model = splash_Model;
		this.splash_View = splash_View;
		this.game_Driver = game_Driver;
		// We could monitor the progress property and pass it on to the progress bar
        // However, JavaFX can also do this for us: We just bind the progressProperty of the
        // progress bar to the progressProperty of the task.
        splash_View.getProgress().progressProperty().bind(splash_Model.initializer.progressProperty());

        // The stateProperty tells us the status of the task. When the state is SUCCEEDED,
        // the task is finished, so we tell the main program to continue.

        // Below are two equivalent implementations - only one of these should be used!
        
        // Using an anonymous class
//        model.initializer.stateProperty().addListener(
//                new ChangeListener<Worker.State>() {
//                    @Override
//                    public void changed(
//                            ObservableValue<? extends Worker.State> observable,
//                            Worker.State oldValue, Worker.State newValue) {
//                        if (newValue == Worker.State.SUCCEEDED)
//                            main.startApp();
//                    }
//                });
        
        // Using a lambda expression
        splash_Model.initializer.stateProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue == Worker.State.SUCCEEDED)
                        game_Driver.startGame();
                });
    }
}
