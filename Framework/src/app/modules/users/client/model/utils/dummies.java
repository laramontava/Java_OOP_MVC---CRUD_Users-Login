package app.modules.users.client.model.utils;

import app.modules.users.client.model.classes.client;
import app.modules.users.client.model.classes.singleton_client;
import app.utils.functions;

public class dummies {
	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

	public static void LoadDummies() {
    	int num=0;
    	String dnidummie="";
        num = functions.validateintpositive("�Cuantos dummies?", "Dummies");
        for (int i = 0; i < num; i++) {
        	int DNI = (int)(Math.random()*100000000);
        	dnidummie=letra(DNI);
            client ad = new client(dnidummie, RandomNombre(), RandomSurname(), "888888888", "dummie@dummie.com", "26/09/1990",
			"Dummie", "1234", "Avatar.jpg", "Offline", "12/12/2014", 700.78f,
			"Premium", "Tipo");
            
            singleton_client.client.AddDummies(ad);
        }
    }
	
    public static final String DNI = "TRWAGMYFPDXBNJZSQVHLCKET";
    public static String letra(int num){
    	return String.valueOf(num) + DNI.charAt(num%23);
    }
    
    public static String RandomNombre() {
        String[] nombres = {"Santiago", "Rafa", "Joan", "Maria", "Daniel", "Josep", "Sara", "Pepa", "Felipe",
            "Jaume", "Sergio", "Paco", "Emilio", "Nando", "Alfons", "Eduardo", "Natalia", "Veronica", "Fina","Pepe",
            "Oscar", "Lorena", "Ana", "Lola", "Laia", "Usopp", "Jordi", "Ramon", "Javier", "Nuria", "Helena", 
            "Beltran", "Pablo", "Juan"};
        
        int posicio0 = (int) (Math.random() * 222) % 10;

        return  nombres[posicio0];
    }
    
    public static String RandomSurname(){
    	String[] apellido = {"Pedrosa", "Borreguero", "Segura", "Tortajada", "Huertas", "Bonet","Romera",
    			"Constantin", "Blanes", "Hortelano", "Pedrosa", "Benitez", "Prado", "Cifuentes","Quevedo","Vigo", 
    			"Lugo", "Villalobos", "Climent", "Torrijos", "Bertomeu", "Ferreras", "Canovas", "Gijon", "Sendra", 
    			"Gaya", "Bernat", "Gabaldon", "Cruces", "Vasquez", "Guijarro", "Navarrete", "Camps", "Pedrosa"};
    	
    	int posicio0 = (int) (Math.random() * 222) % 10;
    	
    	return apellido[posicio0];
    }
}
