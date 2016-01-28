package app.modules.users.model.BLL;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import app.classes.configuration;
import app.classes.idioma;
import app.classes.singleton_global;
import app.modules.users.model.DAO.functions_users;
import app.modules.users.model.classes.admin;
import app.modules.users.model.classes.orderdatebirthday;
import app.modules.users.model.classes.ordername;
import app.modules.users.model.classes.registered_user;


public class Arraylist_userreg {
	private static ArrayList<registered_user> rusers = new ArrayList<registered_user>();
	
	public Arraylist_userreg(){
		
	}
	public static ArrayList<registered_user> getUserreg() {
		return rusers;
	}
	public static void setUserreg(ArrayList<registered_user> rusers) {
		Arraylist_userreg.rusers = rusers;
	}
	public  void AddUserreg(registered_user ruserd,idioma translate){
		int pos = -1;
		ruserd = functions_users.finddniuserreg(translate);
		JOptionPane.showMessageDialog(null, ruserd);
		pos = UserregFind(ruserd, translate);
		if(pos!=-1){
			JOptionPane.showMessageDialog(null, "Existe");
		}
		else{
			ruserd = functions_users.pideregistrado(translate);
			rusers.add(ruserd);
		}
	}
	
	public void EditUserreg(registered_user ruserd, idioma translate){
		int pos = -1;
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado creado");
		} else{
			pos = -1;
			ruserd = functions_users.finddniuserreg(translate);
			pos = UserregFind(ruserd, translate);
			if(pos != -1){
				//admins.get(pos);
				functions_users.cambiauser(rusers.get(pos), translate);
				//admins.set(pos, admind);
			} else{
				JOptionPane.showMessageDialog(null, "Existe");
			}
		}
		
	}
	public void PrintUserreg(idioma translate){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado creado");
		} else{
			for(int i = 0; i<rusers.size();i++){
				JOptionPane.showMessageDialog(null, rusers.get(i).toString(singleton_global.conf, translate));
			}
		}
	}
	public void orderby(int i){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado creado");
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
	public void UserregSearch(registered_user ruserd, idioma translate){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado creado");
		} else{
			ruserd = functions_users.finddniuserreg(translate);
			for (int i = 0; i<=rusers.size()-1; i++){
				if((rusers.get(i)).equals(ruserd) )
					JOptionPane.showMessageDialog(null, rusers.get(i).toString(singleton_global.conf, translate));
			}
		}
	}
	public static int UserregFind(registered_user ruserd,idioma translate) { 
		for (int i = 0; i<=rusers.size()-1; i++){
			if((rusers.get(i)).equals(ruserd) )
				return i;
		}
		return -1;
	}
	
	public void DeleteUserreg(registered_user ruserd, idioma translate){
		if(rusers.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún usuario registrado creado");
		} else{
			ruserd = functions_users.finddniuserreg(translate);
			for (int i = 0; i<=rusers.size()-1; i++){
				if((rusers.get(i)).equals(ruserd) )
					rusers.remove(i);
			}
		}
	}	
}
