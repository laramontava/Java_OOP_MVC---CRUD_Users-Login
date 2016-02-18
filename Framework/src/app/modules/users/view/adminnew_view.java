/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.view;

import app.modules.users.core.kernel;
import app.modules.users.model.BLL.BLL_admin;
import app.modules.users.model.DAO.functions_users;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 1º DAW
 */
public class adminnew_view extends javax.swing.JFrame {
    Calendar fnac;
    int dia, mes, anyo;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter
        ("Archivo de imagen","jpg","png","gif");
    String rutaimagen;
    /**
     * Creates new form newadmin_view
     */
    public adminnew_view() {
        initComponents();
        rutaimagen="";
        confpage();
        
    }
    private void confpage(){
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        addsurname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        adddni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addmobile = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        addemail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        adddatebirthday = new com.toedter.calendar.JDateChooser();
        dni_validate = new javax.swing.JLabel();
        name_validate = new javax.swing.JLabel();
        surname_validate = new javax.swing.JLabel();
        birthday_validate = new javax.swing.JLabel();
        mobile_validate = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        addnameuser = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        addpassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        addavatar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addstatus = new javax.swing.JComboBox<>();
        email_validate = new javax.swing.JLabel();
        nuser_validate = new javax.swing.JLabel();
        password_validate = new javax.swing.JLabel();
        avatar_validate = new javax.swing.JLabel();
        state_validate = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        createadmin = new javax.swing.JButton();
        canceladmin = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblcancel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        addname.setText("Pepe");
        addname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                addnameFocusLost(evt);
            }
        });
        addname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnameActionPerformed(evt);
            }
        });
        addname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                addnameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                addnameKeyTyped(evt);
            }
        });
        getContentPane().add(addname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 97, 134, -1));

        jLabel2.setText("Apellidos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 135, -1, 20));

        addsurname.setText("Sellés");
        getContentPane().add(addsurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 135, 134, -1));

        jLabel3.setText("DNI");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 56, -1, 20));

        adddni.setText("12345678A");
        adddni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adddniActionPerformed(evt);
            }
        });
        getContentPane().add(adddni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 56, 134, -1));

        jLabel4.setText("Teléfono");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 208, -1, 20));

        addmobile.setText("650123478");
        addmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addmobileActionPerformed(evt);
            }
        });
        getContentPane().add(addmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 208, 134, -1));

        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 56, -1, 20));

        addemail.setText("ejemplo@ej.com");
        getContentPane().add(addemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 56, 134, -1));

        jLabel6.setText("F. nacimiento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 20));

        adddatebirthday.setToolTipText("");
        getContentPane().add(adddatebirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 170, 134, -1));

        dni_validate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/done_2.png"))); // NOI18N
        getContentPane().add(dni_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 56, 28, 20));
        getContentPane().add(name_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 97, 28, 20));

        surname_validate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/done_2.png"))); // NOI18N
        getContentPane().add(surname_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 135, 28, 20));
        getContentPane().add(birthday_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 170, 28, 20));

        mobile_validate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/done_2.png"))); // NOI18N
        getContentPane().add(mobile_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 208, 30, 20));

        jLabel12.setText("Usuario");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 97, -1, 20));

        addnameuser.setText("Nombre de usuario");
        getContentPane().add(addnameuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 97, 134, -1));

        jLabel13.setText("Contraseña");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 135, -1, 20));

        addpassword.setText("jPasswordField1");
        getContentPane().add(addpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 135, 134, -1));

        jLabel14.setText("Avatar");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 173, -1, 20));

        addavatar.setText("image.jpg");
        getContentPane().add(addavatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 173, 89, -1));

        jLabel15.setText("Estado");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 211, -1, 20));

        addstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Offline" }));
        getContentPane().add(addstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 211, 134, -1));

        email_validate.setText("Ok");
        getContentPane().add(email_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 59, -1, -1));

        nuser_validate.setText("Ok");
        getContentPane().add(nuser_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 100, -1, -1));

        password_validate.setText("Ok");
        getContentPane().add(password_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 138, -1, -1));

        avatar_validate.setText("Ok");
        getContentPane().add(avatar_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 173, -1, 20));

        state_validate.setText("Ok");
        getContentPane().add(state_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 214, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/addfile.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 173, 39, 30));

        createadmin.setBackground(new java.awt.Color(255, 0, 153));
        createadmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/accept.png"))); // NOI18N
        createadmin.setToolTipText("Crear");
        createadmin.setBorder(null);
        createadmin.setContentAreaFilled(false);
        createadmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createadmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createadmin.setIconTextGap(-3);
        createadmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        createadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createadminActionPerformed(evt);
            }
        });
        getContentPane().add(createadmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 306, 75, -1));

        canceladmin.setBackground(new java.awt.Color(255, 0, 153));
        canceladmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/cancel.png"))); // NOI18N
        canceladmin.setToolTipText("Descartar");
        canceladmin.setBorder(null);
        canceladmin.setContentAreaFilled(false);
        canceladmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        canceladmin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        canceladmin.setIconTextGap(-3);
        canceladmin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        canceladmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceladminActionPerformed(evt);
            }
        });
        getContentPane().add(canceladmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 306, 75, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel8.setText("Crear un usuario administrador");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 11, -1, -1));

        jLabel7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel7AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 42, 9));
        getContentPane().add(jlblcancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 374, 98, 14));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addmobileActionPerformed
        // TODO add your handling code here:
        addmobile.setText("");
    }//GEN-LAST:event_addmobileActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser dlg= new JFileChooser();
        dlg.setFileFilter(filter);
        int option = dlg.showOpenDialog(this);
        if(option==JFileChooser.APPROVE_OPTION){
            String filename = dlg.getSelectedFile().getPath();
            String fileurl = dlg.getSelectedFile().toString();
            addavatar.setText(fileurl);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void createadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createadminActionPerformed
        // TODO add your handling code here:
        String info = "";
       // ImageIcon Ko = new ImageIcon(getClass().getResource("/img/error.png"));
        info += adddni.getText()+"\n";
        info += addname.getText()+"\n";
        info += addsurname.getText()+"\n";
        try{
            fnac = adddatebirthday.getCalendar();
            dia = fnac.get(Calendar.DATE);
            mes = fnac.get(Calendar.MONTH)+1;
            anyo = fnac.get(Calendar.YEAR);
        }catch(java.lang.ArrayIndexOutOfBoundsException e1){
            JOptionPane.showMessageDialog(null, "Formato de fecha no valido", "Error!", 2);
            //birthday_validate.setIcon(this.Ko);
         //   birthday_validate.setIcon(Ko);
            return;
        }catch(Exception e2){
            JOptionPane.showMessageDialog(null, "Formato de fecha no validoa", "Error!", 2);
            return;
        }finally {
            adddatebirthday.requestFocus();
        }
        info += fnac.get(Calendar.DATE)+"/"+(fnac.get(Calendar.MONTH)+1)+"/"
                +fnac.get(Calendar.YEAR)+"\n";
        info += addmobile.getText()+"\n";
        info += addemail.getText()+"\n";
        info += addnameuser.getText()+"\n";
        info += addavatar.getText()+"\n";
        info += addstatus.getName();
        JOptionPane.showMessageDialog(null, info);
        new adminmain_view().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_createadminActionPerformed

    private void canceladminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceladminActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "El admin no se ha creado");
        new adminmain_view().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_canceladminActionPerformed

    private void jLabel7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel7AncestorAdded
        // TODO add your handling code here:
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new adminmain_view().setVisible(true);
            }
        });
    }//GEN-LAST:event_jLabel7AncestorAdded

    private void adddniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adddniActionPerformed
        // TODO add your handling code here: Validar DNI
        
    }//GEN-LAST:event_adddniActionPerformed

    private void addnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnameActionPerformed
        // TODO add your handling code here: Validar nombre
        //functions_users.pideadmin();
        BLL_admin.NameValidate();
    }//GEN-LAST:event_addnameActionPerformed

    private void addnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addnameFocusLost
        // TODO add your handling code here:
        BLL_admin.NameValidate();
    }//GEN-LAST:event_addnameFocusLost

    private void addnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addnameKeyPressed
        // TODO add your handling code here:
        BLL_admin.NameValidate();
    }//GEN-LAST:event_addnameKeyPressed

    private void addnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addnameKeyReleased
        // TODO add your handling code here:
        BLL_admin.NameValidate();
    }//GEN-LAST:event_addnameKeyReleased

    private void addnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addnameKeyTyped
        // TODO add your handling code here:
        BLL_admin.NameValidate();
    }//GEN-LAST:event_addnameKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminnew_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminnew_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminnew_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminnew_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminnew_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField addavatar;
    public static com.toedter.calendar.JDateChooser adddatebirthday;
    public static javax.swing.JTextField adddni;
    public static javax.swing.JTextField addemail;
    public static javax.swing.JTextField addmobile;
    public static javax.swing.JTextField addname;
    public static javax.swing.JTextField addnameuser;
    public static javax.swing.JPasswordField addpassword;
    public static javax.swing.JComboBox<String> addstatus;
    public static javax.swing.JTextField addsurname;
    public static javax.swing.JLabel avatar_validate;
    public static javax.swing.JLabel birthday_validate;
    public static javax.swing.JButton canceladmin;
    public static javax.swing.JButton createadmin;
    public static javax.swing.JLabel dni_validate;
    public static javax.swing.JLabel email_validate;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jlblcancel;
    public static javax.swing.JLabel mobile_validate;
    public static javax.swing.JLabel name_validate;
    public static javax.swing.JLabel nuser_validate;
    public static javax.swing.JLabel password_validate;
    public static javax.swing.JLabel state_validate;
    public static javax.swing.JLabel surname_validate;
    // End of variables declaration//GEN-END:variables
}
