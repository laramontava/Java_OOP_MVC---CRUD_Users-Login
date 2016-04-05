package app.modules.users.registered_user.view;

/**
 *
 * @author Lara
 */
public class regusermanage_view extends javax.swing.JFrame {
    
    public regusermanage_view() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ANTERIOR = new javax.swing.JButton();
        SIGUIENTE = new javax.swing.JButton();
        CAJA = new javax.swing.JTextField();
        primero = new javax.swing.JButton();
        ultimo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        searchby = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        create_admin = new javax.swing.JButton();
        statusnewadmin = new javax.swing.JLabel();
        edit_admin = new javax.swing.JButton();
        delete_admin = new javax.swing.JButton();
        savejson = new javax.swing.JButton();
        savetxt = new javax.swing.JButton();
        savexml = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TABLA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TABLA.setSelectionForeground(new java.awt.Color(255, 153, 51));
        jScrollPane1.setViewportView(TABLA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setText("Volver");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "50", "100" }));

        jLabel2.setText("Show entries:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ANTERIOR.setText("<");
        jPanel2.add(ANTERIOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        SIGUIENTE.setText(">");
        jPanel2.add(SIGUIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        CAJA.setEditable(false);
        CAJA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CAJA.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel2.add(CAJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 80, 30));

        primero.setText("|<");
        jPanel2.add(primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        ultimo.setText(">|");
        jPanel2.add(ultimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, -1));

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout searchbyLayout = new javax.swing.GroupLayout(searchby);
        searchby.setLayout(searchbyLayout);
        searchbyLayout.setHorizontalGroup(
            searchbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        searchbyLayout.setVerticalGroup(
            searchbyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 32, Short.MAX_VALUE)
        );

        create_admin.setBackground(new java.awt.Color(255, 0, 153));
        create_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_add.png"))); // NOI18N
        create_admin.setToolTipText("Crea un nuevo usuario administrador");
        create_admin.setBorder(null);
        create_admin.setContentAreaFilled(false);
        create_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        create_admin.setIconTextGap(-1);
        create_admin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_add_press.png"))); // NOI18N
        create_admin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_add_press.png"))); // NOI18N
        create_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        edit_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_edit.png"))); // NOI18N
        edit_admin.setToolTipText("Edita un admin ya existente");
        edit_admin.setBorder(null);
        edit_admin.setBorderPainted(false);
        edit_admin.setContentAreaFilled(false);
        edit_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        edit_admin.setIconTextGap(-1);
        edit_admin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_edit_press.png"))); // NOI18N
        edit_admin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_edit_press.png"))); // NOI18N
        edit_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        delete_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_delete.png"))); // NOI18N
        delete_admin.setToolTipText("Eliminar un usuario admin");
        delete_admin.setBorder(null);
        delete_admin.setBorderPainted(false);
        delete_admin.setContentAreaFilled(false);
        delete_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete_admin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delete_admin.setIconTextGap(-1);
        delete_admin.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_delete_press.png"))); // NOI18N
        delete_admin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/user_delete_press.png"))); // NOI18N
        delete_admin.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        savejson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/filejson.png"))); // NOI18N
        savejson.setBorder(null);
        savejson.setBorderPainted(false);
        savejson.setContentAreaFilled(false);
        savejson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        savetxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/filetxt.png"))); // NOI18N
        savetxt.setToolTipText("Descargar txt con todos los admins");
        savetxt.setBorder(null);
        savetxt.setBorderPainted(false);
        savetxt.setContentAreaFilled(false);
        savetxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        savexml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/filexml.png"))); // NOI18N
        savexml.setBorder(null);
        savexml.setBorderPainted(false);
        savexml.setContentAreaFilled(false);
        savexml.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setText("First name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchby, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(create_admin)
                                .addGap(18, 18, 18)
                                .addComponent(edit_admin)
                                .addGap(18, 18, 18)
                                .addComponent(delete_admin)
                                .addGap(18, 18, 18)
                                .addComponent(statusnewadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(savejson)
                                .addGap(18, 18, 18)
                                .addComponent(savexml)
                                .addGap(18, 18, 18)
                                .addComponent(savetxt)
                                .addGap(80, 80, 80))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(edit_admin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(create_admin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(delete_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(savexml, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(savejson)
                            .addComponent(savetxt)))
                    .addComponent(statusnewadmin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchby, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton ANTERIOR;
    public static javax.swing.JTextField CAJA;
    public static javax.swing.JButton SIGUIENTE;
    public static javax.swing.JTable TABLA;
    public static javax.swing.JButton create_admin;
    public static javax.swing.JButton delete_admin;
    public static javax.swing.JButton edit_admin;
    public static javax.swing.JButton jButton1;
    public static javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton primero;
    public static javax.swing.JButton savejson;
    public static javax.swing.JButton savetxt;
    public static javax.swing.JButton savexml;
    public static javax.swing.JPanel searchby;
    public static javax.swing.JLabel statusnewadmin;
    public static javax.swing.JButton ultimo;
    // End of variables declaration//GEN-END:variables
}
