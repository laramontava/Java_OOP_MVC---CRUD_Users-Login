package app.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import app.modules.config.model.configuration;

public class format {
	
	public static String porcentajeFloat(float i){
		String s = "";
			s = Float.toString(i) + "%";
		return s;
	}
	
	public static String format1decimal(float number){
		DecimalFormat format1 = new DecimalFormat(".#");//un decimal
		return format1.format(number);
	}
	
	public static String format2decimales(float number){
		DecimalFormat format1 = new DecimalFormat(".##");//dos decimales
		return format1.format(number);
	}
	
	public static String format3decimales(float number){
		DecimalFormat format1 = new DecimalFormat(".###");//tres decimales
		return format1.format(number);
	}

	public static String FormatDollar(float moneda, configuration conf){
		NumberFormat coin=NumberFormat.getCurrencyInstance(Locale.US);//Dolar
		coin.setMaximumFractionDigits(conf.getDecimal());
		return coin.format(moneda);
	}
	
	public static String FormatLibra(float moneda){
		NumberFormat coin=NumberFormat.getCurrencyInstance( Locale.UK );//Libras
		return coin.format(moneda);
	}
	
	public static String FormatEuro(float moneda){
		NumberFormat coin=NumberFormat.getCurrencyInstance( Locale.FRANCE );//Euro
		return coin.format(moneda);
	}	
	
}
