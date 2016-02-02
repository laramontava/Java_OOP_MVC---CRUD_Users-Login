package app.modules.users.model.utils;

import app.modules.users.model.classes.admin;
import app.modules.users.model.classes.singleton;
import app.utils.functions;
//import java.util.Random;

public class dummies {
	public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";

	public static void LoadDummies() {
    	int num=0;
        num = functions.validateintpositive("¿Cuantos dummies?", "Dummies");
        for (int i = 0; i < num; i++) {
            admin ad = new admin("00000000T",RandomNombre(),RandomSurname(),"888888888","dummie@dummie.com","26/09/1990","Dummie","1234",
            		"Avatar","Offline","12/12/2014",699.78f,123);
            
            singleton.admin.AddDummies(ad);
        }
    }
    
    public static String RandomNombre() {

        String[] nombres = {"SANTIAGO", "RAFA", "JOAN", "MARIA", "DANIEL", "JOSEP", "SARA", "PEPA", "FELIPE",
            "JAUME", "SERGIO", "PACO", "EMILIO", "NANDO", "ALFONS", "EDUARD", "ATALIA", "VERONICA", "FINA", "PEPE",
            "OSCAR", "LORELAY", "JIM", "LOLA", "LAIA", "USOPP", "JORDI", "RAMON", "JAVIER", "NURIA", "ELENA", "BELTRAN", "PABLO", "JUANJO"};
        
        int posicio0 = (int) (Math.random() * 222) % 10;

        return  nombres[posicio0];
    }
    public static String RandomSurname(){
    	String[] apellido = {"LAFUENTE PEDROSA", "MONROY BORREGUERO", "SEGURA CORTES", "TORTAJADA", "HUERTAS", "CONSTANTIN", "BLANES", "HORTELANO", "PEDROSA",
    	        "BENITEZ", "PRADO", "CIFUENTES", "QUEVEDO", "VIGO", "LUGO", "VILLALOBOS", "CLEMENT", "TORRIJOS", "BERTOMEU", "FERRERAS",
    	        "CANOVAS", "GIJON", "SENDRA", "GAYA", "BERNAT", "GABALDON", "CRUCES", "VASQUEZ", "GUIJARRO", "NAVARRETE", "CAMPS", "PEDROSA", "ROMERA", "BONET"};
    	
    	int posicio0 = (int) (Math.random() * 222) % 10;
    	
    	return apellido[posicio0];
    }
        
    //http://aprenderaprogramar.es/index.php?option=com_content&view=article&id=240:generacion-de-numeros-aleatorios-en-java-rangos-clase-random-ejemplos-ejercicios-resueltos-cu00906c&catid=58:curso-lenguaje-programacion-java-nivel-avanzado-i&Itemid=180
}
