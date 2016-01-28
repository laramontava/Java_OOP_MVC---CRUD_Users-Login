package app.classes;

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
	
	public configuration() {
		super();
		this.date ='a';//
		this.currency = '€';
		this.decimal = 2;
		this.language = "asd";
		this.format = "json";
		this.theme = 1;
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

	public String toString() {
		return "configuration [date=" + date + ", currency=" + currency + ", decimal=" + decimal + ", language="
				+ language + ", format=" + format + ", theme=" + theme + "]";
	}

	
}
