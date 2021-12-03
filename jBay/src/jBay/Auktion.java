package jBay;

import java.util.Calendar;

public class Auktion {


	private Ware ware;
	private Gebot gebot;
	
	private double price;
	private Calendar end;
	
	public static double increment=1.0d;
	
	public Auktion(Ware ware, int dauer) {
		super();
		this.ware = ware;
		this.gebot = null;
		this.price = 0.0d;
		
		java.util.Calendar zeit = java.util.Calendar.getInstance();
		zeit.setTimeInMillis(System.currentTimeMillis() + 60000 * dauer);
		this.end = zeit;
	}
	
	public boolean gebotAbgeben(Gebot g) {
		
		if(g.getHoechstBetrag() < price + increment) {
			return false;
		}
		
		if(gebot == null) {
			setPrice(increment);
			gebot = g;
			return true;
		}
		
		if(g.getBieter() == gebot.getBieter()) {
			if(g.getHoechstBetrag()>gebot.getHoechstBetrag()) {
				gebot = g;
			}
			return false;
		}
		
		
		if(g.getHoechstBetrag()>= price + increment && g.getHoechstBetrag() <= gebot.getHoechstBetrag()) {
			price = g.getHoechstBetrag() + increment;
			return false;
		}
		
		if (g.getHoechstBetrag() >= price + increment && g.getHoechstBetrag() > gebot.getHoechstBetrag() + increment) {
			price = gebot.getHoechstBetrag() + increment;
			gebot = g;
			return true;
		}
		return false;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Ware getWare() {
		return ware;
	}
	public void setWare(Ware ware) {
		this.ware = ware;
	}
	public Gebot getGebot() {
		return gebot;
	}
	public void setGebot(Gebot gebot) {
		this.gebot = gebot;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Calendar getEnd() {
		return end;
	}
	public void setEnd(Calendar end) {
		this.end = end;
	} 
	
	
}
