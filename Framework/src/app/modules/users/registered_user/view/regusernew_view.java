/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.registered_user.view;

/**
 *
 * @author Lara
 */
public class regusernew_view extends javax.swing.JFrame {
    public regusernew_view() {
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

        jlblname = new javax.swing.JLabel();
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
        mobile_validate = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        addnameuser = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        addpassword = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        addavatar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        addkarma = new javax.swing.JComboBox<>();
        email_validate = new javax.swing.JLabel();
        avatar_validate = new javax.swing.JLabel();
        state_validate = new javax.swing.JLabel();
        avataradd = new javax.swing.JButton();
        createclient = new javax.swing.JButton();
        cancelclient = new javax.swing.JButton();
        titlecreateedit = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblcreate = new javax.swing.JLabel();
        nameuser_validate = new javax.swing.JLabel();
        password_validate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        addactivity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        validatesalary = new javax.swing.JLabel();
        validatebirthday = new javax.swing.JLabel();
        createoredit = new javax.swing.JLabel();
        adddummies = new javax.swing.JButton();
        add_status = new javax.swing.JComboBox<>();
        addpoints = new javax.swing.JTextField();
        logoutruser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblname.setText("Nombre");
        getContentPane().add(jlblname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 70, 20));
        getContentPane().add(addname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 132, -1));

        jLabel2.setText("Apellidos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 70, 20));
        getContentPane().add(addsurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 132, -1));

        jLabel3.setText("DNI");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 20));
        getContentPane().add(adddni, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 132, -1));

        jLabel4.setText("Teléfono");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 70, 20));
        getContentPane().add(addmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 134, -1));

        jLabel5.setText("Email");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, 20));
        getContentPane().add(addemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 134, -1));

        jLabel6.setText("F. nacimiento");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 80, 20));

        adddatebirthday.setToolTipText("");
        adddatebirthday.setDateFormatString("dd-MM-yyyy");
        adddatebirthday.setMaxSelectableDate(new java.util.Date(32503680084000L));
        adddatebirthday.setMinSelectableDate(new java.util.Date(-2208985677000L));
        getContentPane().add(adddatebirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 130, -1));
        getContentPane().add(dni_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 28, 20));
        getContentPane().add(name_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 28, 20));
        getContentPane().add(surname_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 28, 20));
        getContentPane().add(mobile_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 30, 20));

        jLabel12.setText("Usuario");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 60, 20));
        getContentPane().add(addnameuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 134, -1));

        jLabel13.setText("Contraseña");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 70, 20));
        getContentPane().add(addpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 134, -1));

        jLabel14.setText("Avatar");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 70, 20));

        addavatar.setText("image.jpg");
        getContentPane().add(addavatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 91, 84));

        jLabel15.setText("Estado");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 60, 20));

        addkarma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alto", "Medio", "Bajo" }));
        getContentPane().add(addkarma, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 130, -1));
        getContentPane().add(email_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 30, 20));
        getContentPane().add(avatar_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(state_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        avataradd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/addfile.png"))); // NOI18N
        getContentPane().add(avataradd, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 39, 30));

        createclient.setBackground(new java.awt.Color(255, 0, 153));
        createclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/accept.png"))); // NOI18N
        createclient.setToolTipText("Crear");
        createclient.setBorder(null);
        createclient.setContentAreaFilled(false);
        createclient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createclient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        createclient.setIconTextGap(-3);
        createclient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(createclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 75, -1));

        cancelclient.setBackground(new java.awt.Color(255, 0, 153));
        cancelclient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/cancel.png"))); // NOI18N
        cancelclient.setToolTipText("Descartar");
        cancelclient.setBorder(null);
        cancelclient.setContentAreaFilled(false);
        cancelclient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelclient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cancelclient.setIconTextGap(-3);
        cancelclient.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(cancelclient, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 75, -1));

        titlecreateedit.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        titlecreateedit.setText("Crear un usuario registrado");
        titlecreateedit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(titlecreateedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 260, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 42, 9));
        getContentPane().add(jlblcreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 290, 20));
        getContentPane().add(nameuser_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 28, 20));
        getContentPane().add(password_validate, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 28, 20));

        jLabel8.setText("Actividad");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 80, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 310, 384, 10));

        jLabel9.setText("Puntos");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 70, 20));
        getContentPane().add(addactivity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 130, -1));

        jLabel10.setText("Karma");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 80, 20));
        getContentPane().add(validatesalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 30, 20));
        getContentPane().add(validatebirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 30, 20));
        getContentPane().add(createoredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 40, 20));

        adddummies.setText("Add dummies");
        getContentPane().add(adddummies, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        add_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Online", "Offline" }));
        getContentPane().add(add_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 134, -1));

        addpoints.setEditable(false);
        getContentPane().add(addpoints, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 120, -1));

        logoutruser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/door-48.png"))); // NOI18N
        logoutruser.setToolTipText("Cerrar sesión");
        logoutruser.setBorder(null);
        logoutruser.setContentAreaFilled(false);
        logoutruser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutruser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutruser.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/door2-48.png"))); // NOI18N
        logoutruser.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/door2-48.png"))); // NOI18N
        logoutruser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(logoutruser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> add_status;
    public static javax.swing.JTextField addactivity;
    public static javax.swing.JTextField addavatar;
    public static com.toedter.calendar.JDateChooser adddatebirthday;
    public static javax.swing.JTextField adddni;
    public static javax.swing.JButton adddummies;
    public static javax.swing.JTextField addemail;
    public static javax.swing.JComboBox<String> addkarma;
    public static javax.swing.JTextField addmobile;
    public static javax.swing.JTextField addname;
    public static javax.swing.JTextField addnameuser;
    public static javax.swing.JPasswordField addpassword;
    public static javax.swing.JTextField addpoints;
    public static javax.swing.JTextField addsurname;
    public static javax.swing.JLabel avatar_validate;
    public static javax.swing.JButton avataradd;
    public static javax.swing.JButton cancelclient;
    public static javax.swing.JButton createclient;
    public static javax.swing.JLabel createoredit;
    public static javax.swing.JLabel dni_validate;
    public static javax.swing.JLabel email_validate;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel jlblcreate;
    public static javax.swing.JLabel jlblname;
    public static javax.swing.JButton logoutruser;
    public static javax.swing.JLabel mobile_validate;
    public static javax.swing.JLabel name_validate;
    public static javax.swing.JLabel nameuser_validate;
    public static javax.swing.JLabel password_validate;
    public static javax.swing.JLabel state_validate;
    public static javax.swing.JLabel surname_validate;
    public static javax.swing.JLabel titlecreateedit;
    public static javax.swing.JLabel validatebirthday;
    public static javax.swing.JLabel validatesalary;
    // End of variables declaration//GEN-END:variables
}
