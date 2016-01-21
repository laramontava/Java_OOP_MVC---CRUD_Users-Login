package app;

import javax.swing.JOptionPane;

import app.modules.users.utils.Arraylist_admin;
import app.modules.users.utils.Arraylist_client;
import app.modules.users.utils.Arraylist_userreg;
import app.modules.users.utils.lib_ficheros.json;
import app.modules.users.utils.lib_ficheros.txt;
import app.modules.users.utils.lib_ficheros.xml;
import app.classes.configuration;
import app.classes.idioma;
import app.modules.users.classes.admin;
import app.modules.users.classes.client;
import app.modules.users.classes.registered_user;
import app.modules.users.classes.singleton;
//import app.modules.users.utils.functions_users;
import app.utils.menus;


public class Main {
	public static void main(String[] args){
		json.OpenJson();
		int option, option2;
		boolean exit = false;
		char moneda=' ';
		idioma translate = new idioma("english");
		configuration conf = new configuration();
		admin pideadmin = new admin();
		client pidecliente = new client();
		registered_user pideregistrado = new registered_user();
		singleton.admin = new Arraylist_admin();
		singleton.client = new Arraylist_client();
		singleton.reguser = new Arraylist_userreg();

		String[] tipo4 = {"€","$","£"};
		String[] tipo5 = {"dd/MM/yyyy","dd-MM-yyyy","yyyy/MM/dd","yyyy-MM-dd"};
		String[] tipo6 = {"English","Castellano","Valencià"};
		String[] tipo7 = {"0,1","0,12","0,123"};
		String[] tipo8 = {"DNI","Nombre","Fecha nacimiento"};
		String[] tipo9 = {".json",".txt",".xml"};
		//admin dummies = new admin("12345678Z","Lara","Montava","653231387","lara@gmail.com","26/09/1997","lara","1234",
		//		"avatar","estado","12/12/2015",699.78f,123);
		
		do{
		String[] tipo = {translate.getProperty("admin"),translate.getProperty("client"),
				translate.getProperty("registered_user"),translate.getProperty("config"),translate.getProperty("exit")};
		String[] tipo2 = {translate.getProperty("creat"),translate.getProperty("change_data"),
				translate.getProperty("print"),"Buscar","Ordenar","Eliminar","Abrir","Guardar",translate.getProperty("return")};
		String[] tipo3 = {translate.getProperty("date"),translate.getProperty("currency"),
				translate.getProperty("decimal"),translate.getProperty("language"),"extensión de archivos",translate.getProperty("return")};
		option = menus.mainmenu(tipo, translate.getProperty("Pregcrear"), translate.getProperty("CreateuserT"));
		switch(option){ 
		case 0: //admin
			
			do{
				option2 = menus.mainmenu(tipo2, translate.getProperty("Preghacer"), "Admin main");
				switch(option2){
				case 0: //crear admin ----
					singleton.admin.AddAdmin(pideadmin, conf, translate);
					//singleton.admin.AddAdmin(functions_users.pideadmin(conf,translate),conf,translate);
					//pideadmin=functions_users.pideadmin(conf,translate);
					break;
				case 1: //cambiar admin
					singleton.admin.editadmin(pideadmin, conf, translate);
					//singleton.admin.editadmin(functions_users.finddniadmin(translate), conf, translate);
					/*if(pideadmin.getDni()==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creata"));
					}
					else{
						functions_users.cambiauser(pideadmin, conf, translate);
					}*/
					break;
				case 2: //imprimir ---
					singleton.admin.printadmin(conf, translate);
					/*if(pideadmin.getDni()==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creata"));
					}
					else{
						JOptionPane.showMessageDialog(null, pideadmin.toString(conf, translate));
						//JOptionPane.showMessageDialog(null, dummies.toString(conf, translate));
					}*/
					break;
				case 3://buscar ---
					singleton.admin.adminsearch(pideadmin, conf, translate);
					break;
				case 4://ordenar
					option2 = menus.mainmenu(tipo8, "¿Por qué quieres ordenar?", "Ordenar");
					switch(option2){
					case 0://dni
						singleton.admin.orderby(0);
						break;
					case 1://nombre
						singleton.admin.orderby(1);
						break;
					case 2: 
						singleton.admin.orderby(2);
						break;
					}
					break;
				case 5://eliminar ---
					singleton.admin.deleteadmin(pideadmin, conf, translate);
					break;
				case 6://abrir
					json.OpenJson();
					break;
				case 7://guardar
					json.GenerateJson();
					break;
				}
			}while(option2!=8);
			break;
		case 1: //client
			do{
				option2 = menus.mainmenu(tipo2, translate.getProperty("Preghacer"), "Client main");
				switch(option2){
				case 0:
					singleton.client.AddClient(pidecliente, conf, translate);
					//pidecliente=functions_users.pideclient(conf, translate);
					break;
				case 1:
					singleton.client.EditClient(pidecliente, conf, translate);
					/*if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						functions_users.cambiauser(pidecliente, conf, translate);
					}*/
					break;
				case 2:
					singleton.client.PrintClient(conf, translate);
				/*	if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						JOptionPane.showMessageDialog(null, pidecliente.toString());
					}*/
					break;
				case 3://buscar ---
					singleton.client.clientsearch(pidecliente, conf, translate);
					break;
				case 4://ordenar
					option2 = menus.mainmenu(tipo8, "¿Por qué quieres ordenar?", "Ordenar");
					switch(option2){
					case 0://dni
						singleton.client.orderby(0);
						break;
					case 1://nombre
						singleton.client.orderby(1);
						break;
					case 2: 
						singleton.client.orderby(2);
						break;
					}
					break;
				case 5://eliminar ---
					singleton.client.DeleteClient(pidecliente, conf, translate);
					break;
				}
			}while(option2!=8);
			break;
		case 2: //registered user
			do{
				option2 = menus.mainmenu(tipo2, translate.getProperty("Preghacer"), "Registered main");
				switch(option2){
				case 0://crear
					singleton.reguser.AddUserreg(pideregistrado, conf, translate);
					//pideregistrado=functions_users.pideregistrado(conf, translate);
					break;
				case 1://cambiar datos
					singleton.reguser.EditUserreg(pideregistrado, conf, translate);
					/*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						functions_users.cambiauser(pideregistrado, conf, translate);
					}*/
					break;
				case 2://imprimir
					singleton.reguser.PrintUserreg(conf, translate);
					/*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						JOptionPane.showMessageDialog(null, pideregistrado.toString());
					}*/
					break;
				case 3://buscar ---
					singleton.reguser.UserregSearch(pideregistrado, conf, translate);
					break;
				case 4://ordenar
					option2 = menus.mainmenu(tipo8, "¿Por qué quieres ordenar?", "Ordenar");
					switch(option2){
					case 0://dni
						singleton.reguser.orderby(0);
						break;
					case 1://nombre
						singleton.reguser.orderby(1);
						break;
					case 2: 
						singleton.reguser.orderby(2);
						break;
					}
					break;
				case 5://eliminar ---
					singleton.reguser.DeleteUserreg(pideregistrado, conf, translate);
					break;
				}
			}while(option2!=8);//volver
			break;
		case 3: //config
			do{
				option2 = menus.mainmenu(tipo3, translate.getProperty("confmain"), "Configuration main");
				switch(option2){
				case 0://fecha
					option2 = menus.mainmenu(tipo5, translate.getProperty("formatdate"), "Date format");
					switch(option2){
					case 0:
						conf.setDate('a');
						break;
					case 1:
						conf.setDate('b');
						break;
					case 2:
						conf.setDate('c');
						break;
					case 3:
						conf.setDate('d');
						break;
					}
					break;
				case 1://moneda
					option2 = menus.mainmenu(tipo4, translate.getProperty("formatcurrency"), "Currency format");
					switch(option2){
					case 0:
						moneda=conf.getCurrency();
						conf.setCurrency('€');
						pideadmin.currency(conf,moneda);
						break;
					case 1:
						moneda=conf.getCurrency();
						conf.setCurrency('$');
						pideadmin.currency(conf,moneda);
						break;
					case 2:
						moneda=conf.getCurrency();
						conf.setCurrency('£');
						pideadmin.currency(conf,moneda);
						break;
					}
					break;
				case 2://decimal
					option2 = menus.mainmenu(tipo7, translate.getProperty("formatdecimals"), "Decimal format");
					switch(option2){
					case 0:
						conf.setDecimal(1);
						break;
					case 1:
						conf.setDecimal(2);
						break;
					case 2:
						conf.setDecimal(3);
						break;
					}
					break;
				case 3://language
					option2 = menus.mainmenu(tipo6, translate.getProperty("Pregidioma"), "Language");
					switch(option2){
					case 0:
						translate.setIdioma("english");
						break;
					case 1:
						translate.setIdioma("castellano");
						break;
					case 2:
						translate.setIdioma("valencia");
						break;
					}
					break;
				case 4://extensión archivos
					option2 = menus.mainmenu(tipo9, "¿Qué formato de archivos quieres abrir?", "Formato");
					switch(option2){
					case 0:
						conf.setFormat("json");
						break;
					case 1:
						conf.setFormat("txt");
						break;
					case 2:
						conf.setFormat("xml");
						break;
					}
					break;
				}
			}while(option2!=5);//volver
			break;
		case 4:
			JOptionPane.showMessageDialog(null, translate.getProperty("goodbye"));
			//System.exit(0);
			exit = true;
		}
		}while((exit==false));//||(option!=4)
		json.GenerateJson();
	}
}
