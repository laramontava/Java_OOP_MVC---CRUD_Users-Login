/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.client.controller;

import app.classes.singleton_global;
import static app.classes.singleton_global.Green;
import app.modules.SignIn.controller.login_controller;
import app.modules.SignIn.view.login;
import static app.modules.SignIn.view.login.statuslog;
import app.modules.menu.controller.menu_controller;
import app.modules.menu.view.main_view;
import app.modules.users.client.model.BLL.BLL_client;
import app.modules.users.client.model.classes.miniSimpleTableModel_client;
import app.modules.users.client.model.classes.singleton_client;
import static app.modules.users.client.model.classes.singleton_client.client;
import app.modules.users.client.model.utils.autocomplete.AutocompleteJComboBox;
import app.modules.users.client.model.utils.autocomplete.StringSearchable;
import app.modules.users.client.model.utils.pager.pagina;
import static app.modules.users.client.view.clientmanage_view.TABLA;
import static app.modules.users.client.view.clientmanage_view.jComboBox1;
import static app.modules.users.client.view.clientmanage_view.statusnewadmin;
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
import static app.modules.users.client.view.clientmanage_view.searchby;
import app.modules.users.client.view.clientmanage_view;
import app.modules.users.client.view.clientnew_view;
import static app.modules.users.client.view.clientnew_view.adddummies;
import static app.modules.users.client.view.clientnew_view.avataradd;
import static app.modules.users.client.view.clientnew_view.jlblcreate;
import static app.modules.users.client.view.clientnew_view.titlecreateedit;
import static app.modules.users.client.view.clientnew_view.adddnic;
import static app.modules.users.client.view.clientnew_view.caddname;
import static app.modules.users.client.view.clientnew_view.caddsurname;
import static app.modules.users.client.view.clientnew_view.caddmobile;
import static app.modules.users.client.view.clientnew_view.caddemail;
import static app.modules.users.client.view.clientnew_view.caddnameuser;
import static app.modules.users.client.view.clientnew_view.caddpassword;
import static app.modules.users.client.view.clientnew_view.caddavatar;
import static app.modules.users.client.view.clientnew_view.caddshopping;
import static app.modules.users.client.view.clientnew_view.caddtype;
import javax.swing.JOptionPane;

/**
 *
 * @author Lara
 */
public class client_controller implements ActionListener, FocusListener, KeyListener, MouseListener {

    public static JTable tabla = null;
    public static clientmanage_view TableClient;
    public static clientnew_view Modificar;
    public static clientnew_view Crear;
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new miniSimpleTableModel_client());
    public static AutocompleteJComboBox combo = null;
    int dia, mes, anyo;
    
    
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de imagen", "jpg", "png", "gif");
    String rutaimagen = "";

    public client_controller(JFrame option, int i) {
        if (i == 0) {
            TableClient = (clientmanage_view) option;
        }
        if (i == 1) {
            Crear = (clientnew_view) option;
        }
        if (i == 2) {
            Modificar = (clientnew_view) option;
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
        btnLogOut

    }

    public void Iniciar(int op) {
        if (op == 0) {
            ppalmain.singleton_vtna = "clientmanage_view";
            TableClient.setVisible(true);//meh
            TableClient.setTitle("Gestión de clientes");
            TableClient.setLocationRelativeTo(null);
            TableClient.setResizable(false);

            TableClient.TABLA.setModel(new miniSimpleTableModel_client());
            ((miniSimpleTableModel_client) TABLA.getModel()).cargar();
            TableClient.TABLA.setFillsViewportHeight(true);
            TableClient.TABLA.setRowSorter(sorter);
            TableClient.TABLA.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    JTable table = (JTable) me.getSource();
                    Point p = me.getPoint();

                    int row = table.rowAtPoint(p);
                    if (me.getClickCount() == 2) {
                        if (BLL_client.Modificar()) {
                            TableClient.dispose();
                            new client_controller(new clientnew_view(), 2).Iniciar(2);
                            BLL_client.LlenarCampos();
                            titlecreateedit.setText("Editar un cliente");
                            adddummies.setVisible(false);
                        }
                    }
                }
            });

            pagina.inicializa();
            pagina.initLinkBox();

            TableClient.jLabel3.setText(String.valueOf(client.getClients().size()));

            TableClient.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    TableClient.dispose();
                    new main_view().setVisible(true);
                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int i = 0; i <= client.getClients().size() - 1; i++) {
                myWords.add(client.getClients().get(i).getName());
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

            clientmanage_view.create_admin.setActionCommand("btnCrear");
            clientmanage_view.create_admin.addActionListener(this);

            clientmanage_view.edit_admin.setActionCommand("btnModificar");
            clientmanage_view.edit_admin.addActionListener(this);

            clientmanage_view.delete_admin.setActionCommand("btnEliminar");
            clientmanage_view.delete_admin.addActionListener(this);

            clientmanage_view.savejson.setActionCommand("btnGuardarJson");
            clientmanage_view.savejson.addActionListener(this);
            clientmanage_view.savexml.setActionCommand("btnGuardarXml");
            clientmanage_view.savexml.addActionListener(this);
            clientmanage_view.savetxt.setActionCommand("btnGuardarTxt");
            clientmanage_view.savetxt.addActionListener(this);

            clientmanage_view.jButton1.setActionCommand("btnVolver");
            clientmanage_view.jButton1.addActionListener(this);

            clientmanage_view.primero.setActionCommand("primero");
            clientmanage_view.primero.addActionListener(this);

            clientmanage_view.ANTERIOR.setActionCommand("ANTERIOR");
            clientmanage_view.ANTERIOR.addActionListener(this);

            clientmanage_view.SIGUIENTE.setActionCommand("SIGUIENTE");
            clientmanage_view.SIGUIENTE.addActionListener(this);

            clientmanage_view.ultimo.setActionCommand("ultimo");
            clientmanage_view.ultimo.addActionListener(this);

            clientmanage_view.jComboBox1.setActionCommand("ComboPager");
            clientmanage_view.jComboBox1.addActionListener(this);

            clientmanage_view.TABLA.setName("tableAdmin");
            clientmanage_view.TABLA.addMouseListener(this);

        } else if (op == 1) {
            ppalmain.singleton_vtna = "clientnew_view";
            Crear.setVisible(true);
            Crear.setLocationRelativeTo(null);
            Crear.setSize(590, 571);
            Crear.setResizable(false);
            
            clientnew_view.cadddesc.setEditable(false);
            clientnew_view.caddyearsservice.setEditable(false);

            clientnew_view.adddnic.setActionCommand("jtxtDni");
            clientnew_view.adddnic.addKeyListener(this);
            clientnew_view.adddnic.addActionListener(this);

            clientnew_view.caddname.setActionCommand("jtxtName");
            clientnew_view.caddname.addKeyListener(this);
            clientnew_view.caddname.addActionListener(this);

            clientnew_view.caddsurname.setActionCommand("jtxtSurname");
            clientnew_view.caddsurname.addKeyListener(this);
            clientnew_view.caddsurname.addActionListener(this);

            clientnew_view.caddmobile.setActionCommand("jtxtMobile");
            clientnew_view.caddmobile.addKeyListener(this);
            clientnew_view.caddmobile.addActionListener(this);

            clientnew_view.caddemail.setActionCommand("jtxtEmail");
            clientnew_view.caddemail.addKeyListener(this);
            clientnew_view.caddemail.addActionListener(this);

            clientnew_view.caddnameuser.setActionCommand("jtxtNameUser");
            clientnew_view.caddnameuser.addKeyListener(this);
            clientnew_view.caddnameuser.addActionListener(this);

            clientnew_view.caddpassword.setActionCommand("jtxtPasswd");
            clientnew_view.caddpassword.addKeyListener(this);
            clientnew_view.caddpassword.addActionListener(this);

            clientnew_view.avataradd.setActionCommand("btnAvatar");
            clientnew_view.avataradd.addActionListener(this);

            clientnew_view.caddshopping.setActionCommand("jtxtShopping");
            clientnew_view.caddshopping.addKeyListener(this);
            clientnew_view.caddshopping.addActionListener(this);

            clientnew_view.caddtype.setActionCommand("jtxtType");
            clientnew_view.caddtype.addKeyListener(this);
            clientnew_view.caddtype.addActionListener(this);

            clientnew_view.adddummies.setActionCommand("btnDummies");
            clientnew_view.adddummies.addActionListener(this);

            clientnew_view.createclient.setActionCommand("btnCreate");
            clientnew_view.createclient.addActionListener(this);

            clientnew_view.cancelclient.setActionCommand("btnCancel");
            clientnew_view.cancelclient.addActionListener(this);

            Crear.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Crear.dispose();
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
                }
            });
            
            adddnic.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddname.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddsurname.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddmobile.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddemail.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddnameuser.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddpassword.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddshopping.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addshoppingKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addshoppingKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addshoppingKeyTyped(evt);
                }
            });
            caddtype.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addtypeKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addtypeKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addtypeKeyTyped(evt);
                }
            });
        } else if (op == 2) {
            ppalmain.singleton_vtna = "clientnew_view";
            Modificar.setVisible(true);
            Modificar.setLocationRelativeTo(null);
            Modificar.setSize(590, 571);
            Modificar.setResizable(false);
            adddummies.setVisible(false);
            //BLL_client.LlenarCampos();
            clientnew_view.cadddesc.setEditable(false);
            clientnew_view.caddyearsservice.setEditable(false);
            titlecreateedit.setText(singleton_global.translate.getProperty("edittit"));

            clientnew_view.adddnic.setActionCommand("jtxtDni");
            clientnew_view.adddnic.addKeyListener(this);
            clientnew_view.adddnic.addActionListener(this);

            clientnew_view.caddname.setActionCommand("jtxtName");
            clientnew_view.caddname.addKeyListener(this);
            clientnew_view.caddname.addActionListener(this);

            clientnew_view.caddsurname.setActionCommand("jtxtSurname");
            clientnew_view.caddsurname.addKeyListener(this);
            clientnew_view.caddsurname.addActionListener(this);

            clientnew_view.caddmobile.setActionCommand("jtxtMobile");
            clientnew_view.caddmobile.addKeyListener(this);
            clientnew_view.caddmobile.addActionListener(this);

            clientnew_view.caddemail.setActionCommand("jtxtEmail");
            clientnew_view.caddemail.addKeyListener(this);
            clientnew_view.caddemail.addActionListener(this);

            clientnew_view.caddnameuser.setActionCommand("jtxtNameUser");
            clientnew_view.caddnameuser.addKeyListener(this);
            clientnew_view.caddnameuser.addActionListener(this);

            clientnew_view.caddpassword.setActionCommand("jtxtPasswd");
            clientnew_view.caddpassword.addKeyListener(this);
            clientnew_view.caddpassword.addActionListener(this);

            clientnew_view.caddshopping.setActionCommand("jtxtSalary");
            clientnew_view.caddshopping.addKeyListener(this);
            clientnew_view.caddshopping.addActionListener(this);

            clientnew_view.cadddesc.setActionCommand("jtxtActivity");
            clientnew_view.cadddesc.addKeyListener(this);
            clientnew_view.cadddesc.addActionListener(this);

            clientnew_view.adddummies.setActionCommand("btnDummies");
            clientnew_view.adddummies.addActionListener(this);

            clientnew_view.createclient.setActionCommand("btnCreate");
            clientnew_view.createclient.addActionListener(this);

            clientnew_view.cancelclient.setActionCommand("btnCancel");
            clientnew_view.cancelclient.addActionListener(this);

            clientnew_view.logoutclient.setActionCommand("btnLogOut");
            clientnew_view.logoutclient.addActionListener(this);
            
            if(singleton_global.type=="admin"){
                clientnew_view.logoutclient.setVisible(false);
            }
            Modificar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Modificar.dispose();
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
                }
            });
            
            adddnic.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddname.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddsurname.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddmobile.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddemail.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddnameuser.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddpassword.addKeyListener(new java.awt.event.KeyAdapter() {
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
            caddshopping.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addshoppingKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addshoppingKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addshoppingKeyTyped(evt);
                }
            });
            caddtype.addKeyListener(new java.awt.event.KeyAdapter() {
                @Override
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    addtypeKeyPressed(evt);
                }
                @Override
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    addtypeKeyReleased(evt);
                }
                @Override
                public void keyTyped(java.awt.event.KeyEvent evt) {
                    addtypeKeyTyped(evt);
                }
            });
        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        pagina.currentPageIndex = 1;
        ((miniSimpleTableModel_client) TABLA.getModel()).filtrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (client_controller.Option.valueOf(e.getActionCommand())) {
            case btnCrear:
                new client_controller(new clientnew_view(), 1).Iniciar(1);
                TableClient.dispose();
                break;
            case btnModificar:
                if (BLL_client.Modificar()) {
                    new client_controller(new clientnew_view(), 2).Iniciar(2);
                    BLL_client.LlenarCampos();
                    TableClient.dispose();
                }
                break;
            case btnEliminar:
                BLL_client.Delete();
                break;
            case btnGuardarJson:
                singleton_client.client.savejson();
                break;
            case btnGuardarXml:
                singleton_client.client.savexml();
                break;
            case btnGuardarTxt:
                singleton_client.client.savetxt();
                break;
            case btnVolver:
                new menu_controller(new main_view(), 0).Iniciar(0);
                TableClient.dispose();
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
                BLL_client.DniValidate();
                break;
            case jtxtName:
                BLL_client.NameValidate();
                break;
            case jtxtSurname:
                BLL_client.SurnameValidate();
                break;
            case jtxtMobile:
                BLL_client.MobileValidate();
                break;
            case jtxtEmail:
                BLL_client.EmailValidate();
                break;
            case jtxtNameUser:
                BLL_client.UserNameValidate();
                break;
            case jtxtPasswd:
                BLL_client.PasswordValidate();
                break;
            case jtxtShopping:
                BLL_client.SalaryValidate();
                break;
            case btnDummies:
                app.modules.users.client.model.utils.dummies.LoadDummies();
                Crear.dispose();
                new client_controller(new clientmanage_view(), 0).Iniciar(0);
                break;
            case btnCreate:
                if (adddummies.isVisible()) {
                    if (BLL_client.adminsave()) {
                        new client_controller(new clientmanage_view(), 0).Iniciar(0);
                        Crear.dispose();
                        statusnewadmin.setText("Cliente creado correctamente");
                        statusnewadmin.setForeground(Green);
                    } else {
                        jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                        jlblcreate.setForeground(Color.red);
                    }
                } else if (BLL_client.Modificaradmin()) {
                    if(singleton_global.type=="admin"){
                        new client_controller(new clientmanage_view(), 0).Iniciar(0);
                        Modificar.dispose();
                        statusnewadmin.setText("Cliente editado correctamente");
                        statusnewadmin.setForeground(Green);
                    } else {
                        new login_controller(new login()).Iniciar();
                        Modificar.dispose();
                        statuslog.setText("Se han guardado los cambios");
                    }
                } else {
                    jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                    jlblcreate.setForeground(Color.red);
                }
                break;
            case btnCancel:
                if (adddummies.isVisible()) {
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
                    Crear.dispose();
                    statusnewadmin.setText("Se ha cancelado la creación de un nuevo cliente");
                    statusnewadmin.setForeground(Color.red);
                } else {
                    if(singleton_global.type=="admin"){
                        new client_controller(new clientmanage_view(), 0).Iniciar(0);
                        Modificar.dispose();
                        statusnewadmin.setText("Se ha cancelado la modificación de un cliente");
                        statusnewadmin.setForeground(Color.RED);
                    } else {
                        new login_controller(new login()).Iniciar();
                        Modificar.dispose();
                        statuslog.setText("Se han cancelado los cambios");
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
                    caddavatar.setText(fileurl);
                }
                break;
            case btnLogOut:
                JOptionPane.showMessageDialog(null, "Esperamos que vuelva pronto");
                System.exit(0);
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
                    if (BLL_client.Modificar()) {
                        TableClient.dispose();
                        new client_controller(new clientnew_view(), 2).Iniciar(2);
                        BLL_client.LlenarCampos();
                        titlecreateedit.setText("Editar un cliente");
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
        BLL_client.DniValidate();
    }

    private void adddniKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.DniValidate();
    }

    private void adddniKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.DniValidate();
    }

    private void addnameKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.NameValidate();
    }

    private void addnameKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.NameValidate();
    }

    private void addnameKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.NameValidate();
    }

    private void addsurnameKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.SurnameValidate();
    }

    private void addsurnameKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.SurnameValidate();
    }

    private void addsurnameKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.SurnameValidate();
    }

    private void addmobileKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.MobileValidate();
    }

    private void addmobileKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.MobileValidate();
    }

    private void addmobileKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.MobileValidate();
    }

    private void addemailKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.EmailValidate();
    }

    private void addemailKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.EmailValidate();
    }

    private void addemailKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.EmailValidate();
    }

    private void addnameuserKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.UserNameValidate();
    }

    private void addnameuserKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.UserNameValidate();
    }

    private void addnameuserKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.UserNameValidate();
    }

    private void addpasswordKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.PasswordValidate();
    }

    private void addpasswordKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.PasswordValidate();
    }

    private void addpasswordKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.PasswordValidate();
    }
    private void addshoppingKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.SalaryValidate();
    }

    private void addshoppingKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.SalaryValidate();
    }

    private void addshoppingKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.SalaryValidate();
    }
    private void addtypeKeyPressed(java.awt.event.KeyEvent evt) {
        BLL_client.TypeValidate();
    }

    private void addtypeKeyReleased(java.awt.event.KeyEvent evt) {
        BLL_client.TypeValidate();
    }

    private void addtypeKeyTyped(java.awt.event.KeyEvent evt) {
        BLL_client.TypeValidate();
    }
    
}
