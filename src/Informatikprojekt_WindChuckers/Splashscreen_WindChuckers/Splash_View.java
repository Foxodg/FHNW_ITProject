package Informatikprojekt_WindChuckers.Splashscreen_WindChuckers;

import Informatikprojekt_WindChuckers.ServiceLocator;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Splash_View {
	
	ServiceLocator serviceLocator;
	
	final private Stage primaryStage;
	final private Splash_Model splash_Model;
	private ProgressBar progress;
    private Label labelStatus;
    private Scene sceneSplashView;
	
	public Splash_View(Stage primaryStage,Splash_Model splash_Model){
		this.primaryStage=primaryStage;
		this.splash_Model=splash_Model;
		primaryStage.setTitle("Kamisado_WindChuckers");
		
		BorderPane borderPaneSplashScreen = new BorderPane();
	    borderPaneSplashScreen.setId("splashScreen");

        labelStatus = new Label("Status");
        borderPaneSplashScreen.setCenter(labelStatus);
        
        progress = new ProgressBar();
        HBox bottomBox = new HBox();
        bottomBox.setId("progressbox");
        bottomBox.getChildren().add(progress);
        borderPaneSplashScreen.setBottom(bottomBox);

        sceneSplashView = new Scene(borderPaneSplashScreen, 300, 300, Color.TRANSPARENT);
        sceneSplashView.getStylesheets().addAll(
        this.getClass().getResource("splash.css").toExternalForm());
        primaryStage.setScene(this.sceneSplashView);
		
	}

	protected ProgressBar getProgress() {
		return progress;
	}

	protected void setProgress(ProgressBar progress) {
		this.progress = progress;
	}

	 public void start() {
        primaryStage.show();
    }
    
    public void stop() {
    	primaryStage.hide();
    }
	

}
