/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.model.DAO;

import app.modules.users.view.adminnew_view;
import app.utils.validate;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Lara
 */
public class DAO_admin {
    public static ImageIcon cancel = new ImageIcon("src/app/modules/users/view/img/error.png");
    public static ImageIcon ok = new ImageIcon("src/app/modules/users/view/img/done_2.png");
    public static void pidenombre() {
        if (adminnew_view.addname.getText().isEmpty()) {
            adminnew_view.name_validate.setIcon(cancel);
        } else{
            if (!validate.validaNombre(adminnew_view.addname.getText())) {
                adminnew_view.name_validate.setIcon(cancel);
                adminnew_view.addname.setForeground(Color.RED);
            } else {
                adminnew_view.name_validate.setIcon(ok);
                adminnew_view.addname.setForeground(Color.BLUE);
            }
        }
    }
    
    
}
