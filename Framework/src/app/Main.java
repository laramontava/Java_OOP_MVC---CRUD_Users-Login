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
import app.modules.users.model.utils.dummies;
import app.utils.config_save;
//import app.modules.users.utils.functions_users;
import app.utils.menus;
import app.utils.theme;


public class Main {
	public static void main(String[] args){
		singleton_global.conf = new configuration();
		//System.out.println(singleton_global.conf);
		//JOptionPane.showMessageDialog(null, singleton_global.conf+"     sin archivo");
		config_save.OpenJsonautoconf();
		int option, option2,dummies1;
		boolean exit = false;
		char moneda=' ';
		//System.out.println(singleton_global.conf);
		//JOptionPane.showMessageDialog(null, singleton_global.conf+"      abre archivo");
		singleton_global.translate = new idioma(singleton_global.conf.getLanguage());
		//JOptionPane.showMessageDialog(null, translate +"    idioma");
		//JOptionPane.showMessageDialog(null, singleton_global.conf+"        pilla idioma de conf");
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
		String[] tipo11 = {"Activar","Desactivar"};
		String[] tipo12 = {"Crear admin manual","Crear admin auto"};
		//admin dummies = new admin("12345678Z","Lara","Montava","653231387","lara@gmail.com","26/09/1997","lara","1234",
		//		"avatar","estado","12/12/2015",699.78f,123);
		
		switch(singleton_global.conf.getFormat()){
		case "json":
			json.OpenJsonauto();
			break;
		case "txt":
			txt.Opentxtauto();			
			break;
		case "xml":
			xml.Openxmlauto();
			break;
		}
		
		do{
		String[] tipo = {singleton_global.translate.getProperty("admin"),singleton_global.translate.getProperty("client"),
				singleton_global.translate.getProperty("registered_user"),singleton_global.translate.getProperty("config"),
				singleton_global.translate.getProperty("exit")};
		String[] tipo2 = {singleton_global.translate.getProperty("creat"),singleton_global.translate.getProperty("change_data"),
				singleton_global.translate.getProperty("print"),"Buscar","Ordenar","Eliminar","Abrir","Guardar",
				singleton_global.translate.getProperty("return")};
		String[] tipo3 = {singleton_global.translate.getProperty("date"),singleton_global.translate.getProperty("currency"),
				singleton_global.translate.getProperty("decimal"),singleton_global.translate.getProperty("language"),"Extensión de archivos",
				"Tema","Dummies",singleton_global.translate.getProperty("return")};
		theme.temaElegido(singleton_global.conf.getTheme());
		
		option = menus.mainmenu(tipo, singleton_global.translate.getProperty("Pregcrear"), singleton_global.translate.getProperty("CreateuserT"));
		switch(option){ 
		case 0: //admin
			
			do{
				option2 = menus.mainmenu(tipo2, singleton_global.translate.getProperty("Preghacer"), "Admin main");
				switch(option2){
				case 0: //crear admin
					if(!singleton_global.conf.getDummies())
						singleton.admin.AddAdmin(pideadmin);
					else{
						option2 = menus.mainmenu(tipo12, "¿Cómo quieres crear el admin?", "Create admin");
						switch(option2){
						case 0:
							singleton.admin.AddAdmin(pideadmin);
							break;
						case 1:
							dummies.LoadDummies();
							break;
						}
					}
					//pideadmin=functions_users.pideadmin(conf,translate);
					
					break;
				case 1: //cambiar admin ----
					singleton.admin.editadmin(pideadmin);
					break;
				case 2: //imprimir ---
					singleton.admin.printadmin();
					break;
				case 3://buscar ---
					singleton.admin.adminsearch(pideadmin);
					break;
				case 4://ordenar ---
					option2 = menus.mainmenu(tipo8, "¿Por qué quieres ordenar?", "Ordenar");
					switch(option2){
					case 0://dni ---
						singleton.admin.orderby(0);
						break;
					case 1://nombre ---
						singleton.admin.orderby(1);
						break;
					case 2: //edad ---
						singleton.admin.orderby(2);
						break;
					}
					break;
				case 5://eliminar ---
					singleton.admin.deleteadmin(pideadmin);
					break;
				case 6://abrir ---
					singleton.admin.openfiles();
					break;
				case 7://guardar ---
					singleton.admin.savefiles();
					break;
				}
			}while(option2!=8);
			break;
		case 1: //client
			do{
				option2 = menus.mainmenu(tipo2, singleton_global.translate.getProperty("Preghacer"), "Client main");
				switch(option2){
				case 0:
					singleton.client.AddClient(pidecliente);
					//pidecliente=functions_users.pideclient(conf, translate);
					break;
				case 1:
					singleton.client.EditClient(pidecliente);
					/*if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						functions_users.cambiauser(pidecliente, conf, translate);
					}*/
					break;
				case 2:
					singleton.client.PrintClient();
				/*	if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						JOptionPane.showMessageDialog(null, pidecliente.toString());
					}*/
					break;
				case 3://buscar ---
					singleton.client.clientsearch(pidecliente);
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
					singleton.client.DeleteClient(pidecliente);
					break;
				case 6:
					break;
				case 7:
					break;
				}
			}while(option2!=8);
			break;
		case 2: //registered user
			do{
				option2 = menus.mainmenu(tipo2, singleton_global.translate.getProperty("Preghacer"), "Registered main");
				switch(option2){
				case 0://crear  ---
					singleton.reguser.AddUserreg(pideregistrado);
					//pideregistrado=functions_users.pideregistrado(singleton_global.conf, translate);
					break;
				case 1://cambiar datos  ---
					singleton.reguser.EditUserreg(pideregistrado);
					/*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						functions_users.cambiauser(pideregistrado, singleton_global.conf, translate);
					}*/
					break;
				case 2://imprimir  ---
					singleton.reguser.PrintUserreg();
					/*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						JOptionPane.showMessageDialog(null, pideregistrado.toString());
					}*/
					break;
				case 3://buscar ---
					singleton.reguser.UserregSearch(pideregistrado);
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
					singleton.reguser.DeleteUserreg(pideregistrado);
					break;
				case 6:
					break;
				case 7:
					break;
				}
			}while(option2!=8);//volver
			break;
		case 3: //config
			do{
				option2 = menus.mainmenu(tipo3, singleton_global.translate.getProperty("confmain"), "Configuration main");
				switch(option2){
				case 0://fecha
					option2 = menus.mainmenu(tipo5, singleton_global.translate.getProperty("formatdate"), "Date format");
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
					option2 = menus.mainmenu(tipo4, singleton_global.translate.getProperty("formatcurrency"), "Currency format");
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
					option2 = menus.mainmenu(tipo7, singleton_global.translate.getProperty("formatdecimals"), "Decimal format");
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
					option2 = menus.mainmenu(tipo6, singleton_global.translate.getProperty("Pregidioma"), "Language");
					switch(option2){
					case 0:
						singleton_global.translate.setIdioma("english");
						break;
					case 1:
						singleton_global.translate.setIdioma("castellano");
						break;
					case 2:
						singleton_global.translate.setIdioma("valencia");
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
				case 6: //dummies
					//dummies.LoadDummies();
					dummies1 = menus.mainmenu(tipo11, "Activar o desactivar dummies", "");
					switch(dummies1){
					case 0:
						json.GenerateJsonauto();
						txt.Generatetxtauto();
						xml.Generatexmlauto();
						singleton_global.conf.setDummies(true);
						singleton.admin = new Arraylist_admin();
						switch(singleton_global.conf.getFormat()){
						case "json":
							json.OpenJsonauto();
							break;
						case "txt":
							txt.Opentxtauto();			
							break;
						case "xml":
							xml.Openxmlauto();
							break;
						}
						break;
					case 1:
						json.GenerateJsonauto();
						txt.Generatetxtauto();
						xml.Generatexmlauto();
						singleton_global.conf.setDummies(false);
						singleton.admin = new Arraylist_admin();
						switch(singleton_global.conf.getFormat()){
						case "json":
							json.OpenJsonauto();
							break;
						case "txt":
							txt.Opentxtauto();			
							break;
						case "xml":
							xml.Openxmlauto();
							break;
						}
						break;
					}
					break;
				}
			}while(option2!=7);//volver
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
		//JOptionPane.showMessageDialog(null, singleton_global.conf);
		JOptionPane.showMessageDialog(null, singleton_global.translate.getProperty("goodbye"));
	}
}
