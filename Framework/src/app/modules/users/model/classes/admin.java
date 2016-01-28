package app.modules.users.model.classes;

import app.utils.format;
import app.classes.configuration;
import app.classes.fecha;
import app.classes.idioma;
import app.classes.singleton_global;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Admin")
public class admin extends users implements Serializable{
	@XStreamAlias("hiringdate")
	private String hiring_date;
	@XStreamAlias("yearsservice")
	private int years_service;
	@XStreamAlias("salary")
	private float salary;
	@XStreamAlias("activity")
	private int activity;
	
	
	//Constructor
	public admin(String dni, String name, String subname, String mobile, String email, String date_birthday, 
			String user, String pass, String avatar, String state, String hiring_date, float salary,
			int activity) {
		super(dni, name, subname, mobile, email, date_birthday, user, pass, avatar, state);
		this.hiring_date = hiring_date;
		this.salary = salary;
		this.activity = activity;
		super.setVentajas(calcularventajas());
		this.years_service=calculateyearsservice(this.hiring_date);
	}
	
	//constructor por defecto
	public admin() {
		super();
	}
	//constructor llave primaria
		public admin(String dni) {
			super(dni);
		}
	//constructor a petición de usuario
	public admin(Object op, int i){
		switch(i){
		case 0:
			this.hiring_date=(String)op;
			break;		
		case 1:
			this.years_service=(int)op;
			break;
		case 2:
			this.salary=(int)op;
			break;
		case 3:
			this.activity=(int)op;
			break;
		}
	}
	//getter y setter
	public String getHiring_date() {
		return hiring_date;
	}
	public void setHiring_date(String hirin_date) {
		this.hiring_date = hirin_date;
		this.years_service=calculateyearsservice(this.hiring_date);
	}
	public int getYears_service() {
		return years_service;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
		super.setVentajas(((admin)this).calcularventajas());
	}
	
	//to string
	public String toString(configuration conf, idioma translate) {
		String cad="";
		
		cad+=super.toString()+"\n";
		cad+=translate.getProperty("Hiring_date")+" => "+this.getHiring_date()+"\n";
		cad+=translate.getProperty("Years_service")+" => "+this.getYears_service()+"\n";
			
		switch(conf.getCurrency()){
		case '€':
			cad+=translate.getProperty("Salary")+" => "+format.FormatEuro(this.getSalary())+"\n";
			break;
		case '$':
			cad+=translate.getProperty("Salary")+" => "+format.FormatDollar(this.getSalary(),conf)+"\n";
			break;
		case '£':
			cad+=translate.getProperty("Salary")+" => "+format.FormatLibra(this.getSalary())+"\n";
			break;
		}
		switch(conf.getCurrency()){
		case '€':
			cad+=translate.getProperty("Incentives")+" => "+format.FormatEuro(this.getVentajas())+"\n";
			break;
		case '$':
			cad+=translate.getProperty("Incentives")+" => "+format.FormatDollar(this.getVentajas(),conf)+"\n";
			break;
		case '£':
			cad+=translate.getProperty("Incentives")+" => "+format.FormatLibra(this.getVentajas())+"\n";
			break;
		}
		//cad+="Incentives => "+this.getVentajas()+"\n";
		cad+=translate.getProperty("Activity")+" => "+this.getActivity()+"\n";
		
		return cad;
	}

	//to string clave primaria
	public String toString(String dni){
		return super.toString(dni);
	}
	//to string petición de usuario
	public String toString(int i){
		String cad="";
		if(i<11){
			super.toString(i, 2);
		}
		else{
			switch(i){
			case 11:
				cad+=this.getHiring_date()+"\n";
				break;		
			case 12:
				cad+=this.getYears_service()+"\n";
				break;
			case 13:
				cad+=this.getSalary()+"\n";
				break;
			case 14:
				cad+=this.getVentajas()+"\n";
				break;
			case 15:
				cad+=this.getActivity()+"\n";
				break;
				}
		}
		return cad;	
	}
	public float calcularventajas(){
		return (float)(activity*0.05);
	}
	public int calculateyearsservice(String fecha){
		fecha years = new fecha(fecha);
		return years.restafechas(years.stringtocalendar(fecha), years.fechasystem(), "años");
	}
	
	public void currency(char moneda){
		float cambia;
		
		if(moneda=='€'&&singleton_global.conf.getCurrency()=='$'){//eur a usd *1,0934
			cambia=(float) (this.salary*1.0934);
			this.salary=cambia;
		}
		if(moneda=='$'&&singleton_global.conf.getCurrency()=='€'){//usd a eur /1,0934
			cambia=(float) (this.salary/1.0934);
			this.salary=cambia;
		}
		if(moneda=='€'&&singleton_global.conf.getCurrency()=='£'){//eur a libra *0,728
			cambia=(float) (this.salary*0.728);
			this.salary=cambia;
		}
		if(moneda=='£'&&singleton_global.conf.getCurrency()=='€'){//libra a eur /0,728
			cambia=(float) (this.salary/0.728);
			this.salary=cambia;
		}
		if(moneda=='$'&&singleton_global.conf.getCurrency()=='£'){//usd a libra *0,6658
			cambia=(float) (this.salary*0.6658);
			this.salary=cambia;
		}
		if(moneda=='£'&&singleton_global.conf.getCurrency()=='$'){//libra a usd /0,6658
			cambia=(float) (this.salary/0.6658);
			this.salary=cambia;
		}
	}
}