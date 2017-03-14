package Informatikprojekt_WindChuckers.Kamisado_WindChuckers;

import javafx.scene.control.Button;

public class Feld_Button extends Button{

	private String color;
	private int zeile;
	private int spalte;
	private boolean empty = true;
	private int number;
		
	protected Feld_Button(String color){
	super();
	this.color=color;
	}

	protected String getColor() {
		return color;
	}
	
	protected int getZeile() {
		return zeile;
	}

	protected void setZeile(int zeile) {
		this.zeile = zeile;
	}

	protected int getSpalte() {
		return spalte;
	}

	protected void setSpalte(int spalte) {
		this.spalte = spalte;
	}


	protected boolean isEmpty() {
		return empty;
	}


	protected void setEmpty(boolean empty) {
		this.empty = empty;
	}

	protected void setNumber(int number) {
		this.number = number;
	}
	
	protected int getNumber() {
		return this.number;
	}
}