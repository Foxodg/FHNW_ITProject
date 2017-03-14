package Informatikprojekt_WindChuckers.Kamisado_WindChuckers;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.Queue;
import Informatikprojekt_WindChuckers.ServiceLocator;

public class Game_Model {
	
	ServiceLocator serviceLocator;
	protected static int anzahlFelderTotal = 64;
	protected static int anzahlFelderJeFarbe = 8;
	protected static int anzahlTokensJeSpieler = 8;
	private Player player1 = new Player(1);
	private Player player2 = new Player(2);
	protected static int lastWinner = 0;
	

	// Wir holen 8 Felder pro Farbe und fuellen diese in der richtigen Reihenfolge in ein Array ab
	protected Feld_Button[] getFelder(){
		
		Queue<Feld_Button> orange = new LinkedList<Feld_Button>();
		orange = this.getOrangeFelder();
		Queue<Feld_Button> blau = new LinkedList<Feld_Button>();
		blau = this.getBlaueFelder();
		Queue<Feld_Button> violet = new LinkedList<Feld_Button>();
		violet = this.getVioletteFelder();
		Queue<Feld_Button> pink = new LinkedList<Feld_Button>();
		pink = this.getPinkeFelder();
		Queue<Feld_Button> gelb = new LinkedList<Feld_Button>();
		gelb = this.getGelbeFelder();
		Queue<Feld_Button> rot = new LinkedList<Feld_Button>();
		rot = this.getRoteFelder();
		Queue<Feld_Button> gruen = new LinkedList<Feld_Button>();
		gruen = this.getGrueneFelder();
		Queue<Feld_Button> braun = new LinkedList<Feld_Button>();
		braun = this.getBrauneFelder();

		Feld_Button[]Felder = new Feld_Button[Game_Model.anzahlFelderTotal];
	
		// orange 
		Felder[0] =orange.poll();
		Felder[9] =orange.poll();
		Felder[18] =orange.poll();
		Felder[27] =orange.poll();
		Felder[36] =orange.poll();
		Felder[45] =orange.poll();
		Felder[54] =orange.poll();
		Felder[63] =orange.poll();
		
		// blau
		Felder[1]  = blau.poll();
		Felder[12] = blau.poll();
		Felder[23] = blau.poll();
		Felder[26] = blau.poll();
		Felder[37] = blau.poll();
		Felder[40] = blau.poll();
		Felder[51] = blau.poll();
		Felder[62] = blau.poll();
		
		// violet
		Felder[2]  = violet.poll();
		Felder[15] = violet.poll();
		Felder[20] = violet.poll();
		Felder[25] = violet.poll();
		Felder[38] = violet.poll();
		Felder[43] = violet.poll();
		Felder[48] = violet.poll();
		Felder[61] = violet.poll();
		
		// pink
		Felder[3]=pink.poll();
		Felder[10]=pink.poll();
		Felder[17]=pink.poll();
		Felder[24]=pink.poll();
		Felder[39]=pink.poll();
		Felder[46]=pink.poll();
		Felder[53]=pink.poll();
		Felder[60]=pink.poll();
		
		// gelb
		Felder[4]= gelb.poll();
		Felder[13]=gelb.poll();
		Felder[22]=gelb.poll();
		Felder[31]=gelb.poll();
		Felder[32]=gelb.poll();
		Felder[41]=gelb.poll();
		Felder[50]=gelb.poll();
		Felder[59]=gelb.poll();
		
		// rot
		Felder[5]=rot.poll();
		Felder[8]=rot.poll();
		Felder[19]=rot.poll();
		Felder[30]=rot.poll();
		Felder[33]=rot.poll();
		Felder[44]=rot.poll();
		Felder[55]=rot.poll();
		Felder[58]=rot.poll();
		
		// gruen
		Felder[6]=gruen.poll();
		Felder[11]=gruen.poll();
		Felder[16]=gruen.poll();
		Felder[29]=gruen.poll();
		Felder[34]=gruen.poll();
		Felder[47]=gruen.poll();
		Felder[52]=gruen.poll();
		Felder[57]=gruen.poll();
		
		// braun
		Felder[7]=braun.poll();
		Felder[14]=braun.poll();
		Felder[21]=braun.poll();
		Felder[28]=braun.poll();
		Felder[35]=braun.poll();
		Felder[42]=braun.poll();
		Felder[49]=braun.poll();
		Felder[56]=braun.poll();
	
		for(int i = 0; i<8; i++){
			Felder[i].setEmpty(false);
		}
		for(int i = 56; i<64; i++){
			Felder[i].setEmpty(false);
		}
		
		return Felder;
			}
	
	// Die Spielfiguren von Player 1 werden in einem Array zurueckgeben	
	protected Token_Button[] getTokensP1(){
		Token_Button[] tokens1Temp = new Token_Button[Game_Model.anzahlTokensJeSpieler];
		Token_Button[] tokensP1P2Temp = this.getTokensP1P2();
		
		for(int i = 0; i<Game_Model.anzahlTokensJeSpieler; i++){
			tokensP1P2Temp[i].setPlayer(1);
			tokens1Temp[i]=tokensP1P2Temp[i];
		}
		
		return tokens1Temp;
		}

	// Die Spielfiguren von Player 2 werden in einem Array zurueckgeben 
	protected Token_Button[] getTokensP2(){
			Token_Button[] tokens2Temp = new Token_Button[Game_Model.anzahlTokensJeSpieler];
			Token_Button[] tokensP1P2Temp = this.getTokensP1P2();
			
			for(int i = 7; i>=Game_Model.anzahlTokensJeSpieler-Game_Model.anzahlTokensJeSpieler; i--){
				tokensP1P2Temp[i].setPlayer(2);
				tokens2Temp[i]=tokensP1P2Temp[i];
			}
			return tokens2Temp;
			}

	// Wir erstellen 8 Tokens mit je einer Farbe, welche von Player1 und Player2 genutzt werden
	protected Token_Button[] getTokensP1P2(){
		Token_Button[] tokensP1P2Temp = new Token_Button[Game_Model.anzahlTokensJeSpieler];
		
		Token_Button tokenOrange = new Token_Button("orange");
		tokenOrange.setStyle(" -fx-background-color: #FF8C00;");
		tokensP1P2Temp[0] = tokenOrange;
		
		Token_Button tokenBlau = new Token_Button("blau");
		tokenBlau.setStyle(" -fx-background-color: #4169E1;");
		tokensP1P2Temp[1] = tokenBlau;
		
		Token_Button tokenViolet = new Token_Button("violet");
		tokenViolet.setStyle(" -fx-background-color: #663399;");
		tokensP1P2Temp[2] = tokenViolet;
		
		Token_Button tokenPink = new Token_Button("pink");
		tokenPink.setStyle(" -fx-background-color: #FF69B4;");
		tokensP1P2Temp[3] = tokenPink;
		
		Token_Button tokenGelb = new Token_Button("gelb");
		tokenGelb.setStyle(" -fx-background-color: #FFD700;");
		tokensP1P2Temp[4] = tokenGelb;
		
		Token_Button tokenRot = new Token_Button("rot");
		tokenRot.setStyle(" -fx-background-color: #B22222;");
		tokensP1P2Temp[5] = tokenRot;
		
		Token_Button tokenGruen = new Token_Button("gruen");
		tokenGruen.setStyle(" -fx-background-color: #008000;");
		tokensP1P2Temp[6] = tokenGruen;
		
		Token_Button tokenBraun = new Token_Button("braun");
		tokenBraun.setStyle(" -fx-background-color: #8B4513;");
		tokensP1P2Temp[7] = tokenBraun;
		
		return tokensP1P2Temp;
					}

	// Hilfmethoden fuer die einzelnen Felder - pro Farbe werden 8 Felder generiert
	protected Queue<Feld_Button> getOrangeFelder(){
		Queue<Feld_Button> orangeFelder= new LinkedList<Feld_Button>();
		for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
			Feld_Button orangeButton = new Feld_Button("orange");
			orangeButton.setStyle(" -fx-background-color: #FF8C00;");
			orangeButton.setId("spielFelder");
			orangeFelder.offer(orangeButton);
		}
			return orangeFelder;
	}
	protected Queue<Feld_Button> getBlaueFelder(){
		Queue<Feld_Button> blaueFelder= new LinkedList<Feld_Button>();
		for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
			Feld_Button blauerButton = new Feld_Button("blau");
			blauerButton.setStyle(" -fx-background-color: #4169E1;");
			blauerButton.setId("spielFelder");
			blaueFelder.offer(blauerButton);
		}
			return blaueFelder;
	}
	protected Queue<Feld_Button> getVioletteFelder(){
		Queue<Feld_Button> violetteFelder= new LinkedList<Feld_Button>();
			for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
				Feld_Button violetterButton = new Feld_Button("violet");
				violetterButton.setStyle(" -fx-background-color: #663399;");
				violetterButton.setId("spielFelder");
				violetteFelder.offer(violetterButton);
			}
				return violetteFelder;
			
		}
	protected Queue<Feld_Button> getPinkeFelder(){
		Queue<Feld_Button> pinkeFelder= new LinkedList<Feld_Button>();
			for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
				Feld_Button pinkerButton = new Feld_Button("pink");
				pinkerButton.setStyle(" -fx-background-color: #FF69B4;");
				pinkerButton.setId("spielFelder");
				pinkeFelder.offer(pinkerButton);
			}
				return pinkeFelder;
			
		}
	protected Queue<Feld_Button> getGelbeFelder(){
		Queue<Feld_Button> gelbeFelder= new LinkedList<Feld_Button>();
			for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
				Feld_Button gelberButton = new Feld_Button("gelb");
				gelberButton.setStyle(" -fx-background-color: #FFD700;");
				gelberButton.setId("spielFelder");
				gelbeFelder.offer(gelberButton);
			}
				return gelbeFelder;
			
		}
	protected Queue<Feld_Button> getRoteFelder(){
		Queue<Feld_Button> roteFelder= new LinkedList<Feld_Button>();
			for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
				Feld_Button roterButton = new Feld_Button("rot");
				roterButton.setStyle(" -fx-background-color: #B22222;");
				roterButton.setId("spielFelder");
				roteFelder.offer(roterButton);
			}
				return roteFelder;
			
		}
	protected Queue<Feld_Button> getGrueneFelder(){
		Queue<Feld_Button> grueneFelder= new LinkedList<Feld_Button>();
			for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
				Feld_Button gruenerButton = new Feld_Button("gruen");
				gruenerButton.setStyle(" -fx-background-color: #008000;");
				gruenerButton.setId("spielFelder");
				grueneFelder.offer(gruenerButton);
			}
				return grueneFelder;
			
		}
	protected Queue<Feld_Button> getBrauneFelder(){
		Queue<Feld_Button> brauneFelder= new LinkedList<Feld_Button>();
		for(int i=0; i <= Game_Model.anzahlFelderJeFarbe; i++){
			Feld_Button braunerButton = new Feld_Button("braun");
			braunerButton.setStyle(" -fx-background-color: #8B4513;");
			braunerButton.setId("spielFelder");
			brauneFelder.offer(braunerButton);
		}
			return brauneFelder;
	}

	// Mit dieser Methode fuellen wir das Spielfeld vom View in der richtigen Reihenfolge auf
	protected GridPane spielfeldFuellen(GridPane spielfeld, Feld_Button[] spielfelder, Token_Button[] tokensP1, Token_Button[] tokensP2) {
		
		int counter = 0; 
		for(int zeile = 1; zeile<=Game_Model.anzahlFelderJeFarbe; zeile++){
			for(int spalte = 1; spalte<=Game_Model.anzahlFelderJeFarbe; spalte++){
				spielfelder[counter].setZeile(zeile);
				spielfelder[counter].setSpalte(spalte);
				spielfelder[counter].setNumber(counter);
				spielfelder[counter].setDisable(false);
				spielfeld.add(spielfelder[counter], spielfelder[counter].getSpalte(),spielfelder[counter].getZeile());
				counter++;
			}
		}	
		
		// Spielbrett mit Tokens abfuellen ///////////////////////////////////////////////////////////////////////////
		
		for(int i = 0; i<Game_Model.anzahlFelderJeFarbe;i++){
			tokensP1[i].setZeile(1);
			tokensP1[i].setSpalte(i+1);
			tokensP1[i].setNumber(i);
			tokensP1[i].setPlayer(1);
			tokensP1[i].setId("tokensP1");
			GridPane.setHalignment(tokensP1[i], HPos.CENTER);
			spielfeld.add(tokensP1[i], tokensP1[i].getSpalte(), tokensP1[i].getZeile());
		}
		
		for(int i = 0; i<Game_Model.anzahlFelderJeFarbe;i++){
			tokensP2[i].setZeile(Game_Model.anzahlTokensJeSpieler);
			tokensP2[i].setSpalte(8-i);
			tokensP2[i].setPlayer(2);
			tokensP2[i].setNumber(Game_Model.anzahlFelderTotal-1-i);
			tokensP2[i].setId("tokensP2");
			tokensP2[i].setDisable(true);
			GridPane.setHalignment(tokensP2[i], HPos.CENTER);
			spielfeld.add(tokensP2[i], tokensP2[i].getSpalte(), tokensP2[i].getZeile());
		}
		return spielfeld;
	}

	// Macht alle möglichen Spielzuege fuer Player 1 sichtbar
	protected Feld_Button[] getPossibleFieldsP1(Token_Button token_Button, Feld_Button[] spielfeld) {

		// Zuerst deaktivieren wir alle Felder
		for(Feld_Button F : spielfeld){
			F.setDisable(true);
		}
		
		// Wir aktivieren alle Felder, welche fuer einen Vorwärtszug erlaubt sind
		for(int i = token_Button.getNumber(); i<Game_Model.anzahlFelderTotal; i++){
			if(spielfeld[i].isEmpty() && spielfeld[i].getNumber()>token_Button.getNumber() && spielfeld[i].getSpalte()==token_Button.getSpalte()){
				spielfeld[i].setDisable(false);
			} if(!spielfeld[i].isEmpty() && spielfeld[i].getNumber()>token_Button.getNumber() && spielfeld[i].getSpalte()==token_Button.getSpalte()){
				break;
			}
		}
	
		// Wir aktivieren alle Felder, welche fuer einen Diagonalzug erlaubt sind
		
		// Diagonal nach rechts unten
		outerloop:
		for(int i = token_Button.getNumber(); i<Game_Model.anzahlFelderTotal; i++){
			for(int j=1; j<8; j++){
				if(spielfeld[i].isEmpty() && spielfeld[i].getNumber()>token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()+(j*9) && spielfeld[i].getSpalte()<=8 && spielfeld[i].getSpalte()>token_Button.getSpalte()){
					spielfeld[i].setDisable(false);
				} if(!spielfeld[i].isEmpty() && spielfeld[i].getNumber()>token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()+(j*9) && spielfeld[i].getSpalte()<=8 && spielfeld[i].getSpalte()>token_Button.getSpalte()){
					break outerloop;
				}
			}
		}

		// Diagonal nach links unten
		outerloop:
		for(int i = token_Button.getNumber(); i<Game_Model.anzahlFelderTotal; i++){
			for(int j=1; j<8; j++){
				if(spielfeld[i].isEmpty() && spielfeld[i].getNumber()>token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()+(j*7) && spielfeld[i].getSpalte() >= 1 && spielfeld[i].getSpalte()<token_Button.getSpalte() ){
					spielfeld[i].setDisable(false);
				} if(!spielfeld[i].isEmpty() && spielfeld[i].getNumber()>token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()+(j*7) && spielfeld[i].getSpalte() >= 1 && spielfeld[i].getSpalte()<token_Button.getSpalte() ){
					break outerloop;
				}
			}
		}
		return spielfeld;
	}

	// Macht alle möglichen Spielzuege fuer Player 2 sichtbar
	protected Feld_Button[] getPossibleFieldsP2(Token_Button token_Button, Feld_Button[] spielfeld) {
		
		// Zuerst deaktivieren wir alle Felder
		for(Feld_Button F : spielfeld){
			F.setDisable(true);
		}
		
		// Wir aktivieren alle Felder, welche fuer einen Vorwärtszug erlaubt sind
		for(int i = token_Button.getNumber(); i>=0; i--){
			if(spielfeld[i].isEmpty() && spielfeld[i].getNumber()<token_Button.getNumber() && spielfeld[i].getSpalte()==token_Button.getSpalte()){
				spielfeld[i].setDisable(false);
			} if(!spielfeld[i].isEmpty() && spielfeld[i].getNumber()<token_Button.getNumber() && spielfeld[i].getSpalte()==token_Button.getSpalte()){
				break;
			}
		}
	
		// Wir aktivieren alle Felder, welche fuer einen Diagonalzug erlaubt sind
		
		// Diagonal nach link oben
		outerloop:
		for(int i = token_Button.getNumber(); i>=0; i--){
			for(int j=1; j<8; j++){
				if(spielfeld[i].isEmpty() && spielfeld[i].getNumber()<token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()-(j*9) && spielfeld[i].getSpalte()>= 0 && spielfeld[i].getSpalte()<token_Button.getSpalte()){
					spielfeld[i].setDisable(false);
				} if(!spielfeld[i].isEmpty() && spielfeld[i].getNumber()<token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()-(j*9) && spielfeld[i].getSpalte()>= 0 && spielfeld[i].getSpalte()<token_Button.getSpalte()){
					break outerloop;
				}
			}
		}

		// Diagonal nach rechts oben
		outerloop:
		for(int i = token_Button.getNumber(); i>0; i--){
			for(int j=1; j<8; j++){
				if(spielfeld[i].isEmpty() && spielfeld[i].getNumber()<token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()-(j*7) && spielfeld[i].getSpalte() <= 8  && spielfeld[i].getSpalte()>token_Button.getSpalte()){
					spielfeld[i].setDisable(false);
				} if(!spielfeld[i].isEmpty() && spielfeld[i].getNumber()<token_Button.getNumber() && spielfeld[i].getNumber() == token_Button.getNumber()-(j*7) && spielfeld[i].getSpalte() <= 8  && spielfeld[i].getSpalte()>token_Button.getSpalte()){
					break outerloop;
				}
			}
		}
		return spielfeld;
	}

	// Das Token wird auf das neue Feld gesetzt
	protected GridPane changeFeld(Token_Button tokenClick, Feld_Button feldClick, GridPane spielfeld, Feld_Button[] spielfelder, Label labelRevanche, Stage stageRevanche) {
		
		// Das alte Feld soll frei werden
		for(Feld_Button F : spielfelder){
			if(F.getZeile()==tokenClick.getZeile() && F.getSpalte() == tokenClick.getSpalte()){
				F.setEmpty(true);
				}	
			}
				
		int feldZeile = feldClick.getZeile();
		int feldSpalte = feldClick.getSpalte();
		tokenClick.setZeile(feldZeile);
		tokenClick.setSpalte(feldSpalte);
		tokenClick.setNumber(feldClick.getNumber());
		GridPane.setColumnIndex(tokenClick, tokenClick.getSpalte());
		GridPane.setRowIndex(tokenClick, tokenClick.getZeile());
		
		// Das neue Feld soll besetzt sein
		feldClick.setEmpty(false);
		
		// Pruefen, ob das Token die letzte Zeile erreicht hat und der Player gewonnen hat
		if(this.getPlayer1().isOnTurn()){
			if(feldClick.getZeile()==8){
				tokenClick.setDisable(true);
				Game_Model.lastWinner = 1;
				this.player1.setAnzahlSiege(this.player1.getAnzahlSiege()+1);
				labelRevanche.setText(this.getPlayer1()+" hat gewonnen!");
				for(Feld_Button F : spielfelder){
					F.setDisable(true);
				}
				this.getPlayer1().setOnTurn(false);
				this.getPlayer2().setOnTurn(true);
				stageRevanche.showAndWait();
				
		} 
		}	
		if(this.getPlayer2().isOnTurn()){
			if(feldClick.getZeile()==1){
				tokenClick.setDisable(true);
				Game_Model.lastWinner = 2;
				this.player2.setAnzahlSiege(this.player2.getAnzahlSiege()+1);
				labelRevanche.setText(this.getPlayer2()+" hat gewonnen!");
				for(Feld_Button F : spielfelder){
					F.setDisable(true);
				}
				this.getPlayer1().setOnTurn(true);
				this.getPlayer2().setOnTurn(false);
				stageRevanche.showAndWait();
		} 	
		}
		
		// Der andere Spieler ist am Zug

		if(this.getPlayer1().isOnTurn() && Game_Model.lastWinner != 2){
			this.getPlayer1().setOnTurn(false);
			this.getPlayer2().setOnTurn(true);
		} else if (this.getPlayer2().isOnTurn() && Game_Model.lastWinner != 1){
				this.getPlayer1().setOnTurn(true);
				this.getPlayer2().setOnTurn(false);
		}
		Game_Model.lastWinner=0;
		
		return spielfeld;
	}

	protected Player getPlayer1() {
		return player1;
	}

	protected void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	protected Player getPlayer2() {
		return player2;
	}

	protected void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	protected void revanche(GridPane spielfeld, Token_Button[] tokensP1, Token_Button[] tokensP2, Feld_Button[] spielfelder) {

		for(int i = 0; i<Game_Model.anzahlFelderJeFarbe;i++){
			tokensP1[i].setZeile(1);
			tokensP1[i].setSpalte(i+1);
			tokensP1[i].setNumber(i);
			GridPane.setColumnIndex(tokensP1[i], tokensP1[i].getSpalte());
			GridPane.setRowIndex(tokensP1[i], tokensP1[i].getZeile());
		}
		
		for(int i = 0; i<Game_Model.anzahlFelderJeFarbe;i++){
			tokensP2[i].setZeile(Game_Model.anzahlTokensJeSpieler);
			tokensP2[i].setSpalte(8-i);
			tokensP2[i].setNumber(Game_Model.anzahlFelderTotal-1-i);
			GridPane.setColumnIndex(tokensP2[i], tokensP2[i].getSpalte());
			GridPane.setRowIndex(tokensP2[i], tokensP2[i].getZeile());
			
		}
		for (Feld_Button F : spielfelder){
			F.setEmpty(true);
		}
		for(int i = 0; i<8; i++){
			spielfelder[i].setEmpty(false);
		}
		for(int i = 56; i<64; i++){
			spielfelder[i].setEmpty(false);
		}

		if(Game_Model.lastWinner==1){
			for(Token_Button T : tokensP1){
				T.setDisable(true);
			} 
			for(Token_Button T : tokensP2){
				T.setDisable(false);
			}
		} 
		
		if(Game_Model.lastWinner==2){
			for(Token_Button T : tokensP1){
				T.setDisable(false);
			} 
			for(Token_Button T : tokensP2){
				T.setDisable(true);
			}

		}


	}
	}






















	
