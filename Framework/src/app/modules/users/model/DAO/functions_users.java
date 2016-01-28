package app.modules.users.model.DAO;
import javax.swing.JOptionPane;

import app.classes.configuration;
import app.classes.idioma;
import app.classes.singleton_global;
import app.modules.users.core.kernel;
import app.modules.users.model.BLL.Arraylist_admin;
import app.modules.users.model.BLL.Arraylist_client;
import app.modules.users.model.BLL.Arraylist_userreg;
import app.modules.users.model.classes.admin;
import app.modules.users.model.classes.client;
import app.modules.users.model.classes.registered_user;
import app.modules.users.model.classes.singleton;
import app.modules.users.model.classes.users;
import app.utils.functions;
import app.utils.menus;

public class functions_users {
	
	public static admin pideadmin(idioma translate){
		String dni, name, subname, mobile, email, date_birthday, user, pass, avatar, state;
		int activity;
		float salary;
		String hiring_date;
		String formatdate="";
		
		switch(singleton_global.conf.getDate()){
		case 'a':
			formatdate="dd/MM/yyyy";
			break;
		case 'b':
			formatdate="dd-MM-yyyy";
			break;
		case 'c':
			formatdate="yyyy/MM/dd";
			break;
		case 'd':
			formatdate="yyyy-MM-dd";
			break;
		}
		//dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
		dni=singleton.dni;
		name=kernel.pedirdatos("name",translate.getProperty("name"),"Name", translate);
		subname=kernel.pedirdatos("subname",translate.getProperty("subname"),"Subname", translate);
		mobile=kernel.pedirdatos("mobile",translate.getProperty("phone"),"Mobile", translate);
		email=kernel.pedirdatos("email",translate.getProperty("email"),"Email", translate);
		date_birthday=kernel.datebirthday(translate.getProperty("datebirthday")+formatdate,"Date Birthday",translate);
		user=functions.validatestring(translate.getProperty("user"), "User");
		pass=functions.validatestring(translate.getProperty("pass"), "Password");
		avatar=functions.validatestring(translate.getProperty("avatar"), "Avatar");
		state=menus.menustate(translate.getProperty("state"), "State");
		hiring_date=kernel.yearsservice(translate.getProperty("hiring_date")+formatdate,"Hiring date",date_birthday,translate);
		salary=functions.validatefloat(translate.getProperty("salary"), "Salary");
		activity=functions.validateint(translate.getProperty("activity"), "Activity");
		return new admin(dni,name,subname,mobile,email,date_birthday,user,pass,avatar,state,hiring_date,salary,activity);
	}
	public static admin finddniadmin(idioma translate){
		//String dni;
		//dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
		singleton.dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
		return new admin(singleton.dni);
	}
	public static client finddniclient(idioma translate){
		singleton.dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
		return new client(singleton.dni);
	}
	public static registered_user finddniuserreg(idioma translate){
		singleton.dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
		return new registered_user(singleton.dni);
	}
	public static client pideclient(idioma translate){
		String dni, name, subname, mobile, email, date_birthday, user, pass, avatar, state;
		float shopping;
		String up_date, client_type;
		boolean premium;
		String formatdate="";
		switch(singleton_global.conf.getDate()){
		case 'a':
			formatdate="dd/MM/yyyy";
			break;
		case 'b':
			formatdate="dd-MM-yyyy";
			break;
		case 'c':
			formatdate="yyyy/MM/dd";
			break;
		case 'd':
			formatdate="yyyy-MM-dd";
			break;
		}
		//dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
		dni=singleton.dni;
		name=kernel.pedirdatos("name",translate.getProperty("name"),"Name", translate);
		subname=kernel.pedirdatos("subname",translate.getProperty("subname"),"Subname", translate);
		mobile=kernel.pedirdatos("mobile",translate.getProperty("phone"),"Mobile", translate);
		email=kernel.pedirdatos("email",translate.getProperty("email"),"Email", translate);
		date_birthday=kernel.datebirthday(translate.getProperty("datebirthday")+formatdate,"Date Birthday",translate);
		user=functions.validatestring(translate.getProperty("user"), "User");
		pass=functions.validatestring(translate.getProperty("pass"), "Password");
		avatar=functions.validatestring(translate.getProperty("avatar"), "Avatar");
		state=menus.menustate(translate.getProperty("state"), "State");
		up_date=kernel.yearsservice(translate.getProperty("up_date")+formatdate,"Hiring date",date_birthday,translate);
		shopping=functions.validatefloat(translate.getProperty("shopping"), "Shopping");
		premium=menus.validateboolean(translate.getProperty("premium"), "Premium");
		client_type=functions.validatestring(translate.getProperty("clienttype"), "Client type");
		
		return new client(dni,name,subname,mobile,email,date_birthday,user,pass,avatar,state,up_date,shopping,premium,
				client_type);
	}

	public static registered_user pideregistrado(idioma translate){
		String dni, name, subname, mobile, email, date_birthday, user, pass, avatar, state;
		int activity;
		String formatdate="";
		switch(singleton_global.conf.getDate()){
		case 'a':
			formatdate="dd/MM/yyyy";
			break;
		case 'b':
			formatdate="dd-MM-yyyy";
			break;
		case 'c':
			formatdate="yyyy/MM/dd";
			break;
		case 'd':
			formatdate="yyyy-MM-dd";
			break;
		}
		//dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
		dni=singleton.dni;
		name=kernel.pedirdatos("name",translate.getProperty("name"),"Name", translate);
		subname=kernel.pedirdatos("subname",translate.getProperty("subname"),"Subname", translate);
		mobile=kernel.pedirdatos("mobile",translate.getProperty("phone"),"Mobile", translate);
		email=kernel.pedirdatos("email",translate.getProperty("email"),"Email", translate);
		date_birthday=kernel.datebirthday(translate.getProperty("datebirthday")+formatdate,"Date Birthday",translate);
		user=functions.validatestring(translate.getProperty("user"), "User");
		pass=functions.validatestring(translate.getProperty("pass"), "Password");
		avatar=functions.validatestring(translate.getProperty("avatar"), "Avatar");
		state=menus.menustate(translate.getProperty("state"), "State");
		activity=functions.validateint(translate.getProperty("activity"), "Activity");
		
		return new registered_user(dni,name,subname,mobile,email,date_birthday,user,pass,avatar,state,activity);
	}
	public static void savedniadmin (admin admind,idioma translate, users user){
		int pos = -1;
		admind = functions_users.finddniadmin(translate);
		pos = Arraylist_admin.adminfind(admind, translate);
		if (pos != -1) {
			JOptionPane.showMessageDialog(null, "Error");
		}else {
			user.setDni(singleton.dni);
		}
	}
	public static void savedniclient (client clientd, idioma translate, users user){
		int pos = -1;
		clientd = functions_users.finddniclient(translate);
		pos = Arraylist_client.ClientFind(clientd, translate);
		if (pos != -1) {
			JOptionPane.showMessageDialog(null, "Error");
		}else {
			user.setDni(singleton.dni);
		}
	}
	public static void savednireguser (registered_user ruserd, idioma translate, users user){
		int pos = -1;
		ruserd = functions_users.finddniuserreg(translate);
		pos = Arraylist_userreg.UserregFind(ruserd, translate);
		if (pos != -1) {
			JOptionPane.showMessageDialog(null, "Error");
		}else {
			user.setDni(singleton.dni);
		}
	}
	public static void cambiauser(users type, idioma translate){
		int option3;
		String formatdate="";
		
		switch(singleton_global.conf.getDate()){
		case 'a':
			formatdate="dd/MM/yyyy";
			break;
		case 'b':
			formatdate="dd-MM-yyyy";
			break;
		case 'c':
			formatdate="yyyy/MM/dd";
			break;
		case 'd':
			formatdate="yyyy-MM-dd";
			break;
		}
		
		if(type instanceof admin){
			admin admins = new admin();
			
			option3=functions.validateint("Que cambias? \n1 => DNI \n2 => Name \n3 => Subname \n4 => Mobile"
					+ "\n5 => Email \n6 => Date birthday \n7 => User \n8 => Pass"
					+ "\n9 => Avatar \n10 => State \n11 => Hiring date \n12 => Salary \n13 => Activity", "Cambiar");
			switch(option3){
			case 0:
				break;
			case 1:
				//type.setDni(kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate));
				savedniadmin(admins, translate, type);
				break;
			case 2:
				type.setName(kernel.pedirdatos("name",translate.getProperty("name"),"Name", translate));
				break;
			case 3:
				type.setSubname(kernel.pedirdatos("subname",translate.getProperty("subname"),"Subname", translate));
				break;
			case 4:
				type.setMobile(kernel.pedirdatos("mobile",translate.getProperty("phone"),"Mobile", translate));
				break;
			case 5:
				type.setEmail(kernel.pedirdatos("email",translate.getProperty("email"),"Email", translate));
				break;
			case 6:
				type.setDate_birthday(kernel.datebirthday(translate.getProperty("datebirthday")+formatdate,"",translate));
				break;
			case 7:
				type.setUser(functions.validatestring(translate.getProperty("user"), "User"));
				break;
			case 8:
				type.setPass(functions.validatestring(translate.getProperty("pass"), "Password"));
				break;
			case 9:
				type.setAvatar(functions.validatestring(translate.getProperty("avatar"), "Avatar"));
				break;
			case 10:
				type.setState(menus.menustate(translate.getProperty("state"), "State"));
				break;
			case 11:
				((admin)type).setHiring_date(kernel.yearsservice(translate.getProperty("hiring_date")+formatdate, "Up date",type.getDate_birthday(),translate));
				break;
			case 12:
				((admin)type).setSalary(functions.validatefloat(translate.getProperty("salary"), "Salary"));
				break;
			case 13:
				((admin)type).setActivity(functions.validateint(translate.getProperty("activity"), "Activity"));
				break;
			}
		}
		if(type instanceof client){
			client clients = new client();
			
			option3=functions.validateint("Que cambias?\n1 => DNI \n2 => Name \n3 => Subname \n4 => Mobile"
					+ "\n5 => Email \n6 => Date birthday \n7 => User \n8 => Pass"
					+ "\n9 => Avatar \n10 => State \n11 => Up date"
					+ "\n12 => Shopping \n13 => Premium \n14 => Client type", "Cambiar");
			switch(option3){
			case 1:
				//type.setDni(kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate));
				savedniclient(clients, translate, type);
				break;
			case 2:
				type.setName(kernel.pedirdatos("name",translate.getProperty("name"),"Name", translate));
				break;
			case 3:
				type.setSubname(kernel.pedirdatos("subname",translate.getProperty("subname"),"Subname", translate));
				break;
			case 4:
				type.setMobile(kernel.pedirdatos("mobile",translate.getProperty("phone"),"Mobile", translate));
				break;
			case 5:
				type.setEmail(kernel.pedirdatos("email",translate.getProperty("email"),"Email", translate));
				break;
			case 6:
				type.setDate_birthday(kernel.datebirthday(translate.getProperty("datebirthday")+formatdate,"",translate));
				break;
			case 7:
				((client)type).setUser(functions.validatestring(translate.getProperty("user"), "User name"));
				break;
			case 8:
				((client)type).setPass(functions.validatestring(translate.getProperty("pass"), "Password"));
				break;
			case 9:
				((client)type).setAvatar(functions.validatestring(translate.getProperty("avatar"), "Avatar"));
				break;
			case 10:
				((client)type).setState(menus.menustate(translate.getProperty("state"), "State"));
				break;
			case 11:
				((client)type).setUp_date(kernel.yearsservice(translate.getProperty("up_date")+formatdate, "Up date",type.getDate_birthday(),translate));
				break;
			case 12:
				((client)type).setShopping(functions.validatefloat(translate.getProperty("shopping"), "Shop"));
				break;
			case 13:
				((client)type).setPremium(menus.validateboolean(translate.getProperty("premium"), "Premium"));
				break;
			case 14:
				((client)type).setClient_type(functions.validatestring(translate.getProperty("clienttype"), "Client Type"));
				break;
			}
		}
		if(type instanceof registered_user){
			registered_user rusers = new registered_user();
			option3=functions.validateint("Que cambias? \n1 => DNI \n2 => Name \n3 => Subname \n4 => Mobile"
					+ "\n5 => Email \n6 => Date birthday \n7 => User \n8 => Pass"
					+ "\n9 => Avatar \n10 => State \n11 => Activity", "Cambiar");
			switch(option3){
			case 1:
				//type.setDni(kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate));
				savednireguser(rusers, translate, type);
				break;
			case 2:
				type.setName(kernel.pedirdatos("name",translate.getProperty("name"),"Name", translate));
				break;
			case 3:
				type.setSubname(kernel.pedirdatos("subname",translate.getProperty("subname"),"Subname", translate));
				break;
			case 4:
				type.setMobile(kernel.pedirdatos("mobile",translate.getProperty("phone"),"Mobile", translate));
				break;
			case 5:
				type.setEmail(kernel.pedirdatos("email",translate.getProperty("email"),"Email", translate));
				break;
			case 6:
				type.setDate_birthday(kernel.datebirthday(translate.getProperty("datebirthday")+formatdate,"",translate));
				break;
			case 7:
				((registered_user)type).setUser(functions.validatestring(translate.getProperty("user"), "User name"));
				break;
			case 8:
				((registered_user)type).setPass(functions.validatestring(translate.getProperty("pass"), "Password"));
				break;
			case 9:
				((registered_user)type).setAvatar(functions.validatestring(translate.getProperty("avatar"), "Avatar"));
				break;
			case 10:
				((registered_user)type).setState(menus.menustate(translate.getProperty("state"), "State"));
				break;
			case 11:
				((registered_user)type).setActivity(functions.validateint(translate.getProperty("activity"), "Activity"));
				break;
			}
		}
	}
}