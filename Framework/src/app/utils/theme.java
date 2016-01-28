package app.utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;



public class theme{
	public static void temaElegido(int op){
		try {
			switch (op){
			case 0:// Metal
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				break;

			case 1:// GTK - WINDOWS
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				break;

			case 2:// CDE/Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				break;

			case 3:// Nimbus
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				break;
			}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"No pudo cargarse la apariencia deseada","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}