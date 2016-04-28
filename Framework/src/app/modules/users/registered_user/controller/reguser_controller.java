/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.registered_user.controller;

import app.classes.singleton_global;
import static app.classes.singleton_global.Green;
import app.modules.SignIn.controller.login_controller;
import app.modules.SignIn.view.login;
import static app.modules.SignIn.view.login.statuslog;
import app.modules.menu.controller.menu_controller;
import app.modules.menu.view.main_view;
import app.modules.users.registered_user.model.BLL.BLL_reguser;
import app.modules.users.registered_user.model.BLL.lib_ficheros.json;
import app.modules.users.registered_user.model.classes.miniSimpleTableModel_reguser;
import app.modules.users.registered_user.model.classes.singleton_reguser;
import static app.modules.users.registered_user.model.classes.singleton_reguser.reguser;
import app.modules.users.registered_user.model.utils.autocomplete.AutocompleteJComboBox;
import app.modules.users.registered_user.model.utils.autocomplete.StringSearchable;
import app.modules.users.registered_user.model.utils.pager.pagina;
import static app.modules.users.registered_user.view.regusermanage_view.TABLA;
import static app.modules.users.registered_user.view.regusermanage_view.jComboBox1;
import static app.modules.users.registered_user.view.regusermanage_view.statusnewadmin;
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
import static app.modules.users.registered_user.view.regusermanage_view.searchby;
import app.modules.users.registered_user.view.regusermanage_view;
import app.modules.users.registered_user.view.regusernew_view;
import static app.modules.users.registered_user.view.regusernew_view.addactivity;
import static app.modules.users.registered_user.view.regusernew_view.addavatar;
import static app.modules.users.registered_user.view.regusernew_view.adddni;
import static app.modules.users.registered_user.view.regusernew_view.adddummies;
import static app.modules.users.registered_user.view.regusernew_view.addemail;
import static app.modules.users.registered_user.view.regusernew_view.addmobile;
import static app.modules.users.registered_user.view.regusernew_view.addname;
import static app.modules.users.registered_user.view.regusernew_view.addnameuser;
import static app.modules.users.registered_user.view.regusernew_view.addpassword;
import static app.modules.users.registered_user.view.regusernew_view.addsurname;
import static app.modules.users.registered_user.view.regusernew_view.avataradd;
import static app.modules.users.registered_user.view.regusernew_view.jlblcreate;
import static app.modules.users.registered_user.view.regusernew_view.titlecreateedit;
import javax.swing.JOptionPane;

/**
 *
 * @author Lara
 */
public class reguser_controller implements ActionListener, FocusListener, KeyListener, MouseListener {

    public static JTable tabla = null;
    public static regusermanage_view TableReguser;
    public static regusernew_view Modificar;
    public static regusernew_view Crear;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_reguser());
    public static AutocompleteJComboBox combo = null;
    int dia, mes, anyo;

    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "jpg", "png", "gif");
    String rutaimagen = "";

    public reguser_controller(JFrame option, int i) {
        if (i == 0) {
            TableReguser = (regusermanage_view) option;
        }
        if (i == 1) {
            Crear = (regusernew_view) option;
        }
        if (i == 2) {
            Modificar = (regusernew_view) option;
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
        btnAvatar,
        jtxtShopping,
        jtxtType,
        btnDummies,
        btnCreate,
        btnCancel,

    }

    public void Iniciar(int op) {
        if (op == 0) {
            ppalmain.singleton_vtna = "regusermanage_view";
            TableReguser.setVisible(true);
            TableReguser.setTitle("Gestión de usuarios registrados");
            TableReguser.setLocationRelativeTo(null);
            TableReguser.setResizable(false);

            TableReguser.TABLA.setModel(new miniSimpleTableModel_reguser());
            ((miniSimpleTableModel_reguser) TABLA.getModel()).cargar();
            TableReguser.TABLA.setFillsViewportHeight(true);
            TableReguser.TABLA.setRowSorter(sorter);
            TableReguser.TABLA.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    JTable table = (JTable) me.getSource();
                    Point p = me.getPoint();

                    int row = table.rowAtPoint(p);
                    if (me.getClickCount() == 2) {
                        if (BLL_reguser.Modificar()) {
                            TableReguser.dispose();
                            new reguser_controller(new regusernew_view(), 2).Iniciar(2);
                            BLL_reguser.LlenarCampos();
                            titlecreateedit.setText("Editar un cliente");
                            adddummies.setVisible(false);
                        }
                    }
                }
            });

            pagina.inicializa();
            pagina.initLinkBox();

            TableReguser.jLabel3.setText(String.valueOf(reguser.getUserreg().size()));

            TableReguser.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    TableReguser.dispose();
                    new main_view().setVisible(true);
                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int i = 0; i <= reguser.getUserreg().size() - 1; i++) {
                myWords.add(reguser.getUserreg().get(i).getName());
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

            regusermanage_view.create_admin.setActionCommand("btnCrear");
            regusermanage_view.create_admin.addActionListener(this);

            regusermanage_view.edit_admin.setActionCommand("btnModificar");
            regusermanage_view.edit_admin.addActionListener(this);

            regusermanage_view.delete_admin.setActionCommand("btnEliminar");
            regusermanage_view.delete_admin.addActionListener(this);

            regusermanage_view.savejson.setActionCommand("btnGuardarJson");
            regusermanage_view.savejson.addActionListener(this);
            regusermanage_view.savexml.setActionCommand("btnGuardarXml");
            regusermanage_view.savexml.addActionListener(this);
            regusermanage_view.savetxt.setActionCommand("btnGuardarTxt");
            regusermanage_view.savetxt.addActionListener(this);

            regusermanage_view.jButton1.setActionCommand("btnVolver");
            regusermanage_view.jButton1.addActionListener(this);

            regusermanage_view.primero.setActionCommand("primero");
            regusermanage_view.primero.addActionListener(this);

            regusermanage_view.ANTERIOR.setActionCommand("ANTERIOR");
            regusermanage_view.ANTERIOR.addActionListener(this);

            regusermanage_view.SIGUIENTE.setActionCommand("SIGUIENTE");
            regusermanage_view.SIGUIENTE.addActionListener(this);

            regusermanage_view.ultimo.setActionCommand("ultimo");
            regusermanage_view.ultimo.addActionListener(this);

            regusermanage_view.jComboBox1.setActionCommand("ComboPager");
            regusermanage_view.jComboBox1.addActionListener(this);

            regusermanage_view.TABLA.setName("tableAdmin");
            regusermanage_view.TABLA.addMouseListener(this);

        } else if (op == 1) {
            ppalmain.singleton_vtna = "regusernew_view";
            Crear.setVisible(true);
            Crear.setLocationRelativeTo(null);
            Crear.setSize(590, 571);
            Crear.setResizable(false);

            regusernew_view.adddni.setActionCommand("jtxtDni");
            regusernew_view.adddni.addKeyListener(this);
            regusernew_view.adddni.addActionListener(this);

            regusernew_view.addname.setActionCommand("jtxtName");
            regusernew_view.addname.addKeyListener(this);
            regusernew_view.addname.addActionListener(this);

            regusernew_view.addsurname.setActionCommand("jtxtSurname");
            regusernew_view.addsurname.addKeyListener(this);
            regusernew_view.addsurname.addActionListener(this);

            regusernew_view.addmobile.setActionCommand("jtxtMobile");
            regusernew_view.addmobile.addKeyListener(this);
            regusernew_view.addmobile.addActionListener(this);

            regusernew_view.addemail.setActionCommand("jtxtEmail");
            regusernew_view.addemail.addKeyListener(this);
            regusernew_view.addemail.addActionListener(this);

            regusernew_view.addnameuser.setActionCommand("jtxtNameUser");
            regusernew_view.addnameuser.addKeyListener(this);
            regusernew_view.addnameuser.addActionListener(this);

            regusernew_view.addpassword.setActionCommand("jtxtPasswd");
            regusernew_view.addpassword.addKeyListener(this);
            regusernew_view.addpassword.addActionListener(this);

            regusernew_view.avataradd.setActionCommand("btnAvatar");
            regusernew_view.avataradd.addActionListener(this);

            regusernew_view.addactivity.setActionCommand("jtxtShopping");
            regusernew_view.addactivity.addKeyListener(this);
            regusernew_view.addactivity.addActionListener(this);

            regusernew_view.adddummies.setActionCommand("btnDummies");
            regusernew_view.adddummies.addActionListener(this);

            regusernew_view.createclient.setActionCommand("btnCreate");
            regusernew_view.createclient.addActionListener(this);

            regusernew_view.cancelclient.setActionCommand("btnCancel");
            regusernew_view.cancelclient.addActionListener(this);

            Crear.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Crear.dispose();
                    new reguser_controller(new regusermanage_view(), 0).Iniciar(0);
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
        } else if (op == 2) {
            ppalmain.singleton_vtna = "regusernew_view";
            Modificar.setVisible(true);
            Modificar.setLocationRelativeTo(null);
            Modificar.setSize(590, 541);
            Modificar.setResizable(false);
            adddummies.setVisible(false);
            //BLL_reguser.LlenarCampos();
            titlecreateedit.setText("Editar usuario registrado");

            regusernew_view.adddni.setActionCommand("jtxtDni");
            regusernew_view.adddni.addKeyListener(this);
            regusernew_view.adddni.addActionListener(this);

            regusernew_view.addname.setActionCommand("jtxtName");
            regusernew_view.addname.addKeyListener(this);
            regusernew_view.addname.addActionListener(this);

            regusernew_view.addsurname.setActionCommand("jtxtSurname");
            regusernew_view.addsurname.addKeyListener(this);
            regusernew_view.addsurname.addActionListener(this);

            regusernew_view.addmobile.setActionCommand("jtxtMobile");
            regusernew_view.addmobile.addKeyListener(this);
            regusernew_view.addmobile.addActionListener(this);

            regusernew_view.addemail.setActionCommand("jtxtEmail");
            regusernew_view.addemail.addKeyListener(this);
            regusernew_view.addemail.addActionListener(this);

            regusernew_view.addnameuser.setActionCommand("jtxtNameUser");
            regusernew_view.addnameuser.addKeyListener(this);
            regusernew_view.addnameuser.addActionListener(this);

            regusernew_view.addpassword.setActionCommand("jtxtPasswd");
            regusernew_view.addpassword.addKeyListener(this);
            regusernew_view.addpassword.addActionListener(this);

            regusernew_view.addactivity.setActionCommand("jtxtShopping");
            regusernew_view.addactivity.addKeyListener(this);
            regusernew_view.addactivity.addActionListener(this);

            regusernew_view.adddummies.setActionCommand("btnDummies");
            regusernew_view.adddummies.addActionListener(this);

            regusernew_view.createclient.setActionCommand("btnCreate");
            regusernew_view.createclient.addActionListener(this);

            regusernew_view.cancelclient.setActionCommand("btnCancel");
            regusernew_view.cancelclient.addActionListener(this);

            Modificar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Modificar.dispose();
                    new reguser_controller(new regusermanage_view(), 0).Iniciar(0);
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
        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_reguser) TABLA.getModel()).filtrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (reguser_controller.Option.valueOf(e.getActionCommand())) {
            case btnCrear:
                new reguser_controller(new regusernew_view(), 1).Iniciar(1);
                TableReguser.dispose();
                break;
            case btnModificar:
                if (BLL_reguser.Modificar()) {
                    new reguser_controller(new regusernew_view(), 2).Iniciar(2);
                    BLL_reguser.LlenarCampos();
                    TableReguser.dispose();
                }
                break;
            case btnEliminar:
                BLL_reguser.Delete();
                break;
            case btnGuardarJson:
                singleton_reguser.reguser.savejson();
                break;
            case btnGuardarXml:
                singleton_reguser.reguser.savexml();
                break;
            case btnGuardarTxt:
                singleton_reguser.reguser.savetxt();
                break;
            case btnVolver:
                new menu_controller(new main_view(), 0).Iniciar(0);
                TableReguser.dispose();
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
                BLL_reguser.DniValidate();
                break;
            case jtxtName:
                BLL_reguser.NameValidate();
                break;
            case jtxtSurname:
                BLL_reguser.SurnameValidate();
                break;
            case jtxtMobile:
                BLL_reguser.MobileValidate();
                break;
            case jtxtEmail:
                BLL_reguser.EmailValidate();
                break;
            case jtxtNameUser:
                BLL_reguser.UserNameValidate();
                break;
            case jtxtPasswd:
                BLL_reguser.PasswordValidate();
                break;
            case jtxtShopping:
                BLL_reguser.ActivityValidate();
                break;
            case btnDummies:
                app.modules.users.registered_user.model.utils.dummies.LoadDummies();
                Crear.dispose();
                new reguser_controller(new regusermanage_view(), 0).Iniciar(0);
                break;
            case btnCreate:
                if (adddummies.isVisible()) {
                    if (BLL_reguser.adminsave()) {
                        new reguser_controller(new regusermanage_view(), 0).Iniciar(0);
                        Crear.dispose();
                        statusnewadmin.setText("Usuario creado correctamente");
                        statusnewadmin.setForeground(Green);
                    } else {
                        jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                        jlblcreate.setForeground(Color.red);
                    }
                } else if (BLL_reguser.Modificaradmin()) {
                    if(singleton_global.type=="Admin"){
                        new reguser_controller(new regusermanage_view(), 0).Iniciar(0);
                        Modificar.dispose();
                        statusnewadmin.setText("Usuario editado correctamente");
                        statusnewadmin.setForeground(Green);
                    } else {
                        new login_controller(new login()).Iniciar();
                        Modificar.dispose();
                        statuslog.setText("Se ha cerrado la sesión");
                    }
                } else {
                    jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                    jlblcreate.setForeground(Color.red);
                }
                break;
            case btnCancel:
                if (adddummies.isVisible()) {
                    new reguser_controller(new regusermanage_view(), 0).Iniciar(0);
                    Crear.dispose();
                    statusnewadmin.setText("Se ha cancelado la creación de un nuevo usuario");
                    statusnewadmin.setForeground(Color.red);
                } else {
                    if(singleton_global.type=="Admin"){
                        new reguser_controller(new regusermanage_view(), 0).Iniciar(0);
                        Modificar.dispose();
                        statusnewadmin.setText("Se ha cancelado la modificación de un usuario");
                        statusnewadmin.setForeground(Color.RED);
                    } else {
                        new login_controller(new login()).Iniciar();
                        Modificar.dispose();
                        statuslog.setText("Se ha cerrado la sesión");
                    }
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
                    if (BLL_reguser.Modificar()) {
                        TableReguser.dispose();
                        new reguser_controller(new regusernew_view(), 2).Iniciar(2);
                        BLL_reguser.LlenarCampos();
                        titlecreateedit.setText("Editar un usuario registrado");
                        adddummies.setVisible(false);
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
        BLL_reguser.DniValidate();
    }

    private void adddniKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.DniValidate();
    }

    private void adddniKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.DniValidate();
    }

    private void addnameKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_reguser.NameValidate();
    }

    private void addnameKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.NameValidate();
    }

    private void addnameKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.NameValidate();
    }

    private void addsurnameKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_reguser.SurnameValidate();
    }

    private void addsurnameKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.SurnameValidate();
    }

    private void addsurnameKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.SurnameValidate();
    }

    private void addmobileKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_reguser.MobileValidate();
    }

    private void addmobileKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.MobileValidate();
    }

    private void addmobileKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.MobileValidate();
    }

    private void addemailKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_reguser.EmailValidate();
    }

    private void addemailKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.EmailValidate();
    }

    private void addemailKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.EmailValidate();
    }

    private void addnameuserKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_reguser.UserNameValidate();
    }

    private void addnameuserKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.UserNameValidate();
    }

    private void addnameuserKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.UserNameValidate();
    }

    private void addpasswordKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_reguser.PasswordValidate();
    }

    private void addpasswordKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.PasswordValidate();
    }

    private void addpasswordKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.PasswordValidate();
    }

    private void addactivityKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_reguser.ActivityValidate();
    }

    private void addactivityKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_reguser.ActivityValidate();
    }

    private void addactivityKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_reguser.ActivityValidate();
    }
}
