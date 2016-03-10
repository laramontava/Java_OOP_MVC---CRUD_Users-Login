package app.modules.users.admin.model.DAO;

import javax.swing.JOptionPane;
import app.classes.singleton_global;
import app.modules.users.admin.model.utils.core.kernel;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.client;
import app.modules.users.admin.model.classes.registered_user;
import app.modules.users.admin.model.classes.singleton;
import app.modules.users.admin.model.classes.users;
import app.modules.users.admin.view.adminnew_view;
import app.utils.functions;
import app.utils.menus;

public class functions_users {
    
	
	public static admin pideadmin(){
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
		name=kernel.pedirdatos("name",singleton_global.translate.getProperty("name"),"Name");
		subname=kernel.pedirdatos("subname",singleton_global.translate.getProperty("subname"),"Subname");
		mobile=kernel.pedirdatos("mobile",singleton_global.translate.getProperty("phone"),"Mobile");
		email=kernel.pedirdatos("email",singleton_global.translate.getProperty("email"),"Email");
		date_birthday=kernel.datebirthday(singleton_global.translate.getProperty("datebirthday")+formatdate,"Date Birthday");
		user=functions.validatestring(singleton_global.translate.getProperty("user"), "User");
		pass=functions.validatestring(singleton_global.translate.getProperty("pass"), "Password");
		avatar=functions.validatestring(singleton_global.translate.getProperty("avatar"), "Avatar");
		state=menus.menustate(singleton_global.translate.getProperty("state"), "State");
		hiring_date=kernel.yearsservice(singleton_global.translate.getProperty("hiring_date")+formatdate,"Hiring date",date_birthday);
		salary=functions.validatefloat(singleton_global.translate.getProperty("salary"), "Salary");
		activity=functions.validateint(singleton_global.translate.getProperty("activity"), "Activity");
		return new admin(dni,name,subname,mobile,email,date_birthday,user,pass,avatar,state,hiring_date,salary,activity);
                
	}
	public static admin finddniadmin(){
		//String dni;
		//dni=kernel.pedirdatos("dni",translate.getProperty("dni"),"DNI", translate);
                
		singleton.dni=kernel.pedirdatos("dni",singleton_global.translate.getProperty("dni"),"DNI");
		return new admin(singleton.dni);
	}
	public static client finddniclient(){
		singleton.dni=kernel.pedirdatos("dni",singleton_global.translate.getProperty("dni"),"DNI");
		return new client(singleton.dni);
	}
	public static registered_user finddniuserreg(){
		singleton.dni=kernel.pedirdatos("dni",singleton_global.translate.getProperty("dni"),"DNI");
		return new registered_user(singleton.dni);
	}
	public static client pideclient(){
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
		name=kernel.pedirdatos("name",singleton_global.translate.getProperty("name"),"Name");
		subname=kernel.pedirdatos("subname",singleton_global.translate.getProperty("subname"),"Subname");
		mobile=kernel.pedirdatos("mobile",singleton_global.translate.getProperty("phone"),"Mobile");
		email=kernel.pedirdatos("email",singleton_global.translate.getProperty("email"),"Email");
		date_birthday=kernel.datebirthday(singleton_global.translate.getProperty("datebirthday")+formatdate,"Date Birthday");
		user=functions.validatestring(singleton_global.translate.getProperty("user"), "User");
		pass=functions.validatestring(singleton_global.translate.getProperty("pass"), "Password");
		avatar=functions.validatestring(singleton_global.translate.getProperty("avatar"), "Avatar");
		state=menus.menustate(singleton_global.translate.getProperty("state"), "State");
		up_date=kernel.yearsservice(singleton_global.translate.getProperty("up_date")+formatdate,"Hiring date",date_birthday);
		shopping=functions.validatefloat(singleton_global.translate.getProperty("shopping"), "Shopping");
		premium=menus.validateboolean(singleton_global.translate.getProperty("premium"), "Premium");
		client_type=functions.validatestring(singleton_global.translate.getProperty("clienttype"), "Client type");
		
		return new client(dni,name,subname,mobile,email,date_birthday,user,pass,avatar,state,up_date,shopping,premium,
				client_type);
	}

	public static registered_user pideregistrado(){
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
		name=kernel.pedirdatos("name",singleton_global.translate.getProperty("name"),"Name");
		subname=kernel.pedirdatos("subname",singleton_global.translate.getProperty("subname"),"Subname");
		mobile=kernel.pedirdatos("mobile",singleton_global.translate.getProperty("phone"),"Mobile");
		email=kernel.pedirdatos("email",singleton_global.translate.getProperty("email"),"Email");
		date_birthday=kernel.datebirthday(singleton_global.translate.getProperty("datebirthday")+formatdate,"Date Birthday");
		user=functions.validatestring(singleton_global.translate.getProperty("user"), "User");
		pass=functions.validatestring(singleton_global.translate.getProperty("pass"), "Password");
		avatar=functions.validatestring(singleton_global.translate.getProperty("avatar"), "Avatar");
		state=menus.menustate(singleton_global.translate.getProperty("state"), "State");
		activity=functions.validateint(singleton_global.translate.getProperty("activity"), "Activity");
		
		return new registered_user(dni,name,subname,mobile,email,date_birthday,user,pass,avatar,state,activity);
	}
	public static void savedniadmin (admin admind, users user){
		int pos = -1;
		admind = functions_users.finddniadmin();
		//pos = Arraylist_admin.adminfind(admind);
		pos = singleton.admin.adminfind(admind);
		if (pos != -1) {
			JOptionPane.showMessageDialog(null, "Error");
		}else {
			user.setDni(singleton.dni);
		}
	}
	public static void savedniclient (client clientd, users user){
		int pos = -1;
		clientd = functions_users.finddniclient();
		pos = singleton.client.ClientFind(clientd);
		if (pos != -1) {
			JOptionPane.showMessageDialog(null, "Error");
		}else {
			user.setDni(singleton.dni);
		}
	}
	public static void savednireguser (registered_user ruserd, users user){
		int pos = -1;
		ruserd = functions_users.finddniuserreg();
		pos = singleton.reguser.UserregFind(ruserd);
		if (pos != -1) {
			JOptionPane.showMessageDialog(null, "Error");
		}else {
			user.setDni(singleton.dni);
		}
	}
	public static void cambiauser(users type){
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
				savedniadmin(admins, type);
				break;
			case 2:
				type.setName(kernel.pedirdatos("name",singleton_global.translate.getProperty("name"),"Name"));
				break;
			case 3:
				type.setSubname(kernel.pedirdatos("subname",singleton_global.translate.getProperty("subname"),"Subname"));
				break;
			case 4:
				type.setMobile(kernel.pedirdatos("mobile",singleton_global.translate.getProperty("phone"),"Mobile"));
				break;
			case 5:
				type.setEmail(kernel.pedirdatos("email",singleton_global.translate.getProperty("email"),"Email"));
				break;
			case 6:
				type.setDate_birthday(kernel.datebirthday(singleton_global.translate.getProperty("datebirthday")+formatdate,""));
				break;
			case 7:
				type.setUser(functions.validatestring(singleton_global.translate.getProperty("user"), "User"));
				break;
			case 8:
				type.setPass(functions.validatestring(singleton_global.translate.getProperty("pass"), "Password"));
				break;
			case 9:
				type.setAvatar(functions.validatestring(singleton_global.translate.getProperty("avatar"), "Avatar"));
				break;
			case 10:
				type.setState(menus.menustate(singleton_global.translate.getProperty("state"), "State"));
				break;
			case 11:
				((admin)type).setHiring_date(kernel.yearsservice(singleton_global.translate.getProperty("hiring_date")+formatdate, "Up date",type.getDate_birthday()));
				break;
			case 12:
				((admin)type).setSalary(functions.validatefloat(singleton_global.translate.getProperty("salary"), "Salary"));
				break;
			case 13:
				((admin)type).setActivity(functions.validateint(singleton_global.translate.getProperty("activity"), "Activity"));
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
				savedniclient(clients, type);
				break;
			case 2:
				type.setName(kernel.pedirdatos("name",singleton_global.translate.getProperty("name"),"Name"));
				break;
			case 3:
				type.setSubname(kernel.pedirdatos("subname",singleton_global.translate.getProperty("subname"),"Subname"));
				break;
			case 4:
				type.setMobile(kernel.pedirdatos("mobile",singleton_global.translate.getProperty("phone"),"Mobile"));
				break;
			case 5:
				type.setEmail(kernel.pedirdatos("email",singleton_global.translate.getProperty("email"),"Email"));
				break;
			case 6:
				type.setDate_birthday(kernel.datebirthday(singleton_global.translate.getProperty("datebirthday")+formatdate,""));
				break;
			case 7:
				((client)type).setUser(functions.validatestring(singleton_global.translate.getProperty("user"), "User name"));
				break;
			case 8:
				((client)type).setPass(functions.validatestring(singleton_global.translate.getProperty("pass"), "Password"));
				break;
			case 9:
				((client)type).setAvatar(functions.validatestring(singleton_global.translate.getProperty("avatar"), "Avatar"));
				break;
			case 10:
				((client)type).setState(menus.menustate(singleton_global.translate.getProperty("state"), "State"));
				break;
			case 11:
				((client)type).setUp_date(kernel.yearsservice(singleton_global.translate.getProperty("up_date")+formatdate, "Up date",type.getDate_birthday()));
				break;
			case 12:
				((client)type).setShopping(functions.validatefloat(singleton_global.translate.getProperty("shopping"), "Shop"));
				break;
			case 13:
				((client)type).setPremium(menus.validateboolean(singleton_global.translate.getProperty("premium"), "Premium"));
				break;
			case 14:
				((client)type).setClient_type(functions.validatestring(singleton_global.translate.getProperty("clienttype"), "Client Type"));
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
				savednireguser(rusers, type);
				break;
			case 2:
				type.setName(kernel.pedirdatos("name",singleton_global.translate.getProperty("name"),"Name"));
				break;
			case 3:
				type.setSubname(kernel.pedirdatos("subname",singleton_global.translate.getProperty("subname"),"Subname"));
				break;
			case 4:
				type.setMobile(kernel.pedirdatos("mobile",singleton_global.translate.getProperty("phone"),"Mobile"));
				break;
			case 5:
				type.setEmail(kernel.pedirdatos("email",singleton_global.translate.getProperty("email"),"Email"));
				break;
			case 6:
				type.setDate_birthday(kernel.datebirthday(singleton_global.translate.getProperty("datebirthday")+formatdate,""));
				break;
			case 7:
				((registered_user)type).setUser(functions.validatestring(singleton_global.translate.getProperty("user"), "User name"));
				break;
			case 8:
				((registered_user)type).setPass(functions.validatestring(singleton_global.translate.getProperty("pass"), "Password"));
				break;
			case 9:
				((registered_user)type).setAvatar(functions.validatestring(singleton_global.translate.getProperty("avatar"), "Avatar"));
				break;
			case 10:
				((registered_user)type).setState(menus.menustate(singleton_global.translate.getProperty("state"), "State"));
				break;
			case 11:
				((registered_user)type).setActivity(functions.validateint(singleton_global.translate.getProperty("activity"), "Activity"));
				break;
			}
		}
	}
}