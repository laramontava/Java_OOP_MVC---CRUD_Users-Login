package app.classes;

import java.io.IOException;
import java.util.Properties;

public class idioma extends Properties{

    private static final long serialVersionUID = 1L;
    private String idioma;
    
    public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
        switch(idioma){
        case "castellano":
                getProperties("castellano.properties");
                break;
        case "english":
                getProperties("english.properties");
                break;
        case "valencia":
            getProperties("valencia.properties");
            break;
        default:
            getProperties("english.properties");
        }
	}
	
	public String toString() {
		return "idioma [idioma=" + idioma + "]";
	}

	public idioma(String idioma){
 
        switch(idioma){
            case "castellano":
                    getProperties("castellano.properties");
                    break;
            case "english":
                    getProperties("english.properties");
                    break;
            default:
                    getProperties("english.properties");
        }
 
    }
 
    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
 
        }
   }
}