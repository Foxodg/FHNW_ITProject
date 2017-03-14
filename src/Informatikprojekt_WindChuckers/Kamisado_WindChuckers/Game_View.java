package Informatikprojekt_WindChuckers.Kamisado_WindChuckers;

import Informatikprojekt_WindChuckers.ServiceLocator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
	
public class Game_View {

	final private Game_Model game_Model;
	private Stage primaryStage;
	ServiceLocator serviceLocator;
	
	// StartScene 
	private Scene sceneStart;
	private BorderPane borderpaneStart;
	private Button play;
	private Label textStartseite;
	private VBox leftStartVBox;
	private VBox rightStartVBox;
	private HBox bottomStartHBox;
	private HBox centerStartHBox;
		
	// GameScene
	private Scene sceneGame;
	private BorderPane borderpaneGame;
	private Button hauptmenü;
	private VBox leftGameVBox;
	private VBox rightGameVBox;
	private HBox bottomGameHBox;
	private HBox topGameHBox;
	
	//Popup Fenster Revanche
	private Stage stageRevanche; 
	private Scene sceneRevanche;
	private BorderPane borderpaneRevanche;
	private Label labelRevanche;
	private Button buttonRevanche;
	private HBox HBoxBottomRevanche;
	
	// Spielbrett
	private GridPane spielfeld;
	private Feld_Button[] spielfelder;
	private Token_Button[] tokensP1;
	private Token_Button[] tokensP2;
		
	// Menubar
	private  MenuBar menubar;
	private  Menu file;
	private  Menu vollbild;
	private  MenuItem vollbildstarten;
	private  MenuItem exit;
	
	// Constructor
	protected Game_View(Stage primaryStage, Game_Model game_Model){
	this.setPrimaryStage(primaryStage);
	this.game_Model = game_Model;		
	primaryStage.setTitle("Kamisado_WindChuckers");
	
	// Menubar - für alle Scenes
	this.setMenubar(new MenuBar());
	this.getMenubar().prefWidthProperty().bind(primaryStage.widthProperty());
	
	file = new Menu("File");
	vollbild = new Menu("Vollbild");
	this.setMenuItemExit(new MenuItem("Exit"));
	this.setMenuItemVollbild(new MenuItem("Start"));
	
	vollbild.getItems().addAll(getMenuItemVollbild());
	file.getItems().addAll(getMenuItemExit());
	this.getMenubar().getMenus().addAll(file,vollbild);
	
	// Spielbrett erstellen
	spielfelder = game_Model.getFelder();
	tokensP1 = game_Model.getTokensP1();
	tokensP2= game_Model.getTokensP2();
	spielfeld = new GridPane();
	spielfeld = game_Model.spielfeldFüllen(spielfeld,spielfelder,tokensP1,tokensP2);
	spielfeld.setAlignment(Pos.CENTER);
	spielfeld.setPadding(new Insets(50,0,0,0));
		
	// GameScene
	this.setBorderpaneGame(new BorderPane());
	this.getBorderpaneGame().setId("borderpaneGame");

	leftGameVBox = new VBox();
	rightGameVBox = new VBox();
	bottomGameHBox = new HBox();
	
	this.setButtonHauptmenü(new Button("Hauptmenü"));
	this.getButtonHauptmenü().setId("buttonMenu");
	bottomGameHBox.getChildren().add(getButtonHauptmenü());
	this.getButtonHauptmenü().setAlignment(Pos.CENTER);
	bottomGameHBox.setAlignment(Pos.CENTER);
	bottomGameHBox.setPadding(new Insets(50,0,50,0));
	
	this.getBorderpaneGame().setTop(this.getMenubar());
	this.getBorderpaneGame().setBottom(bottomGameHBox);
	this.getBorderpaneGame().setLeft(leftGameVBox);
	this.getBorderpaneGame().setRight(rightGameVBox);
	this.getBorderpaneGame().setCenter(spielfeld);
	
	// Popup Fenster Revanche
	this.setStageRevanche(new Stage());
	this.getStageRevanche().setAlwaysOnTop(true);
	this.getStageRevanche().setMinWidth(500);
	this.getStageRevanche().setMinHeight(500);
	this.getStageRevanche().initStyle(StageStyle.TRANSPARENT);
	this.getStageRevanche().setResizable(false);
	this.getStageRevanche().getIcons().add(new Image(getClass().getResourceAsStream("logo.jpg")));
	
	this.setBorderPaneRevanche(new BorderPane());
	this.setSceneRevanche(new Scene(this.getBorderPaneRevanche()));
	this.getStageRevanche().setScene(this.getSceneRevanche());
	
	this.setButtonRevanche(new Button("Revanche"));
	this.getButtonRevanche().setAlignment(Pos. CENTER );
	this.getButtonRevanche().setId("buttonRevanche");
	
	this.setHBoxRevancheBottom(new HBox());
	this.getHBoxRevancheBottom().setAlignment(Pos. CENTER );
	this.getHBoxRevancheBottom().getChildren().add(this.getButtonRevanche());
	this.getHBoxRevancheBottom().setPadding(new Insets(0,0,20,0));
		
	this.setLabelRevanche(new Label("Player ? hat gewonnen"));
	this.getLabelRevanche().setId("labelRevanche");
	
	this.getBorderPaneRevanche().setBottom(this.getHBoxRevancheBottom());
	this.getBorderPaneRevanche().setCenter(this.getLabelRevanche());

	// StartScene
	this.setBorderpaneStart(new BorderPane());
	this.getBorderpaneStart().setId("borderpaneStart");
	
	centerStartHBox = new HBox();	
	leftStartVBox = new VBox();
	rightStartVBox = new VBox();
	bottomStartHBox = new HBox();
			
	textStartseite = new Label ("Herzlich Willkommen\nWas möchten Sie tun?");
	textStartseite.setId("textStartseite"); 
	textStartseite.setTextAlignment(TextAlignment.CENTER);
	centerStartHBox.getChildren().add(textStartseite);
	centerStartHBox.setAlignment(Pos.CENTER);
			
	this.setButtonPlay(new Button("Play"));
	this.getButtonPlay().setId("buttonPlay");
	bottomStartHBox.getChildren().add(getButtonPlay());
	bottomStartHBox.setAlignment(Pos.CENTER);
	bottomStartHBox.setPadding(new Insets(0,0,250,0));
			
	this.getBorderpaneStart().setLeft(leftStartVBox);
	this.getBorderpaneStart().setRight(rightStartVBox);
	this.getBorderpaneStart().setCenter(centerStartHBox);
	this.getBorderpaneStart().setBottom(bottomStartHBox);
	this.getBorderpaneStart().setTop(this.getMenubar());
			
	// Scene Zuweisung
	
	this.setSceneStart(new Scene(this.getBorderpaneStart()));
	this.getSceneStart().getStylesheets().add(getClass().getResource("Stylesheet.css").toExternalForm());
	this.setSceneGame(new Scene(this.getBorderpaneGame()));
	this.getSceneGame().getStylesheets().add(getClass().getResource("Stylesheet.css").toExternalForm());
	
	this.getSceneRevanche().getStylesheets().add(getClass().getResource("Stylesheet.css").toExternalForm());
	
	
	// Allgemeine Einstellungen

	this.getPrimaryStage().setMinWidth(800);
	this.getPrimaryStage().setMinHeight(600);
	this.getPrimaryStage().setResizable(false);
	this.getPrimaryStage().getIcons().add(new Image(getClass().getResourceAsStream("logo.jpg")));
	this.getPrimaryStage().sizeToScene();
	this.getPrimaryStage().setScene(this.getSceneStart());
}

	
	public void start() {
		this.getPrimaryStage().show();
	}
	
	public void stop() {
		this.getPrimaryStage().hide();
	}

	// Getter und Setter
	
	protected Feld_Button[] getSpielfelder(){
		return this.spielfelder;
	}

	protected void setSpielfelder(Feld_Button[] spielfelder){
		this.spielfelder=spielfelder;
	}
	
	protected Token_Button[] getTokensP1(){
		return this.tokensP1;
	}
	
	protected void setTokensP1(Token_Button[] tokensP1){
		this.tokensP1=tokensP1;
	}
	
	protected Token_Button[] getTokensP2(){
		return this.tokensP2;
	}
	
	protected void setTokensP2(Token_Button[] tokensP2){
		this.tokensP1=tokensP2;
	}
	
	protected GridPane getSpielfeld(){
		return this.spielfeld;
	}
	
	protected void setSpielfeld(GridPane spielfeld){
		this.spielfeld=spielfeld;
	}


	public MenuItem getMenuItemExit() {
		return exit;
	}


	public void setMenuItemExit(MenuItem exit) {
		this.exit = exit;
	}


	public MenuItem getMenuItemVollbild() {
		return vollbildstarten;
	}


	public void setMenuItemVollbild(MenuItem vollbildstarten) {
		this.vollbildstarten = vollbildstarten;
	}


	public Stage getPrimaryStage() {
		return primaryStage;
	}


	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}


	public Button getButtonHauptmenü() {
		return hauptmenü;
	}


	public void setButtonHauptmenü(Button hauptmenü) {
		this.hauptmenü = hauptmenü;
	}


	public BorderPane getBorderpaneStart() {
		return borderpaneStart;
	}


	public void setBorderpaneStart(BorderPane borderpaneStart) {
		this.borderpaneStart = borderpaneStart;
	}


	public MenuBar getMenubar() {
		return menubar;
	}


	public void setMenubar(MenuBar menubar) {
		this.menubar = menubar;
	}


	public Button getButtonPlay() {
		return play;
	}


	public void setButtonPlay(Button play) {
		this.play = play;
	}


	public Scene getSceneGame() {
		return sceneGame;
	}


	public void setSceneGame(Scene sceneGame) {
		this.sceneGame = sceneGame;
	}


	public BorderPane getBorderpaneGame() {
		return borderpaneGame;
	}


	public void setBorderpaneGame(BorderPane borderpaneGame) {
		this.borderpaneGame = borderpaneGame;
	}


	public Scene getSceneStart() {
		return sceneStart;
	}


	public void setSceneStart(Scene sceneStart) {
		this.sceneStart = sceneStart;
	}


	public Stage getStageRevanche() {
		return stageRevanche;
	}


	public void setStageRevanche(Stage stageGameOver) {
		this.stageRevanche = stageGameOver;
	}


	public Scene getSceneRevanche() {
		return sceneRevanche;
	}


	public void setSceneRevanche(Scene sceneGameOver) {
		this.sceneRevanche = sceneGameOver;
	}


	public BorderPane getBorderPaneRevanche() {
		return borderpaneRevanche;
	}


	public void setBorderPaneRevanche(BorderPane borderPaneGameOver) {
		this.borderpaneRevanche = borderPaneGameOver;
	}


	public Label getLabelRevanche() {
		return labelRevanche;
	}


	public void setLabelRevanche(Label labelGameOver) {
		this.labelRevanche = labelGameOver;
	}


	public Button getButtonRevanche() {
		return buttonRevanche;
	}


	public void setButtonRevanche(Button buttonRevanche) {
		this.buttonRevanche = buttonRevanche;
	}


	public HBox getHBoxRevancheBottom() {
		return HBoxBottomRevanche;
	}


	public void setHBoxRevancheBottom(HBox bottomRevancheHBox) {
		this.HBoxBottomRevanche = bottomRevancheHBox;
	}
	
}