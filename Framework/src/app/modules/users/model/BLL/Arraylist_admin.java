package app.modules.users.model.BLL;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import app.classes.singleton_global;
import app.modules.users.model.BLL.lib_ficheros.json;
import app.modules.users.model.BLL.lib_ficheros.txt;
import app.modules.users.model.BLL.lib_ficheros.xml;
import app.modules.users.model.DAO.functions_users;
import app.modules.users.model.classes.admin;
import app.modules.users.model.classes.orderdatebirthday;
import app.modules.users.model.classes.ordername;

public class Arraylist_admin {
	private ArrayList<admin> admins = new ArrayList<admin>();
	
	public Arraylist_admin(){
	}
	public ArrayList<admin> getAdmins() {
		return admins;
	}
	public void setAdmins(ArrayList<admin> admins) {
		this.admins = admins;
	}

	public  void AddAdmin(admin admind){
		int pos = -1;
		admind = functions_users.finddniadmin();
		pos = adminfind(admind);
		if(pos!=-1){
			JOptionPane.showMessageDialog(null, "Existe");
		}
		else{
			admind = functions_users.pideadmin();
			admins.add(admind);
		}
	}
	public void AddDummies(admin admind){
		admins.add(admind);
	}
	public void editadmin(admin admind){
		int pos = -1;
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n admin creado");
		} else{
			pos = -1;
			admind = functions_users.finddniadmin();
			pos = adminfind(admind);
			if(pos != -1){
				//admins.get(pos);
				functions_users.cambiauser(admins.get(pos));
				//admins.set(pos, admind);
			} else{
				JOptionPane.showMessageDialog(null, "Existe");
			}
		}
	}
	public void printadmin(){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n admin creado");
		} else{
			for(int i = 0; i<admins.size();i++){
				JOptionPane.showMessageDialog(null, admins.get(i).toString());
			}
		}
	}
	public void orderby(int i){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n admin creado");
		} else{
			switch(i){
			case 0:
				Collections.sort(admins);
				break;
			case 1:
				Collections.sort(admins, new ordername());
				break;
			case 2:
				Collections.sort(admins, new orderdatebirthday());
				break;
			}
		}
	}
	//Collections.sort(AL_cli); compareto user => dni
	public void adminsearch(admin pideadmin){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n admin creado");
		} else{
			pideadmin = functions_users.finddniadmin();
			for (int i = 0; i<=admins.size()-1; i++){
				if((admins.get(i)).equals(pideadmin) )
					JOptionPane.showMessageDialog(null, admins.get(i).toString());
			}
		}
	}
	public int adminfind(admin admind) { 
		for (int i = 0; i<=admins.size()-1; i++){
			if((admins.get(i)).equals(admind) )
				return i;
		}
		return -1;
	}
	
	public void deleteadmin(admin pideadmin){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n admin creado");
		} else{
			pideadmin = functions_users.finddniadmin();
			//pideadmin = functions.validatestring("Introdudce DNI del admin que quiers eliminar", "Delete");
			for (int i = 0; i<=admins.size()-1; i++){
				if((admins.get(i)).equals(pideadmin) )
					admins.remove(i);
			}
		}
	}
	public void openfiles(){
		switch(singleton_global.conf.getFormat()){
		case "json":
			json.OpenJson();
			break;
		case "txt":
			txt.Opentxt();
			break;
		case "xml":
			xml.Openxml();
			break;
		}
	}
	
	public void savefiles(){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ning�n admin creado");
		}else{
			switch(singleton_global.conf.getFormat()){
			case "json":
				json.GenerateJson();
				break;
			case "txt":
				txt.Generatetxt();
				break;
			case "xml":
				xml.Generatexml();
				break;
			}
		}
	}
	/*public int ordenarnombre(admin pideadmin){
		if(pideadmin.getName().equals(admins.)>0)
			return 1;
		if(pideadmin.getName().compareTo(v2.getNombreEmpleado())<0)
			return -1;
		return 0;
	}
	public void delete(int position){
		admins.remove(position);
	}
	public static void main(String[]args){
		Arraylist_admin admind = new Arraylist_admin();
		configuration conf = new configuration();
		admin[] admininfo= null;
		
		int adminint;
		admind.AddData(new admin("12345678Z","Lara","Montava","653231387","lara@gmail.com","26/09/1997","lara","1234",
					"avatar","estado","12/12/2015",699.78f,123));
		admind.AddData(new admin("12345678Z","Pepe","Montava","653231387","lara@gmail.com","26/09/1997","lara","1234",
				"avatar","estado","12/12/2015",699.78f,123));
		admininfo=admind.print();
		JOptionPane.showMessageDialog(null, admininfo);

		
		
	}	*/
	
}
