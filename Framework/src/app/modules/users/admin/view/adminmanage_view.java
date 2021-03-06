package app.modules.users.admin.view;

import app.classes.singleton_global;
import app.modules.menu.view.main_view;
import app.modules.users.admin.model.BLL.BLL_admin;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import app.modules.users.admin.model.utils.autocomplete.AutocompleteJComboBox;
import app.modules.users.admin.model.utils.autocomplete.StringSearchable;
import app.modules.users.admin.model.utils.pager.pagina;
import app.modules.users.admin.model.classes.miniSimpleTableModel_admin;
import static app.modules.users.admin.model.classes.miniSimpleTableModel_admin.datos;
import app.modules.users.admin.model.classes.singleton;
import static app.modules.users.admin.model.classes.singleton.admin;
import static app.modules.users.admin.view.adminnew_view.*;
import app.ppalmain;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Lara
 */
public class adminmanage_view extends javax.swing.JFrame {

//    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_admin());
//    public static AutocompleteJComboBox combo = null;

    //public static int selected;
    /**
     * Creates new form interfaz_actor
     */
    public adminmanage_view() {
        initComponents();

/*        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        this.setLocationRelativeTo(null);
        this.setTitle("Gestión Actores");
        this.setResizable(false);

        ppalmain.singleton_vtna = "interfaz_actor";
        //
        TABLA.setModel(new miniSimpleTableModel_admin());
        ((miniSimpleTableModel_admin) TABLA.getModel()).cargar();
        TABLA.setFillsViewportHeight(true);
        TABLA.setRowSorter(sorter);
        TABLA.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();

                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    if (BLL_admin.Modificar()) {
                        dispose();
                        new adminnew_view().setVisible(true);
                        BLL_admin.LlenarCampos();
                        titlecreateedit.setText("Editar un usuario administrador");
                        createoredit.setVisible(false);
                    }
                }
            }
        });

        //
        pagina.inicializa();
        pagina.initLinkBox();

        jLabel3.setText(String.valueOf(admin.getAdmins().size()));

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                new main_view().setVisible(true);
            }
        });

        List<String> myWords = new ArrayList<String>();
        for (int i = 0; i <= admin.getAdmins().size() - 1; i++) {
            myWords.add(admin.getAdmins().get(i).getName());
        }

        StringSearchable searchable = new StringSearchable(myWords);
        combo = new AutocompleteJComboBox(searchable);
        //JPanel5 se utiliza solamente para que JPanel3 que contendrá combo, no se redimensione
        jPanel3.setLayout(new java.awt.BorderLayout());
        jPanel3.add(combo);

        combo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActionPerformed(evt);
            }
        });
        /*   TABLA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLAMouseClicked(evt);
            }
        });*/
    }
    public static int selected;

    /*public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        //    System.out.println("word selected: " + ((JComboBox)combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_admin) TABLA.getModel()).filtrar();
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
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "50", "100" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Show entries:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ANTERIOR.setText("<");
        ANTERIOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANTERIORActionPerformed(evt);
            }
        });
        jPanel2.add(ANTERIOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        SIGUIENTE.setText(">");
        SIGUIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIGUIENTEActionPerformed(evt);
            }
        });
        jPanel2.add(SIGUIENTE, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, -1));

        CAJA.setEditable(false);
        CAJA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CAJA.setPreferredSize(new java.awt.Dimension(140, 20));
        jPanel2.add(CAJA, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 80, 30));

        primero.setText("|<");
        primero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                primeroActionPerformed(evt);
            }
        });
        jPanel2.add(primero, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        ultimo.setText(">|");
        ultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ultimoActionPerformed(evt);
            }
        });
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
        create_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                create_adminActionPerformed(evt);
            }
        });

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
        edit_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_adminActionPerformed(evt);
            }
        });

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
        delete_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_adminActionPerformed(evt);
            }
        });

        savejson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/filejson.png"))); // NOI18N
        savejson.setBorder(null);
        savejson.setBorderPainted(false);
        savejson.setContentAreaFilled(false);
        savejson.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savejson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savejsonActionPerformed(evt);
            }
        });

        savetxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/filetxt.png"))); // NOI18N
        savetxt.setToolTipText("Descargar txt con todos los admins");
        savetxt.setBorder(null);
        savetxt.setBorderPainted(false);
        savetxt.setContentAreaFilled(false);
        savetxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savetxtActionPerformed(evt);
            }
        });

        savexml.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/filexml.png"))); // NOI18N
        savexml.setBorder(null);
        savexml.setBorderPainted(false);
        savexml.setContentAreaFilled(false);
        savexml.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        savexml.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savexmlActionPerformed(evt);
            }
        });

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   //     this.dispose();
   //     new main_view().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    //    pagina.itemsPerPage = Integer.parseInt(jComboBox1.getSelectedItem().toString());
   //     pagina.currentPageIndex = 1;
   //     pagina.initLinkBox();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ANTERIORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANTERIORActionPerformed
    //    pagina.currentPageIndex -= 1;
    //    pagina.initLinkBox();
    }//GEN-LAST:event_ANTERIORActionPerformed

    private void SIGUIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIGUIENTEActionPerformed
    //    pagina.currentPageIndex += 1;
   //     pagina.initLinkBox();
    }//GEN-LAST:event_SIGUIENTEActionPerformed

    private void primeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_primeroActionPerformed
    //    pagina.currentPageIndex = 1;
    //    pagina.initLinkBox();
    }//GEN-LAST:event_primeroActionPerformed

    private void ultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ultimoActionPerformed
    //    pagina.currentPageIndex = pagina.maxPageIndex;
    //    pagina.initLinkBox();
    }//GEN-LAST:event_ultimoActionPerformed

    private void create_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_create_adminActionPerformed
        // TODO add your handling code here:
   //     new adminnew_view().setVisible(true);
    //    dispose();
    }//GEN-LAST:event_create_adminActionPerformed
    /*private void TABLAMouseClicked(java.awt.event.MouseEvent evt) {
        //singleton.pager.selectadmin();
        selected= TABLA.getSelectedRow();
    }*/
    private void edit_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_adminActionPerformed
        // TODO add your handling code here:
 /*       if (BLL_admin.Modificar()) {
            this.dispose();
            new adminnew_view().setVisible(true);
            BLL_admin.LlenarCampos();
            //titlecreateedit.setText("Editar un usuario administrador");
            titlecreateedit.setText(singleton_global.translate.getProperty("edittit"));
            createoredit.setVisible(false);
        }*/
        /*    String dni =  functions.validatestring("Type dni", "");
        JOptionPane.showMessageDialog(null, dni);
        dispose();
        new adminnew_view().setVisible(true);
        titlecreateedit.setText("Editar un usuario administrador");
        createoredit.setVisible(false);
        selected = singleton.admin.buscarDniAdmin(dni);
        JOptionPane.showMessageDialog(null, selected);
        DAO_admin.fillfields(selected);*/
    }//GEN-LAST:event_edit_adminActionPerformed

    private void delete_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_adminActionPerformed
        // TODO add your handling code here:
    //    BLL_admin.Delete();
    }//GEN-LAST:event_delete_adminActionPerformed

    private void savejsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savejsonActionPerformed
        // TODO add your handling code here:
    //    singleton.admin.savejson();
    }//GEN-LAST:event_savejsonActionPerformed

    private void savetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savetxtActionPerformed
        // TODO add your handling code here:
    //    singleton.admin.savetxt();
    }//GEN-LAST:event_savetxtActionPerformed

    private void savexmlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savexmlActionPerformed
        // TODO add your handling code here:
    //    singleton.admin.savexml();
    }//GEN-LAST:event_savexmlActionPerformed

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
