package jBay;

public class Ware {
	
	public Ware(String titel, String beschreibung) {
		super();
		this.titel = titel;
		this.beschreibung = beschreibung;
	}

	private String titel, beschreibung;

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

}
