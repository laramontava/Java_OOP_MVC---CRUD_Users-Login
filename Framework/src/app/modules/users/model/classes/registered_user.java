package app.modules.users.model.classes;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@SuppressWarnings("serial")
@XStreamAlias("Registered_user")
public class registered_user extends users implements Serializable {
	@XStreamAlias("activity")
	private int activity;
	@XStreamAlias("karma")
	private String karma;
	@XStreamAlias("points")
	private int points;
	
	//constructor
	public registered_user(String dni, String name, String subname, String mobile, String email, String date_birthday,
			String user, String pass, String avatar, String state, int activity) {
		super(dni, name, subname, mobile, email, date_birthday, user, pass, avatar, state);
		this.activity = activity;
		super.setVentajas(calcularventajas());
	}
	
	//constructor por defecto
	public registered_user(){
		super();
	}
	//constructor llave primaria
			public registered_user(String dni) {
				super(dni);
			}
	//constructor a petición de usuario
	public registered_user(Object op, int i){
		switch(i){
		case 0:
			this.activity=(int)op;
			break;		
		}
	}
	
	//getter y setter
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
		((registered_user)this).calcularkarma();
		super.setVentajas(((registered_user)this).calcularventajas());
	}
	
	//to string
	public String toString() {
		String cad="";
		cad+=super.toString()+"\n";
		cad+="Activity => "+this.getActivity()+"\n";
		cad+="Karma => "+this.calcularkarma()+"\n";
		cad+="Points => "+this.getVentajas()+"\n";
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
				case 0:
					cad+=this.getActivity()+"\n";
					break;		
				case 1:
					cad+=this.calcularkarma()+"\n";
					break;
				case 2:
					cad+=this.getVentajas()+"\n";
					break;
				}
			}
			return cad;
		}
		int karma2;
	public String calcularkarma(){
		
		if(activity<=999){
			karma="Low";
			karma2=0;
		}
		if((activity>=1000)&&(activity<=4999)){
			karma="Medium";
			karma2=1;
		}
		if(activity>=5000){
			karma="Hight";
			karma2=2;
		}
		return karma;
	}
	
	public float calcularventajas(){
		if(karma2==0){
			points=activity*5;
		}
		if(karma2==1){
			points=activity*7;
		}
		if(karma2==2){
			points=activity*10;
		}
		return points;
	}
}