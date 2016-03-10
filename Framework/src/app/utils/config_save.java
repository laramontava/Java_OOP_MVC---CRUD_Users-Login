package app.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import app.modules.config.model.configuration;
import app.classes.singleton_global;

public class config_save {
	public static void GenerateJsonautoconf(){
		 String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Config", configuration.class);
	       
	                PATH = new java.io.File(".").getCanonicalPath()+"/src/app/conf.json";
	                Gson gson = new Gson();
		            String json = gson.toJson(singleton_global.conf);
		            FileWriter fileXml = new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close(); 
	                	          
      } catch (Exception e) {
      	JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
      }
   }
	 public static void OpenJsonautoconf() {
		 String PATH = null;
	    	configuration e1=new configuration();
	    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("Config", configuration.class);
				  PATH = new java.io.File(".").getCanonicalPath()+"/src/app/conf.json";
		          File path = new File(PATH);
		          if (path.exists()) {
		                JsonReader lector = new JsonReader(new FileReader(PATH));
		                JsonParser parseador = new JsonParser();
		                JsonElement raiz = parseador.parse(lector);  
		            	Gson json = new Gson();
		            	
		            	e1 = json.fromJson(raiz, configuration.class);
		            	singleton_global.conf = e1;
		            	
		          } 
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }

	    }
}
