package app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validate {
	
	private static final String plantilla_nombre="^[a-záéíóúñA-ZÁÉÍÓÚÑ\\s]*$";
	private static final String plantilla_tlf="^[0-9]{2,3}-? ?[0-9]{6,7}$";
	private static final String plantilla_email=("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	private static final String fecha_ddmmyyyy1="(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d";
	private static final String fecha_ddmmyyyy2="(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-](19|20)\\d\\d";
	private static final String fecha_yyyymmdd1="(19|20)\\d\\d[/](0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])";
	private static final String fecha_yyyymmdd2="(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])";
	private static final String plantilla_edad="^[0-9]{1,2}$";
	private static final String plantilla_dni = "^([0-9]{8})[A-Z]{1}$";
        private static final String plantilla_salario="[0-9]+(\\.[0-9]{1,3})?";
        private static final String plantilla_numeroentero="[0-9]{0,6}";
	
        private static final String plantilla_compras="[0-9]+(\\.[0-9]{1,3})?";
        private static final String plantilla_tipo="^[a-záéíóúñA-ZÁÉÍÓÚÑ\\s]*$";
        
        
	public static boolean validaNombre(String nombre){
        Pattern pattern=Pattern.compile(plantilla_nombre);
        Matcher matcher = pattern.matcher(nombre);
		if(matcher.matches()){
		return true;
			
		  } else{
                    return false; 
                }
                    
	}
        
        public static boolean validaTipo(String tipo){
        Pattern pattern=Pattern.compile(plantilla_tipo);
        Matcher matcher = pattern.matcher(tipo);
		if(matcher.matches()){
		return true;
			
		  } else{
                    return false; 
                }
                    
	}
        
        public static boolean validaCompras(String compras){
        Pattern pattern=Pattern.compile(plantilla_compras);
        Matcher matcher = pattern.matcher(compras);
		if(matcher.matches()){
		return true;
			
		  } else{
                    return false; 
                }
                    
	}
	
	public static boolean validaTelefono(String tlf){
		Pattern pattern=Pattern.compile(plantilla_tlf);
		Matcher matcher=pattern.matcher(tlf);
		if(matcher.matches()){
		return true;
		  } 
	    return false; 
	  }
	
	public static boolean validaEmail(String email){
		Pattern pattern=Pattern.compile(plantilla_email);
		Matcher matcher=pattern.matcher(email);
		if(matcher.matches()){
		return true;
		  } 
	    return false; 
	  }
	
	public static boolean validafechacorrecta(String fecha, char type){
		Pattern pattern = null;
		switch(type){
		case 'a':
			pattern=Pattern.compile(fecha_ddmmyyyy1);
			break;
		case 'b': 
			pattern=Pattern.compile(fecha_ddmmyyyy2);
			break;
		case 'c':
			pattern=Pattern.compile(fecha_yyyymmdd1);
			break;
		case 'd':
			pattern=Pattern.compile(fecha_yyyymmdd2);
			break;
		}
		Matcher matcher=pattern.matcher(fecha);
		if(matcher.matches()){
		return true;
		  } 
	    return false; 
	  }
	
	public static boolean validarangoedad(String edad){
		Pattern pattern=Pattern.compile(plantilla_edad);
		Matcher matcher=pattern.matcher(edad);
		if(matcher.matches()){
		return true;
		  } 
	    return false; 
	  }

	public static boolean validatesalary(String salary){
            Pattern pattern=Pattern.compile(plantilla_salario);
            Matcher matcher=pattern.matcher(salary);
            return matcher.matches();
        }
        public static boolean validateactivity(String activity){
            Pattern pattern=Pattern.compile(plantilla_numeroentero);
            Matcher matcher=pattern.matcher(activity);
            return matcher.matches();
        }
                
	public static boolean validatedni(String DNI){ //Valida un DNI
		Pattern pattern=Pattern.compile(plantilla_dni);
		Matcher matcher=pattern.matcher(DNI);
		
		return matcher.matches();
	}
}