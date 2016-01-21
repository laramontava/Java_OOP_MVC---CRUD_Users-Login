package app.utils;

import javax.swing.JOptionPane;
public class functions {
	
/*Validar datos --------------------*/
	
	//Pide int
	public static int validateint(String message, String title){
		int i = 0;
		String s;
		boolean correct=true;
	
		do{
			try{
				s=JOptionPane.showInputDialog(null, message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					//JOptionPane.showMessageDialog(null, "Saliendo de la aplicación","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}else {
					i=Integer.parseInt(s);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You don't entered a number", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return i;
	}
	
	//Pide int != 0
	public static int validatedifferent0(String message, String title){
		int i = 0;
		String s;
		boolean correct=true;
		
		do{
			try{
				s=JOptionPane.showInputDialog(null, message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					//JOptionPane.showMessageDialog(null, "Saliendo de la aplicación","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}else {
					i=Integer.parseInt(s);
					correct=true;
					if(i==0){
						correct=false;
						JOptionPane.showMessageDialog(null, "The number must be other than 0");
					}
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You don't entered a number", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return i;
	}
	
	//Pide int >= 0
	public static int validateintpositive(String message, String title){
		int i = 0;
		String s;
		boolean correct=true;
		
		do{
			try{
				s=JOptionPane.showInputDialog(null, message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					//JOptionPane.showMessageDialog(null, "Saliendo de la aplicación","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}else {
					i=Integer.parseInt(s);
					correct=true;
					if(i<0){
						correct=false;
						JOptionPane.showMessageDialog(null, "The number must be positive");
					}
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You don't entered a number", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return i;
	}
	
	//Pide char
	public static char validatechar(String message, String title){
		char c = 0;
		String s;
		boolean correct=true;
	
		do{
			try{
				s=JOptionPane.showInputDialog(null, message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					//JOptionPane.showMessageDialog(null, "Saliendo de la aplicación","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}else {
					c=s.charAt(0);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You don't entered a character", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return c;
	}
	
	//Pide float
	public static float validatefloat(String message, String title){
		
		float f=0.0f;
		String s="";
		boolean correct=true;
		do{
			try{
				s=JOptionPane.showInputDialog(null, message,title,JOptionPane.QUESTION_MESSAGE);
				if(s==null){
					//JOptionPane.showMessageDialog(null, "Saliendo de la aplicación","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}else {
					f=Float.parseFloat(s);
					correct=true;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You don't entered a number", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);		
		return (f);
	}
	
	//Pide String
	public static String validatestring(String message, String title) {
		String s="";
		boolean correct=true;

		do{
			try{
				s=JOptionPane.showInputDialog(null, message,title,JOptionPane.QUESTION_MESSAGE);
				correct=true;
				if (s==null){
					//JOptionPane.showMessageDialog(null, "Saliendo de la aplicación","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					//System.exit(0);//al usuario pulsar cancelar o cerrar la vtna del showinputdialog, acaba la ejecución
				}
				if(s.equals("")){
					JOptionPane.showMessageDialog(null, "Data entry error","Error",JOptionPane.ERROR_MESSAGE);
					correct=false;
				}
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "You don't entered a string", "Error",JOptionPane.ERROR_MESSAGE);
				correct=false;
			}
		}while(correct==false);
		return s;
	}
}