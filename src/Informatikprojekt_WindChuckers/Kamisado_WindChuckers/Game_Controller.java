package Informatikprojekt_WindChuckers.Kamisado_WindChuckers;

import Informatikprojekt_WindChuckers.ServiceLocator;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;import javafx.stage.Stage;

public class Game_Controller extends Application {
	
	final private Game_Model game_Model;
	final private Game_View game_View;
	ServiceLocator serviceLocator;
	private boolean vollbild = false;
	
	protected Game_Controller (Game_Model game_Model, Game_View game_View){
		this.game_Model = game_Model;
		this.game_View  = game_View; 
		TokenClicker tokenClicker = new TokenClicker(); // unser EventHandler f�r die Tokens
		
		
		// MenuBar
		game_View.getMenuItemExit().setOnAction(actionEvent-> Platform.exit());
		
		game_View.getMenuItemVollbild().setOnAction((event)->{
			if(vollbild){
				game_View.getPrimaryStage().setFullScreen(false);
				vollbild = false;
			} else {
			game_View.getPrimaryStage().setFullScreen(true);
			vollbild = true;
			}});
		
		// GameScene 
		game_Model.getPlayer1().setOnTurn(true); // Player 1 soll beginnen d�rfen
	
		// Tokens
		for(Token_Button p1 : game_View.getTokensP1()){
			p1.setOnAction(tokenClicker);}
		
		for(Token_Button p2 : game_View.getTokensP2()){
		p2.setOnAction(tokenClicker);}
		
		// Buttons
		game_View.getButtonPlay().setOnAction((event)->{
			game_View.getPrimaryStage().setScene(game_View.getSceneGame());
			game_View.getBorderpaneGame().setTop(game_View.getMenubar());
		});
		game_View.getButtonHauptmenue().setOnAction((event)->{
			game_View.getPrimaryStage().close();
			game_View.getBorderpaneStart().setTop(game_View.getMenubar());
			game_View.getPrimaryStage().setScene(game_View.getSceneStart());
			game_View.start();
		});
		game_View.getButtonRevanche().setOnAction((event)->{
			game_Model.revanche(game_View.getSpielfeld(),game_View.getTokensP1(),game_View.getTokensP2(),game_View.getSpielfelder());
			game_View.getStageRevanche().close();
		});
		
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		
		}

	// EventHandler f�r die Tokens //////////////////////////////////////////////////////////////////////////////////////////////////
	
	protected class TokenClicker implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event){
			Token_Button tokenClick = (Token_Button) event.getSource();
					
		if(game_Model.getPlayer1().isOnTurn()){	
			for(Token_Button p1: game_View.getTokensP1()){
				p1.setDisable(true);
				}
		
			// Alle m�glichen Felder f�r Player 1 sollen aktiv werden
			game_View.setSpielfelder(game_Model.getPossibleFieldsP1(tokenClick, game_View.getSpielfelder()));
			
			// Das aktive Token von Player 1 soll aktiv bleiben, sodass wir durch einen erneuten Klick die Auswahl aufheben k�nnen
			tokenClick.setDisable(false);
			
			// Sobald ein Token gew�hlt ist, sollen die Felder aktiviert werden
			for(Feld_Button f1: game_View.getSpielfelder()){
				f1.setOnAction((feldClicker)->{
					
				// Ist das erste Feld, welches wir ankliken, kann nicht r�ckg�ngig gemacht werden
				Feld_Button feldClick = (Feld_Button) feldClicker.getSource(); 
				
				// Unser Token wird auf das richtige Feld gesetzt. Die Attribute, Zeile, Spalte, Nummer werden alle aktualisiert. Das Feld ist nun besetzt. Das alte Feld wird frei.
				game_View.setSpielfeld(game_Model.changeFeld(tokenClick,feldClick,game_View.getSpielfeld(),game_View.getSpielfelder(),game_View.getLabelRevanche(),game_View.getStageRevanche()));	
				
				// Sobald das Token sein Feld gewechselt hat, ist der Zug zu Ende. Die Tokens dieses Spielers sollen deaktiviert und die des anderen aktiviert werden. Die Felder sollen ebenfalls alle deaktiviert werden.
				for(Token_Button T2 : game_View.getTokensP2()){
					T2.setDisable(true);
					if(T2.getColor().equalsIgnoreCase(feldClick.getColor())){
						T2.setDisable(false);
					}
				}
				
				for(Token_Button T1 : game_View.getTokensP1()){
					T1.setDisable(true);
				}
	
				for(Feld_Button F : game_View.getSpielfelder()){
					F.setDisable(true);
				}		
										
				});}
}
		
		if(game_Model.getPlayer2().isOnTurn()){	
			for(Token_Button p2: game_View.getTokensP2()){
				p2.setDisable(true);
				}
			
			// Alle m�glichen Felder f�r Player 1 sollen aktiv werden
			game_View.setSpielfelder(game_Model.getPossibleFieldsP2(tokenClick, game_View.getSpielfelder()));

			// Das aktive Token von Player 1 soll aktiv bleiben, sodass wir durch einen erneuten Klick die Auswahl aufheben k�nnen
			tokenClick.setDisable(false);
			
			// Sobald ein Token gew�hlt ist, sollen die Felder aktiviert werden
			for(Feld_Button f1: game_View.getSpielfelder()){
				f1.setOnAction((feldClicker)->{
					
				// Ist das erste Feld, welches wir ankliken, kann nicht r�ckg�ngig gemacht werden
				Feld_Button feldClick = (Feld_Button) feldClicker.getSource(); 
				
				// Unser Token wird auf das richtige Feld gesetzt. Die Attribute, Zeile, Spalte, Nummer werden alle aktualisiert. Das Feld ist nun besetzt. Das alte Feld wird frei.
				game_View.setSpielfeld(game_Model.changeFeld(tokenClick,feldClick,game_View.getSpielfeld(),game_View.getSpielfelder(),game_View.getLabelRevanche(),game_View.getStageRevanche()));
						
				// Sobald das Token sein Feld gewechselt hat, ist der Zug zu Ende. Die Tokens dieses Spielers sollen deaktiviert und die des anderen aktiviert werden
			
				for(Token_Button T1 : game_View.getTokensP1()){
					T1.setDisable(true);
					if(T1.getColor().equalsIgnoreCase(feldClick.getColor())){
						T1.setDisable(false);
					}
				}

				for(Token_Button T2 : game_View.getTokensP2()){
					T2.setDisable(true);
				}
				
				for(Feld_Button F : game_View.getSpielfelder()){
					F.setDisable(true);
				}		
				
				});}

			}
		}
	}
}


	

		
		






