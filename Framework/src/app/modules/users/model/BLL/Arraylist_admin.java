package app.modules.users.model.BLL;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import app.classes.configuration;
import app.classes.idioma;
import app.classes.singleton_global;
import app.modules.users.model.BLL.lib_ficheros.json;
import app.modules.users.model.BLL.lib_ficheros.txt;
import app.modules.users.model.BLL.lib_ficheros.xml;
import app.modules.users.model.DAO.functions_users;
import app.modules.users.model.classes.admin;
import app.modules.users.model.classes.orderdatebirthday;
import app.modules.users.model.classes.ordername;
import app.modules.users.model.classes.singleton;


public class Arraylist_admin {
	private static ArrayList<admin> admins = new ArrayList<admin>();
	
	public Arraylist_admin(){
	}
	public static ArrayList<admin> getAdmins() {
		return admins;
	}
	public static void setAdmins(ArrayList<admin> admins) {
		Arraylist_admin.admins = admins;
	}

	public  void AddAdmin(admin admind,idioma translate){
		int pos = -1;
		admind = functions_users.finddniadmin(translate);
		pos = adminfind(admind, translate);
		if(pos!=-1){
			JOptionPane.showMessageDialog(null, "Existe");
		}
		else{
			admind = functions_users.pideadmin(translate);
			admins.add(admind);
		}
	}
	
	public void editadmin(admin admind, idioma translate){
		int pos = -1;
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
		} else{
			pos = -1;
			admind = functions_users.finddniadmin(translate);
			pos = adminfind(admind, translate);
			if(pos != -1){
				//admins.get(pos);
				functions_users.cambiauser(admins.get(pos), translate);
				//admins.set(pos, admind);
			} else{
				JOptionPane.showMessageDialog(null, "Existe");
			}
		}
	}
	public void printadmin(idioma translate){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
		} else{
			for(int i = 0; i<admins.size();i++){
				JOptionPane.showMessageDialog(null, admins.get(i).toString(singleton_global.conf, translate));
			}
		}
	}
	public void orderby(int i){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
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
	public void adminsearch(admin pideadmin,idioma translate){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
		} else{
			pideadmin = functions_users.finddniadmin(translate);
			for (int i = 0; i<=admins.size()-1; i++){
				if((admins.get(i)).equals(pideadmin) )
					JOptionPane.showMessageDialog(null, admins.get(i).toString(singleton_global.conf, translate));
			}
		}
	}
	public static int adminfind(admin admind, idioma translate) { 
		for (int i = 0; i<=admins.size()-1; i++){
			if((admins.get(i)).equals(admind) )
				return i;
		}
		return -1;
	}
	
	public void deleteadmin(admin pideadmin, idioma translate){
		if(admins.isEmpty()){
			JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
		} else{
			pideadmin = functions_users.finddniadmin(translate);
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
			JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
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
