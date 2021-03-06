/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.controller;

import app.classes.singleton_global;
import static app.classes.singleton_global.Green;
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
import static app.modules.users.admin.view.adminmanage_view.statusnewadmin;
import app.modules.users.admin.view.adminnew_view;
import static app.modules.users.admin.view.adminnew_view.addavatar;
import static app.modules.users.admin.view.adminnew_view.avataradd;
import static app.modules.users.admin.view.adminnew_view.jlblcreate;
import static app.modules.users.admin.view.adminnew_view.titlecreateedit;
import app.ppalmain;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.Color;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static app.modules.users.admin.view.adminmanage_view.searchby;
import static app.modules.users.admin.view.adminnew_view.addactivity;
import static app.modules.users.admin.view.adminnew_view.adddni;
import static app.modules.users.admin.view.adminnew_view.addemail;
import static app.modules.users.admin.view.adminnew_view.addmobile;
import static app.modules.users.admin.view.adminnew_view.addname;
import static app.modules.users.admin.view.adminnew_view.addnameuser;
import static app.modules.users.admin.view.adminnew_view.addpassword;
import static app.modules.users.admin.view.adminnew_view.addsalary;
import static app.modules.users.admin.view.adminnew_view.addsurname;
import static app.modules.users.admin.view.adminnew_view.dummiesornormal;
import app.utils.theme;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    int dia, mes, anyo;
    public static int selected;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "jpg", "png", "gif");
    String rutaimagen = "";

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
        Search,
        //
        jtxtDni,
        jtxtName,
        jtxtSurname,
        jtxtMobile,
        jtxtEmail,
        jtxtNameUser,
        jtxtPasswd,
        jtxtSalary,
        jtxtActivity,
        btnDummies,
        btnCreate,
        btnCancel,
        btnAvatar
    }

    public void Iniciar(int op) {
        if (op == 0) {
            ppalmain.singleton_vtna = "adminmanage_view";
            TableAdmin.setVisible(true);
            TableAdmin.setTitle("Gestión de administradores");
            TableAdmin.setLocationRelativeTo(null);
            TableAdmin.setResizable(false);
            theme.temaElegido(singleton_global.conf.getTheme());
            adminmanage_view.create_admin.setToolTipText(singleton_global.translate.getProperty("CreateuserT"));
            adminmanage_view.edit_admin.setToolTipText(singleton_global.translate.getProperty("EditUser"));
            adminmanage_view.delete_admin.setToolTipText(singleton_global.translate.getProperty("DeleteUser"));

            TableAdmin.TABLA.setModel(new miniSimpleTableModel_admin());
            ((miniSimpleTableModel_admin) TABLA.getModel()).cargar();
            TableAdmin.TABLA.setFillsViewportHeight(true);
            TableAdmin.TABLA.setRowSorter(sorter);
            TableAdmin.TABLA.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent me) {
                    JTable table = (JTable) me.getSource();
                    Point p = me.getPoint();

                    int row = table.rowAtPoint(p);
                    if (me.getClickCount() == 2) {
                        if (BLL_admin.Modificar()) {
                            TableAdmin.dispose();
                            new admin_controller(new adminnew_view(), 2).Iniciar(2);
                            BLL_admin.LlenarCampos();
                            titlecreateedit.setText("Editar un usuario administrador");
                            dummiesornormal.setVisible(false);
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
            searchby.setLayout(new java.awt.BorderLayout());
            searchby.add(combo);

            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });

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

        } else if (op == 1) {
            ppalmain.singleton_vtna = "adminnew_view";
            Crear.setVisible(true);
            Crear.setLocationRelativeTo(null);
            Crear.setSize(590, 541);
            Crear.setResizable(false);
            theme.temaElegido(singleton_global.conf.getTheme());
            switch (singleton_global.conf.getCurrency()) {
                case 'e':
                    adminnew_view.currency.setText("€");
                    break;
                case 'd':
                    adminnew_view.currency.setText("$");
                    break;
                case 'l':
                    adminnew_view.currency.setText("£");
                    break;
                default:
                    break;
            }
            adminnew_view.adddni.setActionCommand("jtxtDni");
            adminnew_view.adddni.addKeyListener(this);
            adminnew_view.adddni.addActionListener(this);

            adminnew_view.addname.setActionCommand("jtxtName");
            adminnew_view.addname.addKeyListener(this);
            adminnew_view.addname.addActionListener(this);

            adminnew_view.addsurname.setActionCommand("jtxtSurname");
            adminnew_view.addsurname.addKeyListener(this);
            adminnew_view.addsurname.addActionListener(this);

            adminnew_view.addmobile.setActionCommand("jtxtMobile");
            adminnew_view.addmobile.addKeyListener(this);
            adminnew_view.addmobile.addActionListener(this);

            adminnew_view.addemail.setActionCommand("jtxtEmail");
            adminnew_view.addemail.addKeyListener(this);
            adminnew_view.addemail.addActionListener(this);

            adminnew_view.addnameuser.setActionCommand("jtxtNameUser");
            adminnew_view.addnameuser.addKeyListener(this);
            adminnew_view.addnameuser.addActionListener(this);

            adminnew_view.addpassword.setActionCommand("jtxtPasswd");
            adminnew_view.addpassword.addKeyListener(this);
            adminnew_view.addpassword.addActionListener(this);

            adminnew_view.addsalary.setActionCommand("jtxtSalary");
            adminnew_view.addsalary.addKeyListener(this);
            adminnew_view.addsalary.addActionListener(this);

            adminnew_view.addactivity.setActionCommand("jtxtActivity");
            adminnew_view.addactivity.addKeyListener(this);
            adminnew_view.addactivity.addActionListener(this);

            adminnew_view.adddummies.setActionCommand("btnDummies");
            adminnew_view.adddummies.addActionListener(this);

            adminnew_view.createadmin.setActionCommand("btnCreate");
            adminnew_view.createadmin.addActionListener(this);

            adminnew_view.canceladmin.setActionCommand("btnCancel");
            adminnew_view.canceladmin.addActionListener(this);

            adminnew_view.avataradd.setActionCommand("btnAvatar");
            adminnew_view.avataradd.addActionListener(this);

            Crear.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Crear.dispose();
                    new admin_controller(new adminmanage_view(), 0).Iniciar(0);
                }
            });

            adddni.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    adddniKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    adddniKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    adddniKeyTyped(evt);
                }
            });
            addname.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addnameKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addnameKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addnameKeyTyped(evt);
                }
            });
            addsurname.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addsurnameKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addsurnameKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addsurnameKeyTyped(evt);
                }
            });
            addmobile.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addmobileKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addmobileKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addmobileKeyTyped(evt);
                }
            });
            addemail.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addemailKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addemailKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addemailKeyTyped(evt);
                }
            });
            addnameuser.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addnameuserKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addnameuserKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addnameuserKeyTyped(evt);
                }
            });
            addpassword.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addpasswordKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addpasswordKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addpasswordKeyTyped(evt);
                }
            });
            addactivity.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addactivityKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addactivityKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addactivityKeyTyped(evt);
                }
            });
            addsalary.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addsalaryKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addsalaryKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addsalaryKeyTyped(evt);
                }
            });
        } else if (op == 2) {
            ppalmain.singleton_vtna = "adminnew_view";
            Modificar.setVisible(true);
            Modificar.setLocationRelativeTo(null);
            Modificar.setSize(590, 541);
            Modificar.setResizable(false);
            dummiesornormal.setVisible(false);
            BLL_admin.LlenarCampos();
            theme.temaElegido(singleton_global.conf.getTheme());

            titlecreateedit.setText(singleton_global.translate.getProperty("edittit"));

            switch (singleton_global.conf.getCurrency()) {
                case 'e':
                    adminnew_view.currency.setText("€");
                    break;
                case 'd':
                    adminnew_view.currency.setText("$");
                    break;
                case 'l':
                    adminnew_view.currency.setText("£");
                    break;
                default:
                    break;
            }

            adminnew_view.adddni.setActionCommand("jtxtDni");
            adminnew_view.adddni.addKeyListener(this);
            adminnew_view.adddni.addActionListener(this);

            adminnew_view.addname.setActionCommand("jtxtName");
            adminnew_view.addname.addKeyListener(this);
            adminnew_view.addname.addActionListener(this);

            adminnew_view.addsurname.setActionCommand("jtxtSurname");
            adminnew_view.addsurname.addKeyListener(this);
            adminnew_view.addsurname.addActionListener(this);

            adminnew_view.addmobile.setActionCommand("jtxtMobile");
            adminnew_view.addmobile.addKeyListener(this);
            adminnew_view.addmobile.addActionListener(this);

            adminnew_view.addemail.setActionCommand("jtxtEmail");
            adminnew_view.addemail.addKeyListener(this);
            adminnew_view.addemail.addActionListener(this);

            adminnew_view.addnameuser.setActionCommand("jtxtNameUser");
            adminnew_view.addnameuser.addKeyListener(this);
            adminnew_view.addnameuser.addActionListener(this);

            adminnew_view.addpassword.setActionCommand("jtxtPasswd");
            adminnew_view.addpassword.addKeyListener(this);
            adminnew_view.addpassword.addActionListener(this);

            adminnew_view.addsalary.setActionCommand("jtxtSalary");
            adminnew_view.addsalary.addKeyListener(this);
            adminnew_view.addsalary.addActionListener(this);

            adminnew_view.addactivity.setActionCommand("jtxtActivity");
            adminnew_view.addactivity.addKeyListener(this);
            adminnew_view.addactivity.addActionListener(this);

            adminnew_view.adddummies.setActionCommand("btnDummies");
            adminnew_view.adddummies.addActionListener(this);

            adminnew_view.createadmin.setActionCommand("btnCreate");
            adminnew_view.createadmin.addActionListener(this);

            adminnew_view.canceladmin.setActionCommand("btnCancel");
            adminnew_view.canceladmin.addActionListener(this);

            Modificar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Modificar.dispose();
                    new admin_controller(new adminmanage_view(), 0).Iniciar(0);
                }
            });
            
            adddni.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    adddniKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    adddniKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    adddniKeyTyped(evt);
                }
            });
            addname.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addnameKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addnameKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addnameKeyTyped(evt);
                }
            });
            addsurname.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addsurnameKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addsurnameKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addsurnameKeyTyped(evt);
                }
            });
            addmobile.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addmobileKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addmobileKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addmobileKeyTyped(evt);
                }
            });
            addemail.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addemailKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addemailKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addemailKeyTyped(evt);
                }
            });
            addnameuser.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addnameuserKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addnameuserKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addnameuserKeyTyped(evt);
                }
            });
            addpassword.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addpasswordKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addpasswordKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addpasswordKeyTyped(evt);
                }
            });
            addactivity.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addactivityKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addactivityKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addactivityKeyTyped(evt);
                }
            });
            addsalary.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addsalaryKeyPressed(evt);
                }

                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addsalaryKeyReleased(evt);
                }

                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addsalaryKeyTyped(evt);
                }
            });
        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_admin) TABLA.getModel()).filtrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (admin_controller.Option.valueOf(e.getActionCommand())) {
            case btnCrear:
                new admin_controller(new adminnew_view(), 1).Iniciar(1);
                TableAdmin.dispose();
                break;
            case btnModificar:
                //if (BLL_admin.Modificar()) {
                if (BLL_admin.modificarAdminBBDD()) {
                    new admin_controller(new adminnew_view(), 2).Iniciar(2);
                    TableAdmin.dispose();
                }
                break;
            case btnEliminar:
                BLL_admin.eliminarAdminBBDD();
                BLL_admin.Delete();
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
            case jtxtDni: //validaciones
                BLL_admin.DniValidate();
                break;
            case jtxtName:
                BLL_admin.NameValidate();
                break;
            case jtxtSurname:
                BLL_admin.SurnameValidate();
                break;
            case jtxtMobile:
                BLL_admin.MobileValidate();
                break;
            case jtxtEmail:
                BLL_admin.EmailValidate();
                break;
            case jtxtNameUser:
                BLL_admin.UserNameValidate();
                break;
            case jtxtPasswd:
                BLL_admin.PasswordValidate();
                break;
            case jtxtSalary:
                BLL_admin.SalaryValidate();
                break;
            case jtxtActivity:
                BLL_admin.ActivityValidate();
                break;
            case btnDummies:
                app.modules.users.admin.model.utils.dummies.LoadDummies();
                Crear.dispose();
                new admin_controller(new adminmanage_view(), 0).Iniciar(0);
                break;
            case btnCreate:
                if (dummiesornormal.isVisible()) {
                    try {
                        //if (BLL_admin.adminsave()) {
                        if (BLL_admin.crearAdminBBDD()) {

                            new admin_controller(new adminmanage_view(), 0).Iniciar(0);
                            Crear.dispose();
                            statusnewadmin.setText("Admin creado correctamente");
                            statusnewadmin.setForeground(Green);
                        } else {
                            jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                            jlblcreate.setForeground(Color.red);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(admin_controller.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } //else if (BLL_admin.Modificaradmin()) {
                else if (BLL_admin.modificarAdminBBDD()) {
                    new admin_controller(new adminmanage_view(), 0).Iniciar(0);
                    Modificar.dispose();
                    statusnewadmin.setText("Admin editado correctamente");
                    statusnewadmin.setForeground(Green);
                } else {
                    jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                    jlblcreate.setForeground(Color.red);
                }
                break;
            case btnCancel:
                if (dummiesornormal.isVisible()) {
                    new admin_controller(new adminmanage_view(), 0).Iniciar(0);
                    Crear.dispose();
                    statusnewadmin.setText("Se ha cancelado la creación de un nuevo admin");
                    statusnewadmin.setForeground(Color.red);
                } else {
                    new admin_controller(new adminmanage_view(), 0).Iniciar(0);
                    Modificar.dispose();
                    statusnewadmin.setText("Se ha cancelado la modificación de un admin");
                    statusnewadmin.setForeground(Color.RED);
                }
                break;
            case btnAvatar:
                JFileChooser dlg = new JFileChooser();
                dlg.setFileFilter(filter);
                int option = dlg.showOpenDialog(avataradd);
                if (option == JFileChooser.APPROVE_OPTION) {
                    String filename = dlg.getSelectedFile().getPath();
                    String fileurl = dlg.getSelectedFile().toString();
                    addavatar.setText(fileurl);
                }
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
                        new admin_controller(new adminnew_view(), 2).Iniciar(2);
                        BLL_admin.LlenarCampos();
                        titlecreateedit.setText("Editar un usuario administrador");
                        dummiesornormal.setVisible(false);
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

    private void adddniKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.DniValidate();
    }

    private void adddniKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.DniValidate();
    }

    private void adddniKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.DniValidate();
    }

    private void addnameKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.NameValidate();
    }

    private void addnameKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.NameValidate();
    }

    private void addnameKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.NameValidate();
    }

    private void addsurnameKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.SurnameValidate();
    }

    private void addsurnameKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.SurnameValidate();
    }

    private void addsurnameKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.SurnameValidate();
    }

    private void addmobileKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.MobileValidate();
    }

    private void addmobileKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.MobileValidate();
    }

    private void addmobileKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.MobileValidate();
    }

    private void addemailKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.EmailValidate();
    }

    private void addemailKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.EmailValidate();
    }

    private void addemailKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.EmailValidate();
    }

    private void addnameuserKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.UserNameValidate();
    }

    private void addnameuserKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.UserNameValidate();
    }

    private void addnameuserKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.UserNameValidate();
    }

    private void addpasswordKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.PasswordValidate();
    }

    private void addpasswordKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.PasswordValidate();
    }

    private void addpasswordKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.PasswordValidate();
    }

    private void addsalaryKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.SalaryValidate();
    }

    private void addsalaryKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.SalaryValidate();
    }

    private void addsalaryKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.SalaryValidate();
    }

    private void addactivityKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_admin.ActivityValidate();
    }

    private void addactivityKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_admin.ActivityValidate();
    }

    private void addactivityKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_admin.ActivityValidate();
    }
}
