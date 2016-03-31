/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.client.controller;

import app.classes.singleton_global;
import static app.classes.singleton_global.Green;
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
import app.modules.users.client.view.regusernew_view;
import static app.modules.users.client.view.regusernew_view.addavatar;
import static app.modules.users.client.view.regusernew_view.adddummies;
import static app.modules.users.client.view.regusernew_view.avataradd;
import static app.modules.users.client.view.regusernew_view.jlblcreate;
import static app.modules.users.client.view.regusernew_view.titlecreateedit;

/**
 *
 * @author Lara
 */
public class client_controller implements ActionListener, FocusListener, KeyListener, MouseListener {

    public static JTable tabla = null;
    public static clientmanage_view TableClient;
    public static regusernew_view Modificar;
    public static regusernew_view Crear;
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
                            //meh new adminnew_view().setVisible(true);
                            new client_controller(new regusernew_view(), 2).Iniciar(2);
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
            
            regusernew_view.adddesc.setEditable(false);
            regusernew_view.addyearsservice.setEditable(false);

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

            regusernew_view.addshopping.setActionCommand("jtxtShopping");
            regusernew_view.addshopping.addKeyListener(this);
            regusernew_view.addshopping.addActionListener(this);

            regusernew_view.addtype.setActionCommand("jtxtType");
            regusernew_view.addtype.addKeyListener(this);
            regusernew_view.addtype.addActionListener(this);

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
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
                }
            });
        } else if (op == 2) {
            ppalmain.singleton_vtna = "adminnew_view";
            Modificar.setVisible(true);
            Modificar.setLocationRelativeTo(null);
            Modificar.setSize(590, 541);
            Modificar.setResizable(false);
            adddummies.setVisible(false);
            BLL_client.LlenarCampos();
            regusernew_view.adddesc.setEditable(false);
            regusernew_view.addyearsservice.setEditable(false);
            titlecreateedit.setText(singleton_global.translate.getProperty("edittit"));

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

            regusernew_view.addshopping.setActionCommand("jtxtSalary");
            regusernew_view.addshopping.addKeyListener(this);
            regusernew_view.addshopping.addActionListener(this);

            regusernew_view.adddesc.setActionCommand("jtxtActivity");
            regusernew_view.adddesc.addKeyListener(this);
            regusernew_view.adddesc.addActionListener(this);

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
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
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
                new client_controller(new regusernew_view(), 1).Iniciar(1);
                TableClient.dispose();
                break;
            case btnModificar:
                if (BLL_client.Modificar()) {
                    new client_controller(new regusernew_view(), 2).Iniciar(2);
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
                        statusnewadmin.setText("Admin creado correctamente");
                        statusnewadmin.setForeground(Green);
                    } else {
                        jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                        jlblcreate.setForeground(Color.red);
                    }
                } else if (BLL_client.Modificaradmin()) {
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
                    Modificar.dispose();
                    statusnewadmin.setText("Admin editado correctamente");
                    statusnewadmin.setForeground(Green);
                } else {
                    jlblcreate.setText("Asegúrate de haber introducido bien los datos");
                    jlblcreate.setForeground(Color.red);
                }
                break;
            case btnCancel:
                if (adddummies.isVisible()) {
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
                    Crear.dispose();
                    statusnewadmin.setText("Se ha cancelado la creación de un nuevo admin");
                    statusnewadmin.setForeground(Color.red);
                } else {
                    new client_controller(new clientmanage_view(), 0).Iniciar(0);
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
                    if (BLL_client.Modificar()) {
                        TableClient.dispose();
                        //meh    new adminnew_view().setVisible(true);
                        new client_controller(new regusernew_view(), 2).Iniciar(2);
                        BLL_client.LlenarCampos();
                        titlecreateedit.setText("Editar un usuario administrador");
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

}
