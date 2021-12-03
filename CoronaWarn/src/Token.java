import java.util.Date;
import java.util.Random;

public class Token {


	private String value;
	private Date date;
	
	public Token() {
		super();
		this.value = java.util.UUID.randomUUID().toString();
		this.date = new Date();
	}
	
	
	public Token(String value, Date date) {
		super();
		this.value = value;
		this.date = date;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String toString() {
		return value + " " + date.toString();
	}
	
}
