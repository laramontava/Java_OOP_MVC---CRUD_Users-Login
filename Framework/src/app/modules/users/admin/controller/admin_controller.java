/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.controller;

import app.modules.menu.controller.menu_controller;
import app.modules.menu.view.main_view;
import app.modules.users.admin.model.BLL.BLL_admin;
import app.modules.users.admin.model.classes.miniSimpleTableModel_admin;
import app.modules.users.admin.model.classes.singleton;
import static app.modules.users.admin.model.classes.singleton.admin;
import app.modules.users.admin.model.utils.autocomplete.AutocompleteJComboBox;
import app.modules.users.admin.model.utils.autocomplete.StringSearchable;
import app.modules.users.admin.model.utils.pager.pagina;
import app.modules.users.admin.view.adminmanage_view;
import static app.modules.users.admin.view.adminmanage_view.TABLA;
import static app.modules.users.admin.view.adminmanage_view.jComboBox1;
import static app.modules.users.admin.view.adminmanage_view.jPanel3;
import app.modules.users.admin.view.adminnew_view;
import static app.modules.users.admin.view.adminnew_view.createoredit;
import static app.modules.users.admin.view.adminnew_view.titlecreateedit;
import app.ppalmain;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lara
 */
public class admin_controller implements ActionListener, FocusListener, KeyListener, MouseListener {

    public static JTable tabla = null;
    public static adminmanage_view TableAdmin;
    public static adminnew_view Modificar;
    public static adminnew_view Crear;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_admin());
    public static AutocompleteJComboBox combo = null;

    public admin_controller(JFrame option, int i) {
        if (i == 0) {
            TableAdmin = (adminmanage_view) option;
        }
        if (i == 1) {
            Crear = (adminnew_view) option;
        }
        if (i == 2) {
            Modificar = (adminnew_view) option;
        }
    }

    public enum Option {
        btnCrear,
        btnModificar,
        btnEliminar,
        btnGuardarJson,
        btnGuardarXml,
        btnGuardarTxt,
        btnVolver,
        primero,
        ANTERIOR,
        SIGUIENTE,
        ultimo,
        ComboPager,
        tableAdmin,
        Search
    }

    public void Iniciar(int op) {
        if (op == 0) {
            ppalmain.singleton_vtna = "adminmanage_view";
            TableAdmin.setVisible(true);
            TableAdmin.setTitle("Gestión de administradores");
            TableAdmin.setLocationRelativeTo(null);
            TableAdmin.setResizable(false);

            TableAdmin.TABLA.setModel(new miniSimpleTableModel_admin());
            ((miniSimpleTableModel_admin) TABLA.getModel()).cargar();
            TableAdmin.TABLA.setFillsViewportHeight(true);
            TableAdmin.TABLA.setRowSorter(sorter);
            TableAdmin.TABLA.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    JTable table = (JTable) me.getSource();
                    Point p = me.getPoint();

                    int row = table.rowAtPoint(p);
                    if (me.getClickCount() == 2) {
                        if (BLL_admin.Modificar()) {
                            TableAdmin.dispose();
                            new adminnew_view().setVisible(true);
                            BLL_admin.LlenarCampos();
                            titlecreateedit.setText("Editar un usuario administrador");
                            createoredit.setVisible(false);
                        }
                    }
                }
            });

            pagina.inicializa();
            pagina.initLinkBox();

            TableAdmin.jLabel3.setText(String.valueOf(admin.getAdmins().size()));

            TableAdmin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    TableAdmin.dispose();
                    new main_view().setVisible(true);
                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int i = 0; i <= admin.getAdmins().size() - 1; i++) {
                myWords.add(admin.getAdmins().get(i).getName());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            combo = new AutocompleteJComboBox(searchable);
            jPanel3.setLayout(new java.awt.BorderLayout());
            jPanel3.add(combo);
            
            /*
            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });*/
            
            

            adminmanage_view.create_admin.setActionCommand("btnCrear");
            adminmanage_view.create_admin.addActionListener(this);

            adminmanage_view.edit_admin.setActionCommand("btnModificar");
            adminmanage_view.edit_admin.addActionListener(this);

            adminmanage_view.delete_admin.setActionCommand("btnEliminar");
            adminmanage_view.delete_admin.addActionListener(this);

            adminmanage_view.savejson.setActionCommand("btnGuardarJson");
            adminmanage_view.savejson.addActionListener(this);
            adminmanage_view.savexml.setActionCommand("btnGuardarXml");
            adminmanage_view.savexml.addActionListener(this);
            adminmanage_view.savetxt.setActionCommand("btnGuardarTxt");
            adminmanage_view.savetxt.addActionListener(this);

            adminmanage_view.jButton1.setActionCommand("btnVolver");
            adminmanage_view.jButton1.addActionListener(this);

            adminmanage_view.primero.setActionCommand("primero");
            adminmanage_view.primero.addActionListener(this);

            adminmanage_view.ANTERIOR.setActionCommand("ANTERIOR");
            adminmanage_view.ANTERIOR.addActionListener(this);

            adminmanage_view.SIGUIENTE.setActionCommand("SIGUIENTE");
            adminmanage_view.SIGUIENTE.addActionListener(this);

            adminmanage_view.ultimo.setActionCommand("ultimo");
            adminmanage_view.ultimo.addActionListener(this);

            adminmanage_view.jComboBox1.setActionCommand("ComboPager");
            adminmanage_view.jComboBox1.addActionListener(this);

            adminmanage_view.TABLA.setName("tableAdmin");
            adminmanage_view.TABLA.addMouseListener(this);

            adminmanage_view.searchby.setActionCommand("Search");
            adminmanage_view.searchby.addMouseListener(this);
        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        //    System.out.println("word selected: " + ((JComboBox)combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_admin) TABLA.getModel()).filtrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (admin_controller.Option.valueOf(e.getActionCommand())) {
            case btnCrear:
                break;
            case btnModificar:
                break;
            case btnEliminar:
                break;
            case btnGuardarJson:
                singleton.admin.savejson();
                break;
            case btnGuardarXml:
                singleton.admin.savexml();
                break;
            case btnGuardarTxt:
                singleton.admin.savetxt();
                break;
            case btnVolver:
                new menu_controller(new main_view(), 0).Iniciar(0);
                TableAdmin.dispose();
                break;
            case primero:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;
            case ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;
            case SIGUIENTE:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;
            case ultimo:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;
            case ComboPager:
                pagina.itemsPerPage = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent es) {

    }

    @Override
    public void keyReleased(KeyEvent et) {

    }

    @Override
    public void mouseClicked(MouseEvent ef) {
        switch (Option.valueOf(ef.getComponent().getName())) {
            case tableAdmin:
                if (ef.getClickCount() == 2) {
                    if (BLL_admin.Modificar()) {
                        TableAdmin.dispose();
                        new adminnew_view().setVisible(true);
                        BLL_admin.LlenarCampos();
                        titlecreateedit.setText("Editar un usuario administrador");
                        createoredit.setVisible(false);
                    }
                }
                break;

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
