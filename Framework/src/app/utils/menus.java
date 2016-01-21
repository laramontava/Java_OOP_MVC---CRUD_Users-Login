package app.utils;

import javax.swing.JOptionPane;

public class menus {
/*Menús --------------------*/
	
	//Menú principal
	public static int mainmenu(String[]type, String message, String title){
		int option=0;
		
		option = JOptionPane.showOptionDialog(null,
						message,title,0,
						JOptionPane.QUESTION_MESSAGE,null,type,type[0]);	
		return option;
	}
	//menú botones sí/no
		public static boolean validateboolean(String message, String title){
			int option=0;
			boolean i = true;
			String[] tipo={"Yes","No"};
			option=mainmenu(tipo, message, title);
			if(option==0){
				i=true;
			}
			else{
				i=false;
			}
			return i;
		}
		//menú online/offline
				public static String menustate(String message, String title){
					int option=0;
					String s = "";
					String[] tipo={"Online","Offline"};
					option=mainmenu(tipo, message, title);
					if(option==0){
						s="Online";
					}
					else{
						s="Offline";
					}
					return s;
				}
	//Menú String (karma con 3 botones)
		public static String stringmain(String message, String title){
			int option=0;
			String s = "";
			String[] tipo={"Low","Medium","Hight"};
			option=mainmenu(tipo, message, title);
			if(option==0){
				s+=("Low");
			}
			if(option==1){
				s+=("Medium");
			}
			if(option==2){
				s+=("Hight");
			}
			return s;
		}
}
