package app.modules.users.utils;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import app.classes.configuration;
import app.classes.idioma;
import app.modules.users.classes.client;
import app.modules.users.classes.orderdatebirthday;
import app.modules.users.classes.ordername;
import app.modules.users.utils.functions_users;


public class Arraylist_client {
	private static ArrayList<client> clients = new ArrayList<client>();
	
	public Arraylist_client(){
		
	}
	public  void AddClient(client clientd,configuration conf,idioma translate){
		int pos = -1;
		clientd = functions_users.finddniclient(translate);
		pos = ClientFind(clientd, conf, translate);
		if(pos!=-1){
			JOptionPane.showMessageDialog(null, "Existe");
		}
		else{
			clientd = functions_users.pideclient(conf, translate);
			clients.add(clientd);
		}
	}
	
	public void EditClient(client clientd, configuration conf, idioma translate){
		int pos = -1;
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			clientd = functions_users.finddniclient(translate);
			pos = ClientFind(clientd, conf, translate);
			if(pos != -1){
				functions_users.cambiauser(clients.get(pos), conf, translate);
			} else{
				JOptionPane.showMessageDialog(null, "Existe");
			}
		}
		
	}
	public void PrintClient(configuration conf, idioma translate){
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			for(int i = 0; i<clients.size();i++){
				JOptionPane.showMessageDialog(null, clients.get(i).toString(conf, translate));
			}
		}
	}
	public void orderby(int i){
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			switch(i){
			case 0:
				Collections.sort(clients);
				break;
			case 1:
				Collections.sort(clients, new ordername());
				break;
			case 2:
				Collections.sort(clients, new orderdatebirthday());
				break;
			}
		}
	}
	//Collections.sort(AL_cli); compareto user => dni
	public void clientsearch(client pidecliente,configuration conf, idioma translate){
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			pidecliente = functions_users.finddniclient(translate);
			
			for (int i = 0; i<=clients.size()-1; i++){
				if((clients.get(i)).equals(pidecliente) ){
					JOptionPane.showMessageDialog(null, clients.get(i).toString(conf, translate));
					}
				else{
					JOptionPane.showMessageDialog(null,"No se ha encontrado");
				}
			}
		}
	}
	public static int ClientFind(client clientd,configuration conf, idioma translate) { 
		for (int i = 0; i<=clients.size()-1; i++){
			if((clients.get(i)).equals(clientd) )
				return i;
		}
		return -1;
	}
	
	public void DeleteClient(client pidecliente,configuration conf, idioma translate){
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			pidecliente = functions_users.finddniclient(translate);
			//pidecliente.setDni(kernel.pedirdatos("dni", "Introduce DNI que quieres buscar", "Buscar", translate));
			for (int i = 0; i<=clients.size()-1; i++){
				if((clients.get(i)).equals(pidecliente) )
					clients.remove(i);
			}
		}
	}	
}
