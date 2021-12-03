package jBay;



public class Bieter {
	
	
	public Bieter(String vorname, String nachname) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
	}

	private String vorname, nachname;

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getFullName() {
		return this.vorname + " " + this.nachname;	
	}
}


