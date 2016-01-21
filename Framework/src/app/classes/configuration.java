package app.classes;

import java.io.Serializable;

public class configuration implements Serializable {
	private char date;
	private char currency;
	private int decimal;
	private String language;
	private String format;
	
	public configuration() {
		super();
		this.date ='a';
		this.currency = '€';
		this.decimal = 2;
		this.language = "english";
		this.format = "json";
	}
	
	
	public char getDate() {
		return date;
	}
	public void setDate(char date) {
		this.date = date;
	}

	
	public char getCurrency() {
		return currency;
	}
	public void setCurrency(char currency) {
		this.currency = currency;
	}

	public int getDecimal() {
		return decimal;
	}
	public void setDecimal(int decimal) {
		this.decimal = decimal;
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getFormat(){
		return format;
	}
	public void setFormat(String format){
		this.format = format;
	}


	public String toString() {
		return "configuration [date=" + date + ", currency=" + currency + ", decimal=" + decimal + ", language="
				+ language + ", format=" + format + "]";
	}
}
