/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.view;

import app.modules.users.admin.model.BLL.Arraylist_admin;
import app.modules.users.admin.model.BLL.BLL_admin;
import app.modules.users.admin.model.classes.admin;
import java.awt.Color;
import javax.swing.text.StyleConstants;

/**
 *
 * @author 1º DAW
 */
public class adminedit_view extends javax.swing.JFrame {

    /**
     * Creates new form adminedit_view
     */
    public adminedit_view() {
        initComponents();
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
        edit_dni = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edit_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        edit_surname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edit_birthday = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        edit_mobile = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        edit_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        edni_validate = new javax.swing.JLabel();
        edit_nameuser = new javax.swing.JTextField();
        ename_val = new javax.swing.JLabel();
        esurname_val = new javax.swing.JLabel();
        ebirthday_val = new javax.swing.JLabel();
        emobile_val = new javax.swing.JLabel();
        eemail_val = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        edit_passwd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        edit_avatar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        edit_status = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        edit_hiringdate = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        edit_salary = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        edit_activity = new javax.swing.JTextField();
        enameuser_val = new javax.swing.JLabel();
        epasswd_val = new javax.swing.JLabel();
        ehiring_val = new javax.swing.JLabel();
        esalary_val = new javax.swing.JLabel();
        eactivity_val = new javax.swing.JLabel();
        prueba = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setText("Editar usuario administrador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 11, -1, -1));
        getContentPane().add(edit_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 79, 131, -1));

        jLabel2.setText("DNI");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 59, -1, -1));

        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 117, -1, -1));
        getContentPane().add(edit_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 137, 131, -1));

        jLabel4.setText("Apellidos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 175, -1, -1));
        getContentPane().add(edit_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 195, 131, -1));

        jLabel5.setText("Fecha de nacimiento");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 233, -1, -1));
        getContentPane().add(edit_birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 253, 131, -1));

        jLabel6.setText("Teléfono");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 291, -1, -1));
        getContentPane().add(edit_mobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 311, 131, -1));

        jLabel7.setText("Email");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 349, -1, -1));
        getContentPane().add(edit_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 369, 131, -1));

        jLabel8.setText("Nombre de usuario");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 59, -1, -1));

        edni_validate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(edni_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 28, 20));
        getContentPane().add(edit_nameuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 79, 131, -1));

        ename_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(ename_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 28, 20));

        esurname_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(esurname_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 28, 20));

        ebirthday_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(ebirthday_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 28, 20));

        emobile_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(emobile_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 28, 20));

        eemail_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(eemail_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, 28, 20));

        jLabel9.setText("Contraseña");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 117, -1, -1));
        getContentPane().add(edit_passwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 137, 131, -1));

        jLabel10.setText("Avatar");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, -1, -1));
        getContentPane().add(edit_avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 91, 84));

        jLabel11.setText("Estado");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        edit_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Offline" }));
        getContentPane().add(edit_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 134, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 419, 359, 10));

        jLabel12.setText("Fecha de contratación");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));
        getContentPane().add(edit_hiringdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 131, -1));

        jLabel13.setText("Salario base");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, -1, -1));
        getContentPane().add(edit_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 131, -1));

        jLabel14.setText("Actividad");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, -1, -1));
        getContentPane().add(edit_activity, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 131, -1));

        enameuser_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(enameuser_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 28, 20));

        epasswd_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(epasswd_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, 28, 20));

        ehiring_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(ehiring_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 28, 20));

        esalary_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(esalary_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 28, 20));

        eactivity_val.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(eactivity_val, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 28, 20));

        prueba.setText("jButton1");
        prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaActionPerformed(evt);
            }
        });
        getContentPane().add(prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaActionPerformed
        // TODO add your handling code here:
        admin ad = new admin();
        //BLL_admin.Modificar(ad);
    }//GEN-LAST:event_pruebaActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
         Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminedit_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminedit_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminedit_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminedit_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminedit_view().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel eactivity_val;
    public static javax.swing.JLabel ebirthday_val;
    public static javax.swing.JTextField edit_activity;
    public static javax.swing.JTextField edit_avatar;
    public static com.toedter.calendar.JDateChooser edit_birthday;
    public static javax.swing.JTextField edit_dni;
    public static javax.swing.JTextField edit_email;
    public static com.toedter.calendar.JDateChooser edit_hiringdate;
    public static javax.swing.JTextField edit_mobile;
    public static javax.swing.JTextField edit_name;
    public static javax.swing.JTextField edit_nameuser;
    public static javax.swing.JTextField edit_passwd;
    public static javax.swing.JTextField edit_salary;
    public static javax.swing.JComboBox<String> edit_status;
    public static javax.swing.JTextField edit_surname;
    public static javax.swing.JLabel edni_validate;
    public static javax.swing.JLabel eemail_val;
    public static javax.swing.JLabel ehiring_val;
    public static javax.swing.JLabel emobile_val;
    public static javax.swing.JLabel ename_val;
    public static javax.swing.JLabel enameuser_val;
    public static javax.swing.JLabel epasswd_val;
    public static javax.swing.JLabel esalary_val;
    public static javax.swing.JLabel esurname_val;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton prueba;
    // End of variables declaration//GEN-END:variables
}
