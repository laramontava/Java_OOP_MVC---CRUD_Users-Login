/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.menu.view;

/**
 *
 * @author Lara
 */
public class main_view extends javax.swing.JFrame {

    /**
     * Creates new form main_view
     */
    public main_view() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnclient_main = new javax.swing.JButton();
        btnconf_main = new javax.swing.JButton();
        btnadmin_main = new javax.swing.JButton();
        btnreguser_main = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        background_main = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de usuarios");
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/user_manage.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 50, 173, 181);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(365, 0, 42, 11);

        btnclient_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/client.png"))); // NOI18N
        btnclient_main.setText("Cliente");
        btnclient_main.setToolTipText("Conviértete en cliente y consigue descuentos en tus compras");
        btnclient_main.setActionCommand("");
        btnclient_main.setBorder(null);
        btnclient_main.setContentAreaFilled(false);
        btnclient_main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclient_main.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnclient_main.setIconTextGap(-1);
        btnclient_main.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/client_press.png"))); // NOI18N
        btnclient_main.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/client_press.png"))); // NOI18N
        btnclient_main.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnclient_main);
        btnclient_main.setBounds(30, 120, 90, 80);

        btnconf_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/config.png"))); // NOI18N
        btnconf_main.setText("Configuración");
        btnconf_main.setToolTipText("Modifica la aplicación a tu gusto");
        btnconf_main.setActionCommand("");
        btnconf_main.setBorder(null);
        btnconf_main.setContentAreaFilled(false);
        btnconf_main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnconf_main.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnconf_main.setIconTextGap(-3);
        btnconf_main.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/config_press.png"))); // NOI18N
        btnconf_main.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/config_press.png"))); // NOI18N
        btnconf_main.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnconf_main);
        btnconf_main.setBounds(310, 230, 90, 80);

        btnadmin_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/admin.png"))); // NOI18N
        btnadmin_main.setText("Administrador");
        btnadmin_main.setToolTipText("Usuarios con permiso de administración");
        btnadmin_main.setActionCommand("");
        btnadmin_main.setBorder(null);
        btnadmin_main.setContentAreaFilled(false);
        btnadmin_main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnadmin_main.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnadmin_main.setIconTextGap(-1);
        btnadmin_main.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/admin_press.png"))); // NOI18N
        btnadmin_main.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/admin_press.png"))); // NOI18N
        btnadmin_main.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnadmin_main);
        btnadmin_main.setBounds(30, 21, 90, 80);

        btnreguser_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/registered.png"))); // NOI18N
        btnreguser_main.setText("Registrado");
        btnreguser_main.setToolTipText("Regístrate para conseguir puntos con tu actividad y aumentar tu nivel de karma");
        btnreguser_main.setActionCommand("");
        btnreguser_main.setBorder(null);
        btnreguser_main.setContentAreaFilled(false);
        btnreguser_main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreguser_main.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnreguser_main.setIconTextGap(-1);
        btnreguser_main.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/registered_press.png"))); // NOI18N
        btnreguser_main.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/registered_press.png"))); // NOI18N
        btnreguser_main.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(btnreguser_main);
        btnreguser_main.setBounds(30, 220, 90, 80);

        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/door-48.png"))); // NOI18N
        logout.setToolTipText("Cerrar sesión");
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logout.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/door2-48.png"))); // NOI18N
        logout.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/door2-48.png"))); // NOI18N
        logout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(logout);
        logout.setBounds(350, 0, 49, 60);

        background_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/background_main.png"))); // NOI18N
        getContentPane().add(background_main);
        background_main.setBounds(0, 0, 420, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background_main;
    public static javax.swing.JButton btnadmin_main;
    public static javax.swing.JButton btnclient_main;
    public static javax.swing.JButton btnconf_main;
    public static javax.swing.JButton btnreguser_main;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JButton logout;
    // End of variables declaration//GEN-END:variables
}
