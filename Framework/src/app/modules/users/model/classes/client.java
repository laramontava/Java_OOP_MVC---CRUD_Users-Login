package app.modules.users.model.classes;

import app.classes.fecha;
import app.classes.singleton_global;
import app.utils.format;
import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias("Client")
public class client extends users implements Serializable{
	@XStreamAlias("up date")
	private String up_date;
	@XStreamAlias("years service")
	private int years_service;
	@XStreamAlias("shopping")
	private float shopping;
	@XStreamAlias("discount")
	private float discount;
	@XStreamAlias("premium")
	private boolean premium;
	@XStreamAlias("client type")
	private String client_type;
	
	//constructor
	public client(String dni, String name, String subname, String mobile, String email, String date_birthday,
			String user, String pass, String avatar, String state, String up_date, float shopping,
			boolean premium, String client_type) {
		super(dni, name, subname, mobile, email, date_birthday, user, pass, avatar, state);
		this.up_date = up_date;
		this.shopping = shopping;
		this.premium = premium;
		this.client_type = client_type;
		super.setVentajas(calcularventajas());
		this.years_service=calculateyearsservice(this.up_date);
	}
	
	//constructor por defecto
	public client() {
		super();
	}
	//constructor llave primaria
			public client(String dni) {
				super(dni);
			}
	//constructor a peticion de usuario
	public client(Object op, int i){
		switch(i){
		case 0:
			this.up_date=(String)op;
			break;		
		case 1:
			this.years_service=(int)op;
			break;
		case 2:
			this.shopping=(int)op;
			break;
		case 3:
			this.premium=(boolean)op;
			break;
		case 4:
			this.client_type=(String)op;
			break;
		}
	}
	
	//getter y setter
	public String getUp_date() {
		return up_date;
	}
	public void setUp_date(String up_date) {
		this.up_date = up_date;
		this.years_service=calculateyearsservice(this.up_date);
	}
	public int getYears_service() {
		return years_service;
	}
	public float getShopping() {
		return shopping;
	}
	public void setShopping(float shopping) {
		this.shopping = shopping;
	}
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
		super.setVentajas(((client)this).calcularventajas());
	}
	public String getClient_type() {
		return client_type;
	}
	public void setClient_type(String client_type) {
		this.client_type = client_type;
	}
	
	//to string
	public String toString() {
		String cad="";
		
		cad+=super.toString()+"\n";
		cad+="Up date => "+this.getUp_date()+"\n";
		cad+="Years service => "+this.getYears_service()+"\n";
		switch(singleton_global.conf.getCurrency()){
		case '€':
			cad+="Shopping => "+format.FormatEuro(this.getShopping())+"\n";
			break;
		case '$':
			cad+="Shopping => "+format.FormatDollar(this.getShopping(), singleton_global.conf)+"\n";
			break;
		case '£':
			cad+="Shopping => "+format.FormatLibra(this.getShopping())+"\n";
			break;
		}
		cad+="Discount => "+app.utils.format.porcentajeFloat(this.getVentajas())+"\n";
		cad+="Premium => "+this.isPremium()+"\n";
		cad+="Client type => "+this.getClient_type()+"\n";
		return cad;
	}
	
	//to string clave primaria
	public String toString(String dni){
		return super.toString(dni);
	}
	
	//to string petici�n de usuario
	public String toString(int i){
	String cad="";
		if(i<11){
			super.toString(i, 2);
		}
		else{
			switch(i){
			case 0:
				cad+=this.getUp_date()+"\n";
				break;		
			case 1:
				cad+=this.getYears_service()+"\n";
				break;
			case 2:
				cad+=this.getShopping()+"\n";
				break;
			case 3:
				cad+=this.getVentajas()+"\n";
				break;
			case 4:
				cad+=this.isPremium()+"\n";
				break;
			case 5:
				cad+=this.getClient_type()+"\n";
				break;
			}
		}
		return cad;
	}
	public float calcularventajas(){
		if(premium==true){
			discount= (float) 0.75;
		}
		else{
			discount=0;
		}
		return discount;
	}
	public int calculateyearsservice(String fecha){
		fecha years = new fecha(fecha);
		return years.restafechas(years.stringtocalendar(fecha), years.fechasystem(), "a�os");
	}
	
	public void currency(char moneda){
		float cambia;
		
		if(moneda=='�'&&singleton_global.conf.getCurrency()=='$'){//eur a usd *1,0934
			cambia=(float) (this.shopping*1.0934);
			this.shopping=cambia;
		}
		if(moneda=='$'&&singleton_global.conf.getCurrency()=='�'){//usd a eur /1,0934
			cambia=(float) (this.shopping/1.0934);
			this.shopping=cambia;
		}
		if(moneda=='�'&&singleton_global.conf.getCurrency()=='�'){//eur a libra *0,728
			cambia=(float) (this.shopping*0.728);
			this.shopping=cambia;
		}
		if(moneda=='�'&&singleton_global.conf.getCurrency()=='�'){//libra a eur /0,728
			cambia=(float) (this.shopping/0.728);
			this.shopping=cambia;
		}
		if(moneda=='$'&&singleton_global.conf.getCurrency()=='�'){//usd a libra *0,6658
			cambia=(float) (this.shopping*0.6658);
			this.shopping=cambia;
		}
		if(moneda=='�'&&singleton_global.conf.getCurrency()=='$'){//libra a usd /0,6658
			cambia=(float) (this.shopping/0.6658);
			this.shopping=cambia;
		}
	}
}