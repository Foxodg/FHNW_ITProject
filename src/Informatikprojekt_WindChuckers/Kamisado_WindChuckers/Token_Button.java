package Informatikprojekt_WindChuckers.Kamisado_WindChuckers;

import javafx.scene.control.Button;

public class Token_Button extends Button {
	private int playerNumber;
	private String color;
	private int spalte; 
	private int zeile; 
	private int number;
	
	protected Token_Button (String color){
		super();
		this.color = color;
	}
	
	protected void setPlayer(int player){
		this.playerNumber=player;
	}
	
	protected int getPlayer(){
		return this.playerNumber;
	}
	
	protected String getColor(){
		return this.color;
	}
	protected int getZeile(){
		return this.zeile;
	}
	
	protected void setZeile(int zeile){
		this.zeile=zeile;
	}
	
	protected int getSpalte(){
		return this.spalte;
	}
	
	protected void setSpalte(int spalte){
		this.spalte=spalte;
	}

	protected int getNumber() {
		return number;
	}

	protected void setNumber(int number) {
		this.number = number;
	}
	
}
