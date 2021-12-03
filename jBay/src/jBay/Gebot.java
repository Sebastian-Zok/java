package jBay;

public class Gebot {
	
	
	
	public Gebot(double hoechstBetrag, Bieter bieter) {
		super();
		this.hoechstBetrag = hoechstBetrag;
		this.bieter = bieter;
	}
	private double hoechstBetrag;
	private Bieter bieter;
	
	
	public double getHoechstBetrag() {
		return hoechstBetrag;
	}
	public void setHoechstBetrag(double hoechstBetrag) {
		this.hoechstBetrag = hoechstBetrag;
	}
	public Bieter getBieter() {
		return bieter;
	}
	public void setBieter(Bieter bieter) {
		this.bieter = bieter;
	}
	

}
