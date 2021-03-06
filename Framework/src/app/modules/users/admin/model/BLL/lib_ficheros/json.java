package app.modules.users.admin.model.BLL.lib_ficheros;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import app.classes.singleton_global;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.singleton;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class json {

    public static void GenerateJson() {
        String PATH = null;
        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Admin", admin.class);

            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".json";

                Gson gson = new Gson();
                String json = gson.toJson(singleton.admin.getAdmins());
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void OpenJson() {
        String PATH = null;
        admin e1 = new admin("");

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Admin", admin.class);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                singleton.admin.getAdmins().clear();

                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                Gson json = new Gson();
                JsonArray lista = raiz.getAsJsonArray();
                for (JsonElement elemento : lista) {
                    e1 = json.fromJson(elemento, admin.class);
                    singleton.admin.getAdmins().add(e1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public static void GenerateJsonauto() {
        String PATH = null;
        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Admin", admin.class);

            if (!singleton_global.conf.getDummies()) {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/files/files_admin/admin.json";
            } else {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/files/files_dummies_admin/admin.json";
            }
            Gson gson = new Gson();
            String json = gson.toJson(singleton.admin.getAdmins());
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void OpenJsonauto() {
        String PATH = null;
        admin e1 = new admin("");

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Admin", admin.class);
            if (!singleton_global.conf.getDummies()) {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/admin/model/files/files_admin/admin.json";
            } else {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/admin/model/files/files_dummies_admin/admin.json";
            }
            File path = new File(PATH);
            if (path.exists()) {

                singleton.admin.getAdmins().clear();

                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                Gson json = new Gson();
                JsonArray lista = raiz.getAsJsonArray();
                for (JsonElement elemento : lista) {
                    e1 = json.fromJson(elemento, admin.class);
                    singleton.admin.getAdmins().add(e1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
