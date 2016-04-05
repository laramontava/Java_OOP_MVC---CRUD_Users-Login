package app.modules.menu.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Config")
public class configuration {
	@XStreamAlias("date")
	private char date;
	@XStreamAlias("currency")
	private char currency;
	@XStreamAlias("decimal")
	private int decimal;
	@XStreamAlias("language")
	private String language;
	@XStreamAlias("format")
	private String format;
	@XStreamAlias("theme")
	private int theme;
	@XStreamAlias("dummies")
	private boolean dummies;
	
	public configuration() {
		super();
		this.date ='a';//
		this.currency = 'e';
		this.decimal = 2;
		this.language = "english";
		this.format = "json";
		this.theme = 1;
		this.dummies = false;
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
	public int getTheme(){
		return theme;
	}
	public void setTheme(int theme){
		this.theme = theme;
	}
	public boolean getDummies(){
		return dummies;
	}
	public void setDummies(boolean dummies){
		this.dummies = dummies;
	}

	public String toString() {
		return "configuration [date=" + date + ", currency=" + currency + ", decimal=" + decimal + ", language="
				+ language + ", format=" + format + ", theme=" + theme + "]";
	}

	
}
