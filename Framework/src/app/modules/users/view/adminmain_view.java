/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.view;

import app.modules.menu.view.main_view;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author 1º DAW
 */
public class adminmain_view extends javax.swing.JFrame {

    /**
     * Creates new form adminmain_view
     */
    public adminmain_view() {
        initComponents();
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

        create_admin = new javax.swing.JButton();
        edit_admin = new javax.swing.JButton();
        view_admin = new javax.swing.JButton();
        sort_admin = new javax.swing.JButton();
        open_admin_file = new javax.swing.JButton();
        delete_admin = new javax.swing.JButton();
        save_admin_file = new javax.swing.JButton();
        create_admin1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        create_admin.setBackground(new java.awt.Color(255, 0, 153));
        create_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/user_add_b.png"))); // NOI18N
        create_admin.setText("Crear");
        create_admin.setToolTipText("Crea un nuevo usuario administrador");
        create_admin.setActionCommand("");
        create_admin.setBorder(null);
        create_admin.setContentAreaFilled(false);
        create_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        create_admin.setIconTextGap(-1);
        create_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        create_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_adminActionPerformed(evt);
            }
        });

        edit_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/user_edit.png"))); // NOI18N
        edit_admin.setText("Editar");
        edit_admin.setToolTipText("Edita un admin ya existente");
        edit_admin.setBorder(null);
        edit_admin.setBorderPainted(false);
        edit_admin.setContentAreaFilled(false);
        edit_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        edit_admin.setIconTextGap(-1);
        edit_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        edit_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_adminActionPerformed(evt);
            }
        });

        view_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/user_view.png"))); // NOI18N
        view_admin.setText("Visualizar");
        view_admin.setToolTipText("Ver todos los usuarios admin");
        view_admin.setBorder(null);
        view_admin.setBorderPainted(false);
        view_admin.setContentAreaFilled(false);
        view_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        view_admin.setIconTextGap(-1);
        view_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        sort_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/user_sort.png"))); // NOI18N
        sort_admin.setText("Ordenar");
        sort_admin.setToolTipText("Ordenar los usuarios admin");
        sort_admin.setBorder(null);
        sort_admin.setBorderPainted(false);
        sort_admin.setContentAreaFilled(false);
        sort_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sort_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        sort_admin.setIconTextGap(-1);
        sort_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        open_admin_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/file_add.png"))); // NOI18N
        open_admin_file.setText("Abrir");
        open_admin_file.setToolTipText("Abrir archivo con usuarios admin creados");
        open_admin_file.setActionCommand("");
        open_admin_file.setBorder(null);
        open_admin_file.setBorderPainted(false);
        open_admin_file.setContentAreaFilled(false);
        open_admin_file.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        open_admin_file.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        open_admin_file.setIconTextGap(-1);
        open_admin_file.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        open_admin_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_admin_fileActionPerformed(evt);
            }
        });

        delete_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/user_delete_b.png"))); // NOI18N
        delete_admin.setText("Eliminar");
        delete_admin.setToolTipText("Eliminar un usuario admin");
        delete_admin.setActionCommand("");
        delete_admin.setBorder(null);
        delete_admin.setBorderPainted(false);
        delete_admin.setContentAreaFilled(false);
        delete_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delete_admin.setIconTextGap(-1);
        delete_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        delete_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_adminActionPerformed(evt);
            }
        });

        save_admin_file.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/save.png"))); // NOI18N
        save_admin_file.setText("Guardar");
        save_admin_file.setToolTipText("Guardar los usuarios admins creados");
        save_admin_file.setActionCommand("");
        save_admin_file.setBorder(null);
        save_admin_file.setBorderPainted(false);
        save_admin_file.setContentAreaFilled(false);
        save_admin_file.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_admin_file.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save_admin_file.setIconTextGap(-1);
        save_admin_file.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        save_admin_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_admin_fileActionPerformed(evt);
            }
        });

        create_admin1.setBackground(new java.awt.Color(255, 0, 153));
        create_admin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/view/img/return2.png"))); // NOI18N
        create_admin1.setToolTipText("Volver atrás");
        create_admin1.setBorder(null);
        create_admin1.setContentAreaFilled(false);
        create_admin1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_admin1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        create_admin1.setIconTextGap(-3);
        create_admin1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        create_admin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_admin1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setText("Administrador");

        jLabel7.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel7AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(delete_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(open_admin_file, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(save_admin_file, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(create_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(create_admin1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edit_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(view_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sort_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(create_admin1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sort_admin)
                    .addComponent(view_admin)
                    .addComponent(create_admin)
                    .addComponent(edit_admin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(delete_admin)
                    .addComponent(open_admin_file)
                    .addComponent(save_admin_file))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        create_admin.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void create_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_adminActionPerformed
        // TODO add your handling code here:
        new adminnew_view().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_create_adminActionPerformed

    private void open_admin_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_admin_fileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_open_admin_fileActionPerformed

    private void delete_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_adminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete_adminActionPerformed

    private void save_admin_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_admin_fileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_save_admin_fileActionPerformed

    private void create_admin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_admin1ActionPerformed
        // TODO add your handling code here:
        new main_view().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_create_admin1ActionPerformed

    private void jLabel7AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel7AncestorAdded
        // TODO add your handling code here:
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new main_view().setVisible(true);
            }
        });
    }//GEN-LAST:event_jLabel7AncestorAdded

    private void edit_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_adminActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new manageadmin_view().setVisible(true);
        
    }//GEN-LAST:event_edit_adminActionPerformed

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
            java.util.logging.Logger.getLogger(adminmain_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminmain_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminmain_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminmain_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminmain_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton create_admin;
    public static javax.swing.JButton create_admin1;
    public static javax.swing.JButton delete_admin;
    public static javax.swing.JButton edit_admin;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    public static javax.swing.JButton open_admin_file;
    public static javax.swing.JButton save_admin_file;
    public static javax.swing.JButton sort_admin;
    public static javax.swing.JButton view_admin;
    // End of variables declaration//GEN-END:variables
}
