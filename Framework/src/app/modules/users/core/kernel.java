package app.modules.users.core;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import app.classes.configuration;
import app.classes.fecha;
import app.classes.idioma;
import app.utils.functions;
import app.utils.validate;

public class kernel {
	
	public static String pedirdatos(String type,String message, String title,idioma translate){
		int modulo, dninum;
		char numcalc;
		String s="", dnicad="", dniletra="";
		boolean val = false;
		String caracter="TRWAGMYFPDXBNJZSQVHLCKET";
		switch(type){
		case "dni":
			do{
				dnicad="";
				dniletra="";
				dninum=0;
				s = functions.validatestring(message, title);
				val = validate.validatedni(s);
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
				if(val==true){
					for(int i=0;i<8;i++){
						dnicad+=s.charAt(i);
					}
					dniletra+=s.charAt(8);
					dninum=Integer.parseInt(dnicad);
					modulo= dninum % 23;
					numcalc=caracter.charAt(modulo);
					if(String.valueOf(numcalc).equals(dniletra)){
						val=true;
					}
					else{
						val=false;
						JOptionPane.showMessageDialog(null, translate.getProperty("incorrectcharadni"));
					}
				}
			}while(val==false);
			break;
		case "name":
			do{
				s = functions.validatestring(message, title);
				val = validate.validaNombre(s);
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
			}while(val==false);
			break;
		case "subname":
			do{
				s = functions.validatestring(message, title);
				val = validate.validaNombre(s);
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
			}while(val==false);
			break;
		case "mobile":
			do{
				s = functions.validatestring(message, title);
				val = validate.validaTelefono(s);
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
			}while(val==false);
			break;
		case "email":
			do{
				s = functions.validatestring(message, title);
				val = validate.validaEmail(s);
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
			}while(val==false);
			break;
		case "date_birthday":
			do{
				s = functions.validatestring(message,title);
				val = validate.validafechacorrecta(s,'a');
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
			}while(val==false);
			break;
		
		case "up_date":
			do{
				s = functions.validatestring("Introduce up date\n Example: dd/mm/yyyy", "Up date");
				val = validate.validafechacorrecta(s,'a');
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
			}while(val==false);
			break;
		case "hiring_date":
			do{
				s = functions.validatestring("Introduce hiring date\n Example: dd/mm/yyyy", "Hiring date");
				val = validate.validafechacorrecta(s,'a');
				if(val==false){
					JOptionPane.showMessageDialog(null, translate.getProperty("incorrectformat"));
				}
			}while(val==false);
			break;
		}
		
		return s;
	
	}
	
	public static String validatefecha(String message, String title, configuration conf){
		String s="";
		boolean val=true;
		int dia = 0, mes = 0, anyo = 0;
		
		do{
			s = functions.validatestring(message, title);
			val = validate.validafechacorrecta(s, conf.getDate());
			if(val==false){
				JOptionPane.showMessageDialog(null, "Incorrect data");
			}
			if(val==true){
				String[] fecha;

				switch(conf.getDate()){
				case 'a'://dd/mm/yyyy
					fecha=s.split("/");
					
					dia=Integer.parseInt(fecha[0]);
					mes=Integer.parseInt(fecha[1]);
					anyo=Integer.parseInt(fecha[2]);
					break;
				case 'b'://dd-mm-yyyy
					fecha=s.split("-");
					
					dia=Integer.parseInt(fecha[0]);
					mes=Integer.parseInt(fecha[1]);
					anyo=Integer.parseInt(fecha[2]);

					break;
				case 'c'://yyyy/mm/dd
					fecha=s.split("/");
					
					anyo=Integer.parseInt(fecha[0]);
					mes=Integer.parseInt(fecha[1]);
					dia=Integer.parseInt(fecha[2]);

					break;
				case 'd'://yyyy-mm-dd
					fecha=s.split("-");

					anyo=Integer.parseInt(fecha[0]);
					mes=Integer.parseInt(fecha[1]);
					dia=Integer.parseInt(fecha[2]);
					break;
				}
				
				switch(mes){
				case 2:
					if((anyo%4)==0){
						if(dia>29)
							val=false;
					}
					else{
						if(dia>28)
							val=false;
					}
				case 4://abril
					if(dia==31)
						val=false;
					break;
				case 6://junio
					if(dia==31)
						val=false;
					break;
				case 9://septiembre
					if(dia==31)
						val=false;
					break;
				case 11://noviembre
					if(dia==31)
						val=false;
					break;
				
				}
				
				if(val==false){
					JOptionPane.showMessageDialog(null, "Invalid date");
				}
			}
		}while(val==false);
		return s;
	}
	public static String datebirthday(String message, String title, configuration conf, idioma translate){
		String s="";
		boolean val=true;
		int resultado = 0;
		do{
			val=true;
			s = validatefecha(message,title,conf);
			fecha datefecha = new fecha();
			Calendar date = new GregorianCalendar();
			date=datefecha.stringtocalendar(s);
			fecha fe = new fecha();
			Calendar datesystem = new GregorianCalendar();
			datesystem=fe.fechasystem();
			if(date.after(datesystem)){
				JOptionPane.showMessageDialog(null, translate.getProperty("future"));
				val=false;
			}
			if(val==true){
				fecha resta = new fecha();
				resta.restafechas(date, datesystem, "años");
				resultado=resta.restafechas(date, datesystem, "años");
				if(resultado<18){
					val=false;
					JOptionPane.showMessageDialog(null, "You aren't 18");
				}
				
			}
			
		}while(val==false);
		return s;
	}
	public static String yearsservice(String message, String title, String datebirthday, configuration conf, idioma translate){
		String s="";
		boolean val=true;
		int years=0;
		
		do{
			val=true;
			s = validatefecha(message,title,conf);
			fecha datefecha = new fecha();
			Calendar date = new GregorianCalendar();
			date=datefecha.stringtocalendar(s);
			fecha fe = new fecha();
			Calendar datesystem = new GregorianCalendar();
			datesystem=fe.fechasystem();
			if(date.after(datesystem)){
				JOptionPane.showMessageDialog(null, translate.getProperty("future"));
				val=false;
			}
			fecha diferencia = new fecha();
			years=diferencia.restafechas(date, datefecha.stringtocalendar(datebirthday), "años");
			if(years<18){
				JOptionPane.showMessageDialog(null, translate.getProperty("menor"));
				val=false;
			}
			if(val==true){
				fecha resta = new fecha();
				resta.restafechas(date, datesystem, "años");	
			}
			
		}while(val==false);
		return s;
	}
}
