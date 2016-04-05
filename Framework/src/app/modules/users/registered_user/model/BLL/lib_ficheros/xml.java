package app.modules.users.registered_user.model.BLL.lib_ficheros;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import app.modules.users.registered_user.model.classes.registered_user;
import app.modules.users.registered_user.model.classes.singleton_reguser;
import app.classes.singleton_global;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

@SuppressWarnings("deprecation")
public class xml {
    private static final String ENCODING = "UTF-8";
    public static void Generatexml() {
    	String PATH=null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, registered_user.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(singleton_reguser.reguser.getUserreg(), osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());
	    
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            }
	    }catch (Exception e1){
	    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
	    } 
    }
    
    @SuppressWarnings("unchecked")
	public static void Openxml() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, registered_user.class);
 
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                singleton_reguser.reguser.setUserreg((ArrayList <registered_user>)xstream.fromXML(new FileReader(PATH)));
            }
            
        } catch (Exception e1) {
        	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void Generatexmlauto() {
    	String PATH=null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, registered_user.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(singleton_reguser.reguser.getUserreg(), osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());
            if(!singleton_global.conf.getDummies())
                PATH = new java.io.File(".").getCanonicalPath()+"/src/app/modules/users/files/files_admin/admin.xml";
            else
            	PATH=new java.io.File(".").getCanonicalPath()+"/src/app/modules/users/files/files_dummies_admin/admin.txt";
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                //JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
            
	    }catch (Exception e1){
	    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
	    } 
    }
    
    @SuppressWarnings("unchecked")
	public static void Openxmlauto() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, registered_user.class);
 
            PATH = new java.io.File(".").getCanonicalPath()+"/src/app/modules/users/registered_user/model/files/files_registereduser/reguser.xml";
            singleton_reguser.reguser.setUserreg((ArrayList <registered_user>)xstream.fromXML(new FileReader(PATH)));
        } catch (Exception e1) {
        	
        }
    }
   
}
