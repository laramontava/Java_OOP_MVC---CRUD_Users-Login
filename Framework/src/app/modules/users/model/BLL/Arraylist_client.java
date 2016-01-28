package app.modules.users.model.BLL;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import app.modules.users.model.DAO.functions_users;
import app.modules.users.model.classes.client;
import app.modules.users.model.classes.orderdatebirthday;
import app.modules.users.model.classes.ordername;


public class Arraylist_client {
	private static ArrayList<client> clients = new ArrayList<client>();
	
	public Arraylist_client(){
		
	}
	public static ArrayList<client> getClients() {
		return clients;
	}
	public static void setClients(ArrayList<client> clients) {
		Arraylist_client.clients = clients;
	}
	
	public  void AddClient(client clientd){
		int pos = -1;
		clientd = functions_users.finddniclient();
		pos = ClientFind(clientd);
		if(pos!=-1){
			JOptionPane.showMessageDialog(null, "Existe");
		}
		else{
			clientd = functions_users.pideclient();
			clients.add(clientd);
		}
	}
	
	public void EditClient(client clientd){
		int pos = -1;
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			clientd = functions_users.finddniclient();
			pos = ClientFind(clientd);
			if(pos != -1){
				functions_users.cambiauser(clients.get(pos));
			} else{
				JOptionPane.showMessageDialog(null, "Existe");
			}
		}
		
	}
	public void PrintClient(){
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			for(int i = 0; i<clients.size();i++){
				JOptionPane.showMessageDialog(null, clients.get(i).toString());
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
	public void clientsearch(client pidecliente){
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			pidecliente = functions_users.finddniclient();
			
			for (int i = 0; i<=clients.size()-1; i++){
				if((clients.get(i)).equals(pidecliente) ){
					JOptionPane.showMessageDialog(null, clients.get(i).toString());
					}
				else{
					JOptionPane.showMessageDialog(null,"No se ha encontrado");
				}
			}
		}
	}
	public static int ClientFind(client clientd) { 
		for (int i = 0; i<=clients.size()-1; i++){
			if((clients.get(i)).equals(clientd) )
				return i;
		}
		return -1;
	}
	
	public void DeleteClient(client pidecliente){
		if(clients.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
		} else{
			pidecliente = functions_users.finddniclient();
			//pidecliente.setDni(kernel.pedirdatos("dni", "Introduce DNI que quieres buscar", "Buscar", translate));
			for (int i = 0; i<=clients.size()-1; i++){
				if((clients.get(i)).equals(pidecliente) )
					clients.remove(i);
			}
		}
	}	
}
