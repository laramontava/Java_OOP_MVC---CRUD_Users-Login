package app;

import javax.swing.JOptionPane;

import app.classes.configuration;
import app.classes.idioma;
import app.classes.singleton_global;
import app.modules.users.model.BLL.Arraylist_admin;
import app.modules.users.model.BLL.Arraylist_client;
import app.modules.users.model.BLL.Arraylist_userreg;
import app.modules.users.model.BLL.lib_ficheros.json;
import app.modules.users.model.BLL.lib_ficheros.txt;
import app.modules.users.model.BLL.lib_ficheros.xml;
import app.modules.users.model.classes.admin;
import app.modules.users.model.classes.client;
import app.modules.users.model.classes.registered_user;
import app.modules.users.model.classes.singleton;
import app.utils.config_save;
//import app.modules.users.utils.functions_users;
import app.utils.menus;
import app.utils.theme;


public class Main {
	public static void main(String[] args){
		singleton_global.conf = new configuration();
		//System.out.println(singleton_global.conf);
		JOptionPane.showMessageDialog(null, singleton_global.conf+"     sin archivo");
		config_save.OpenJsonautoconf();
		int option, option2;
		boolean exit = false;
		char moneda=' ';
		//System.out.println(singleton_global.conf);
		JOptionPane.showMessageDialog(null, singleton_global.conf+"      abre archivo");
		idioma translate = new idioma(singleton_global.conf.getLanguage());
		JOptionPane.showMessageDialog(null, translate +"    idioma");
		JOptionPane.showMessageDialog(null, singleton_global.conf+"        pilla idioma de conf");
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
		String[] tipo10 = {"Metal","GTK - WINDOWS","CDE/Motif","Nimbus"};
		//admin dummies = new admin("12345678Z","Lara","Montava","653231387","lara@gmail.com","26/09/1997","lara","1234",
		//		"avatar","estado","12/12/2015",699.78f,123);
		
		json.OpenJsonauto();
		txt.Opentxtauto();
		xml.Openxmlauto();
		do{
		String[] tipo = {translate.getProperty("admin"),translate.getProperty("client"),
				translate.getProperty("registered_user"),translate.getProperty("config"),
				translate.getProperty("exit")};
		String[] tipo2 = {translate.getProperty("creat"),translate.getProperty("change_data"),
				translate.getProperty("print"),"Buscar","Ordenar","Eliminar","Abrir","Guardar",
				translate.getProperty("return")};
		String[] tipo3 = {translate.getProperty("date"),translate.getProperty("currency"),
				translate.getProperty("decimal"),translate.getProperty("language"),"Extensión de archivos",
				"Tema",translate.getProperty("return")};
		theme.temaElegido(singleton_global.conf.getTheme());
		
		option = menus.mainmenu(tipo, translate.getProperty("Pregcrear"), translate.getProperty("CreateuserT"));
		switch(option){ 
		case 0: //admin
			
			do{
				option2 = menus.mainmenu(tipo2, translate.getProperty("Preghacer"), "Admin main");
				switch(option2){
				case 0: //crear admin ----
					singleton.admin.AddAdmin(pideadmin, translate);
					//pideadmin=functions_users.pideadmin(conf,translate);
					break;
				case 1: //cambiar admin ----
					singleton.admin.editadmin(pideadmin, translate);
					break;
				case 2: //imprimir ---
					singleton.admin.printadmin(translate);
					break;
				case 3://buscar ---
					singleton.admin.adminsearch(pideadmin, translate);
					break;
				case 4://ordenar ---
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
					singleton.admin.deleteadmin(pideadmin, translate);
					break;
				case 6://abrir ---
					singleton.admin.openfiles();
					/*switch(conf.getFormat()){
					case "json":
						json.OpenJson();
						break;
					case "txt":
						txt.Opentxt();
						break;
					case "xml":
						xml.Openxml();
						break;
					}*/
					break;
				case 7://guardar ---
					singleton.admin.savefiles();
					/*switch(conf.getFormat()){
					case "json":
						json.GenerateJson();
						break;
					case "txt":
						txt.Generatetxt();
						break;
					case "xml":
						xml.Generatexml();
						break;
					}*/
					break;
				}
			}while(option2!=8);
			break;
		case 1: //client
			do{
				option2 = menus.mainmenu(tipo2, translate.getProperty("Preghacer"), "Client main");
				switch(option2){
				case 0:
					singleton.client.AddClient(pidecliente, translate);
					//pidecliente=functions_users.pideclient(conf, translate);
					break;
				case 1:
					singleton.client.EditClient(pidecliente, translate);
					/*if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						functions_users.cambiauser(pidecliente, conf, translate);
					}*/
					break;
				case 2:
					singleton.client.PrintClient(translate);
				/*	if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						JOptionPane.showMessageDialog(null, pidecliente.toString());
					}*/
					break;
				case 3://buscar ---
					singleton.client.clientsearch(pidecliente, translate);
					break;
				case 4://ordenar  ---
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
					singleton.client.DeleteClient(pidecliente, translate);
					break;
				}
			}while(option2!=8);
			break;
		case 2: //registered user
			do{
				option2 = menus.mainmenu(tipo2, translate.getProperty("Preghacer"), "Registered main");
				switch(option2){
				case 0://crear  ---
					singleton.reguser.AddUserreg(pideregistrado, translate);
					//pideregistrado=functions_users.pideregistrado(singleton_global.conf, translate);
					break;
				case 1://cambiar datos  ---
					singleton.reguser.EditUserreg(pideregistrado, translate);
					/*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						functions_users.cambiauser(pideregistrado, singleton_global.conf, translate);
					}*/
					break;
				case 2://imprimir  ---
					singleton.reguser.PrintUserreg(translate);
					/*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						JOptionPane.showMessageDialog(null, pideregistrado.toString());
					}*/
					break;
				case 3://buscar ---
					singleton.reguser.UserregSearch(pideregistrado, translate);
					break;
				case 4://ordenar  ---
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
					singleton.reguser.DeleteUserreg(pideregistrado, translate);
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
						singleton_global.conf.setDate('a');
						break;
					case 1:
						singleton_global.conf.setDate('b');
						break;
					case 2:
						singleton_global.conf.setDate('c');
						break;
					case 3:
						singleton_global.conf.setDate('d');
						break;
					}
					break;
				case 1://moneda
					option2 = menus.mainmenu(tipo4, translate.getProperty("formatcurrency"), "Currency format");
					switch(option2){
					case 0:
						moneda=singleton_global.conf.getCurrency();
						singleton_global.conf.setCurrency('€');
						pideadmin.currency(moneda);
						break;
					case 1:
						moneda=singleton_global.conf.getCurrency();
						singleton_global.conf.setCurrency('$');
						pideadmin.currency(moneda);
						break;
					case 2:
						moneda=singleton_global.conf.getCurrency();
						singleton_global.conf.setCurrency('£');
						pideadmin.currency(moneda);
						break;
					}
					break;
				case 2://decimal
					option2 = menus.mainmenu(tipo7, translate.getProperty("formatdecimals"), "Decimal format");
					switch(option2){
					case 0:
						singleton_global.conf.setDecimal(1);
						break;
					case 1:
						singleton_global.conf.setDecimal(2);
						break;
					case 2:
						singleton_global.conf.setDecimal(3);
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
					option2 = menus.mainmenu(tipo9, "¿Qué formato de archivos quiere utilizar?", "Formato");
					switch(option2){
					case 0:
						singleton_global.conf.setFormat("json");
						break;
					case 1:
						singleton_global.conf.setFormat("txt");
						break;
					case 2:
						singleton_global.conf.setFormat("xml");
						break;
					}
					break;
				case 5: //tema
					option2 = menus.mainmenu(tipo10, "Selecciona un tema", "Theme");
					switch(option2){
					case 0:
						singleton_global.conf.setTheme(0);
						break;
					case 1:
						singleton_global.conf.setTheme(1);
						break;
					case 2:
						singleton_global.conf.setTheme(2);
						break;
					case 3:
						singleton_global.conf.setTheme(3);
						break;
					}
					break;
				}
				
			}while(option2!=6);//volver
			break;
		case 4:
			
			exit = true;
		}
		}while((!exit));
		config_save.GenerateJsonautoconf();
		json.GenerateJsonauto();
		txt.Generatetxtauto();
		xml.Generatexmlauto();
		//System.out.println(singleton_global.conf);
		JOptionPane.showMessageDialog(null, singleton_global.conf);
		JOptionPane.showMessageDialog(null, translate.getProperty("goodbye"));
	}
}
