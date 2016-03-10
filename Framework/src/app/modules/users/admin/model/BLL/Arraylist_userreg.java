package app.modules.users.admin.model.BLL;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import app.modules.users.admin.model.DAO.functions_users;
import app.modules.users.admin.model.classes.orderdatebirthday;
import app.modules.users.admin.model.classes.ordername;
import app.modules.users.admin.model.classes.registered_user;


public class Arraylist_userreg {
	private ArrayList<registered_user> rusers = new ArrayList<registered_user>();
	
	public Arraylist_userreg(){
		
	}
	public ArrayList<registered_user> getUserreg() {
		return rusers;
	}
	public void setUserreg(ArrayList<registered_user> rusers) {
		this.rusers = rusers;
	}
	public  void AddUserreg(registered_user ruserd){
		int pos = -1;
		ruserd = functions_users.finddniuserreg();
		JOptionPane.showMessageDialog(null, ruserd);
		pos = UserregFind(ruserd);
		if(pos!=-1){
			JOptionPane.showMessageDialog(null, "Existe");
		}
		else{
			ruserd = functions_users.pideregistrado();
			rusers.add(ruserd);
		}
	}
	
	public void EditUserreg(registered_user ruserd){
		int pos = -1;
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
		} else{
			pos = -1;
			ruserd = functions_users.finddniuserreg();
			pos = UserregFind(ruserd);
			if(pos != -1){
				//admins.get(pos);
				functions_users.cambiauser(rusers.get(pos));
				//admins.set(pos, admind);
			} else{
				JOptionPane.showMessageDialog(null, "Existe");
			}
		}
		
	}
	public void PrintUserreg(){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
		} else{
			for(int i = 0; i<rusers.size();i++){
				JOptionPane.showMessageDialog(null, rusers.get(i).toString());
			}
		}
	}
	public void orderby(int i){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
		} else{
			switch(i){
			case 0:
				Collections.sort(rusers);
				break;
			case 1:
				Collections.sort(rusers, new ordername());
				break;
			case 2:
				Collections.sort(rusers, new orderdatebirthday());
				break;
			}
		}
	}
	//Collections.sort(AL_cli); compareto user => dni
	public void UserregSearch(registered_user ruserd){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
		} else{
			ruserd = functions_users.finddniuserreg();
			for (int i = 0; i<=rusers.size()-1; i++){
				if((rusers.get(i)).equals(ruserd) )
					JOptionPane.showMessageDialog(null, rusers.get(i).toString());
			}
		}
	}
	public int UserregFind(registered_user ruserd) { 
		for (int i = 0; i<=rusers.size()-1; i++){
			if((rusers.get(i)).equals(ruserd) )
				return i;
		}
		return -1;
	}
	
	public void DeleteUserreg(registered_user ruserd){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
		} else{
			ruserd = functions_users.finddniuserreg();
			for (int i = 0; i<=rusers.size()-1; i++){
				if((rusers.get(i)).equals(ruserd) )
					rusers.remove(i);
			}
		}
	}	
}
