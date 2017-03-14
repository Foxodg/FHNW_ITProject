package Informatikprojekt_WindChuckers.Kamisado_WindChuckers;

public class Player {
	
	private int playerNummer;
	private int anzahlSiege=0;
	private String playerName;
	private boolean onTurn;
	
	protected Player(int playerNummer){
		this.playerNummer=playerNummer;
	}

	protected int getPlayerNummer() {
		return playerNummer;
	}

	protected int getAnzahlSiege() {
		return anzahlSiege;
	}

	protected void setAnzahlSiege(int anzahlSiege) {
		this.anzahlSiege = anzahlSiege;
	}

	protected String getPlayerName() {
		return playerName;
	}

	protected void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	protected boolean isOnTurn() {
		return onTurn;
	}

	protected void setOnTurn(boolean onTurn) {
		this.onTurn = onTurn;
	}
	
	@Override
	public String toString(){
		String text = "Player "+this.getPlayerNummer();
		return text;
		
	}
	

}
