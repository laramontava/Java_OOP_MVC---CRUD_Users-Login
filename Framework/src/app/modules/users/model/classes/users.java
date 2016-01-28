package app.modules.users.model.classes;

import app.classes.fecha;
import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Users")
public abstract class users implements Comparable<users>, Serializable{
	public static Object validate;
	@XStreamAlias("dni")
	private String dni;
	@XStreamAlias("name")
	private String name;
	@XStreamAlias("surname")
	private String subname;
	@XStreamAlias("mobile")
	private String mobile;
	@XStreamAlias("email")
	private String email;
	@XStreamAlias("datebirthday")
	private String date_birthday;
	@XStreamAlias("age")
	private int age;
	@XStreamAlias("username")
	private String user;
	@XStreamAlias("password")
	private String pass;
	@XStreamAlias("avatar")
	private String avatar;
	@XStreamAlias("state")
	private String state;
	@XStreamAlias("ventajas")
	private float ventajas;
	
	
	//Constructor
	public users(String dni, String name, String subname, String mobile, String email, String date_birthday,
			String user, String pass, String avatar, String state){
		this.dni=dni;
		this.name=name;
		this.subname=subname;
		this.mobile=mobile;
		this.email=email;
		this.date_birthday=date_birthday;
		this.user=user;
		this.pass=pass;
		this.avatar=avatar;
		this.state=state;
		this.age=calculateage(this.date_birthday);
	}
	//constructor por defecto
	public users() {
		
	}
	//constructor llave primaria
	public users(String dni) {
		this.dni = dni;
	}
	//constructor a petición de usuario
	public users(int i, String s, int age){
		switch(i){
		case 0:
			this.dni=s;
			break;		
		case 1:
			this.name=s;
			break;
		case 2:
			this.subname=s;
			break;
		case 3:
			this.mobile=s;
			break;
		case 4:
			this.email=s;
			break;
		case 5:
			this.date_birthday=s;
			break;
		case 6:
			this.age=age;
			break;
		case 7:
			this.user=s;
			break;
		case 8:
			this.pass=s;
			break;
		case 9:
			this.avatar=s;
			break;
		case 10:
			this.state=s;
			break;
		}
	}
	//getter y setter
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate_birthday() {
		return date_birthday;
	}
	public void setDate_birthday(String date_birthday) {
		this.date_birthday = date_birthday;
		this.age=calculateage(this.date_birthday);
	}
	public int getAge() {
		return age;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public float getVentajas() {
		return ventajas;
	}
	public void setVentajas(float ventajas){
		this.ventajas = ventajas;
	}
	public int compareTo(users u){
		if(this.dni.compareTo(u.getDni())>0)
			return 1;
		if(this.dni.compareTo(u.getDni())<0)
			return -1;
		return 0;
	}
	public boolean equals(Object o){
		return getDni().equals(((users)o).getDni());
	}
	//to string
	public String toString() {
		String cad="";
		cad+="DNI => "+this.getDni()+"\n";
		cad+="Name => "+this.getName()+"\n";
		cad+="Subname => "+this.getSubname()+"\n";
		cad+="Mobile => "+this.getMobile()+"\n";
		cad+="Email => "+this.getEmail()+"\n";
		cad+="Date Birthday => "+this.getDate_birthday()+"\n";
		cad+="Age => "+this.getAge()+"\n";
		cad+="User => "+this.getUser()+"\n";
		cad+="Avatar => "+this.getAvatar()+"\n";
		cad+="State => "+this.getState()+"\n";
		return cad;
	}
	//to string clave primaria
	public String toString(String dni){
		return this.getDni();
	}
	//toString petición usuario
	public String toString(int i, int age){
		String cad="";
			switch(i){
			case 0:
				cad+=this.getDni()+"\n";
				break;		
			case 1:
				cad+=this.getName()+"\n";
				break;
			case 2:
				cad+=this.getSubname()+"\n";
				break;
			case 3:
				cad+=this.getMobile()+"\n";
				break;
			case 4:
				cad+=this.getEmail()+"\n";
				break;
			case 5:
				cad+=this.getDate_birthday()+"\n";
				break;
			case 6:
				cad+=this.getAge()+"\n";
				break;
			case 7:
				cad+=this.getUser()+"\n";
				break;
			case 8:
				cad+=this.getPass()+"\n";
				break;
			case 9:
				cad+=this.getAvatar()+"\n";
				break;
			case 10:
				cad+=this.getState()+"\n";
				break;
			}
		return cad;	
	}
	public abstract float calcularventajas();
	public int calculateage(String fecha){
		fecha age = new fecha(fecha);
		return age.restafechas(age.stringtocalendar(fecha), age.fechasystem(), "años");
	}
}
