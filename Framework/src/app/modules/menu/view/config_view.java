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
public class config_view extends javax.swing.JFrame {

    /**
     * Creates new form config_view
     */
    public config_view() {
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

        dateformat = new javax.swing.JDialog();
        dateformat1 = new javax.swing.JRadioButton();
        dateformat2 = new javax.swing.JRadioButton();
        dateformat3 = new javax.swing.JRadioButton();
        dateformat4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        date_group = new javax.swing.ButtonGroup();
        decimalsformat = new javax.swing.JDialog();
        decimals1 = new javax.swing.JRadioButton();
        decimals2 = new javax.swing.JRadioButton();
        decimals3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        decimals_group = new javax.swing.ButtonGroup();
        themeformat = new javax.swing.JDialog();
        metal = new javax.swing.JRadioButton();
        windows = new javax.swing.JRadioButton();
        motif = new javax.swing.JRadioButton();
        nimbus = new javax.swing.JRadioButton();
        theme_group = new javax.swing.ButtonGroup();
        fileformat = new javax.swing.JDialog();
        json = new javax.swing.JRadioButton();
        txt = new javax.swing.JRadioButton();
        xml = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        formatfile_group = new javax.swing.ButtonGroup();
        currencyformat = new javax.swing.JDialog();
        euro = new javax.swing.JRadioButton();
        dolar = new javax.swing.JRadioButton();
        libra = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        currency_group = new javax.swing.ButtonGroup();
        languageformat = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        english = new javax.swing.JRadioButton();
        castellano = new javax.swing.JRadioButton();
        valencia = new javax.swing.JRadioButton();
        language_group = new javax.swing.ButtonGroup();
        dummiesactivate = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        dummieon = new javax.swing.JRadioButton();
        dummieoff = new javax.swing.JRadioButton();
        date = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        dateformat5 = new javax.swing.JRadioButton();
        dateformat6 = new javax.swing.JRadioButton();
        dateformat7 = new javax.swing.JRadioButton();
        dateformat8 = new javax.swing.JRadioButton();
        dummies_group = new javax.swing.ButtonGroup();
        conf_data = new javax.swing.JButton();
        conf_decimal = new javax.swing.JButton();
        conf_theme = new javax.swing.JButton();
        conf_format = new javax.swing.JButton();
        conf_currency = new javax.swing.JButton();
        conf_language = new javax.swing.JButton();
        conf_dummies = new javax.swing.JButton();
        return_main = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        date_group.add(dateformat1);
        dateformat1.setText("dd/MM/yyyy");

        date_group.add(dateformat2);
        dateformat2.setText("dd-MM-yyyy");

        date_group.add(dateformat3);
        dateformat3.setText("yyyy/MM/dd");

        date_group.add(dateformat4);
        dateformat4.setText("yyyy-MM-dd");

        jLabel1.setText("Elige un formato de fecha");

        javax.swing.GroupLayout dateformatLayout = new javax.swing.GroupLayout(dateformat.getContentPane());
        dateformat.getContentPane().setLayout(dateformatLayout);
        dateformatLayout.setHorizontalGroup(
            dateformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateformatLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(dateformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dateformat4)
                    .addComponent(dateformat3)
                    .addGroup(dateformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateformat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateformat2)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        dateformatLayout.setVerticalGroup(
            dateformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dateformatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat4)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        decimals_group.add(decimals1);
        decimals1.setText("0,1");

        decimals_group.add(decimals2);
        decimals2.setSelected(true);
        decimals2.setText("0,12");

        decimals_group.add(decimals3);
        decimals3.setText("0,123");

        jLabel4.setText("Elige una cantidad de decimales");

        javax.swing.GroupLayout decimalsformatLayout = new javax.swing.GroupLayout(decimalsformat.getContentPane());
        decimalsformat.getContentPane().setLayout(decimalsformatLayout);
        decimalsformatLayout.setHorizontalGroup(
            decimalsformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decimalsformatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(decimalsformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(decimals1)
                    .addComponent(jLabel4)
                    .addComponent(decimals2)
                    .addComponent(decimals3))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        decimalsformatLayout.setVerticalGroup(
            decimalsformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decimalsformatLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(decimals1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decimals2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decimals3)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        theme_group.add(metal);
        metal.setText("Metal");

        theme_group.add(windows);
        windows.setText("GTK - Windows");

        theme_group.add(motif);
        motif.setText("CDE/Motif");

        theme_group.add(nimbus);
        nimbus.setText("Nimbus");
        nimbus.setActionCommand("Nimbus");

        javax.swing.GroupLayout themeformatLayout = new javax.swing.GroupLayout(themeformat.getContentPane());
        themeformat.getContentPane().setLayout(themeformatLayout);
        themeformatLayout.setHorizontalGroup(
            themeformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(themeformatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(themeformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(metal)
                    .addComponent(windows)
                    .addComponent(motif)
                    .addComponent(nimbus))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        themeformatLayout.setVerticalGroup(
            themeformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(themeformatLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(metal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(windows)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(motif)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nimbus)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        formatfile_group.add(json);
        json.setText(".json");

        formatfile_group.add(txt);
        txt.setText(".txt");

        formatfile_group.add(xml);
        xml.setText(".xml");

        jLabel5.setText("Elige un formato de archivo");

        javax.swing.GroupLayout fileformatLayout = new javax.swing.GroupLayout(fileformat.getContentPane());
        fileformat.getContentPane().setLayout(fileformatLayout);
        fileformatLayout.setHorizontalGroup(
            fileformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileformatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fileformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(json)
                    .addComponent(txt)
                    .addComponent(xml)
                    .addComponent(jLabel5))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        fileformatLayout.setVerticalGroup(
            fileformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fileformatLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(json)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xml)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        currency_group.add(euro);
        euro.setText("euro");

        currency_group.add(dolar);
        dolar.setText("dolar");

        currency_group.add(libra);
        libra.setText("libras");

        jLabel6.setText("Elige una divisa");

        javax.swing.GroupLayout currencyformatLayout = new javax.swing.GroupLayout(currencyformat.getContentPane());
        currencyformat.getContentPane().setLayout(currencyformatLayout);
        currencyformatLayout.setHorizontalGroup(
            currencyformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currencyformatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(currencyformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(euro)
                    .addComponent(dolar)
                    .addComponent(libra)
                    .addComponent(jLabel6))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        currencyformatLayout.setVerticalGroup(
            currencyformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(currencyformatLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(euro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dolar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(libra)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        languageformat.setAlwaysOnTop(true);
        languageformat.setModal(true);

        jLabel7.setText("Elige un idioma");

        language_group.add(english);
        english.setText("English");

        language_group.add(castellano);
        castellano.setText("Castellano");

        language_group.add(valencia);
        valencia.setText("Valencià");

        javax.swing.GroupLayout languageformatLayout = new javax.swing.GroupLayout(languageformat.getContentPane());
        languageformat.getContentPane().setLayout(languageformatLayout);
        languageformatLayout.setHorizontalGroup(
            languageformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languageformatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(languageformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valencia)
                    .addComponent(castellano)
                    .addComponent(jLabel7)
                    .addComponent(english))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        languageformatLayout.setVerticalGroup(
            languageformatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(languageformatLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(english)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(castellano)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(valencia)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jLabel8.setText("Activar o desactivar los dummies");

        dummies_group.add(dummieon);
        dummieon.setText("Activar");

        dummies_group.add(dummieoff);
        dummieoff.setText("Desactivar");

        javax.swing.GroupLayout dummiesactivateLayout = new javax.swing.GroupLayout(dummiesactivate.getContentPane());
        dummiesactivate.getContentPane().setLayout(dummiesactivateLayout);
        dummiesactivateLayout.setHorizontalGroup(
            dummiesactivateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dummiesactivateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dummiesactivateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dummieoff)
                    .addComponent(dummieon)
                    .addComponent(jLabel8))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        dummiesactivateLayout.setVerticalGroup(
            dummiesactivateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dummiesactivateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(dummieon)
                .addGap(18, 18, 18)
                .addComponent(dummieoff)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel2.setText("Elige un formato de fecha");

        date_group.add(dateformat5);
        dateformat5.setSelected(true);
        dateformat5.setText("dd/MM/yyyy");

        date_group.add(dateformat6);
        dateformat6.setText("dd-MM-yyyy");

        date_group.add(dateformat7);
        dateformat7.setText("yyyy/MM/dd");

        date_group.add(dateformat8);
        dateformat8.setText("yyyy-MM-dd");

        javax.swing.GroupLayout dateLayout = new javax.swing.GroupLayout(date.getContentPane());
        date.getContentPane().setLayout(dateLayout);
        dateLayout.setHorizontalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dateformat8)
                    .addComponent(dateformat7)
                    .addGroup(dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dateformat5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateformat6)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        dateLayout.setVerticalGroup(
            dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateformat8)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        conf_data.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/calendar.png"))); // NOI18N
        conf_data.setText("Fecha");
        conf_data.setToolTipText("Modifica el formato de fecha");
        conf_data.setActionCommand("");
        conf_data.setBorder(null);
        conf_data.setContentAreaFilled(false);
        conf_data.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf_data.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conf_data.setIconTextGap(-1);
        conf_data.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        conf_decimal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/decimals.png"))); // NOI18N
        conf_decimal.setText("Decimales");
        conf_decimal.setToolTipText("Elige la cantidad de decimales");
        conf_decimal.setActionCommand("");
        conf_decimal.setBorder(null);
        conf_decimal.setContentAreaFilled(false);
        conf_decimal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf_decimal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conf_decimal.setIconTextGap(5);
        conf_decimal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        conf_theme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/theme.png"))); // NOI18N
        conf_theme.setText("Tema");
        conf_theme.setToolTipText("Cambia el tema de la aplicación");
        conf_theme.setActionCommand("");
        conf_theme.setBorder(null);
        conf_theme.setContentAreaFilled(false);
        conf_theme.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf_theme.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conf_theme.setIconTextGap(-1);
        conf_theme.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        conf_format.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/format.png"))); // NOI18N
        conf_format.setText("Formato");
        conf_format.setToolTipText("Elige el formato de archivo con el que quieres trabajar");
        conf_format.setActionCommand("");
        conf_format.setBorder(null);
        conf_format.setContentAreaFilled(false);
        conf_format.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf_format.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conf_format.setIconTextGap(-1);
        conf_format.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        conf_currency.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/currency.png"))); // NOI18N
        conf_currency.setText("Moneda");
        conf_currency.setToolTipText("Cambia la moneda con la que quieres trabajar");
        conf_currency.setActionCommand("");
        conf_currency.setBorder(null);
        conf_currency.setContentAreaFilled(false);
        conf_currency.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf_currency.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conf_currency.setIconTextGap(-1);
        conf_currency.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        conf_language.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/language.png"))); // NOI18N
        conf_language.setText("Idioma");
        conf_language.setToolTipText("Cambia el idioma de la aplicación");
        conf_language.setActionCommand("");
        conf_language.setBorder(null);
        conf_language.setContentAreaFilled(false);
        conf_language.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf_language.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conf_language.setIconTextGap(-1);
        conf_language.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        conf_dummies.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/menu/view/img/dummies.png"))); // NOI18N
        conf_dummies.setText("Dummies");
        conf_dummies.setToolTipText("Activa o desactiva el modo demo");
        conf_dummies.setActionCommand("");
        conf_dummies.setBorder(null);
        conf_dummies.setContentAreaFilled(false);
        conf_dummies.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        conf_dummies.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conf_dummies.setIconTextGap(-1);
        conf_dummies.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        return_main.setBackground(new java.awt.Color(255, 0, 153));
        return_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/modules/users/admin/view/img/return2.png"))); // NOI18N
        return_main.setToolTipText("Volver atrás");
        return_main.setBorder(null);
        return_main.setContentAreaFilled(false);
        return_main.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        return_main.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        return_main.setIconTextGap(-3);
        return_main.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(386, 386, 386)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(return_main)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(conf_data, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(conf_decimal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(conf_theme, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(conf_format, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(conf_currency, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(conf_language, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(conf_dummies, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(return_main)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(conf_format, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conf_data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conf_decimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conf_theme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(conf_language, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conf_dummies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conf_currency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JRadioButton castellano;
    public static javax.swing.JButton conf_currency;
    public static javax.swing.JButton conf_data;
    public static javax.swing.JButton conf_decimal;
    public static javax.swing.JButton conf_dummies;
    public static javax.swing.JButton conf_format;
    public static javax.swing.JButton conf_language;
    public static javax.swing.JButton conf_theme;
    private javax.swing.ButtonGroup currency_group;
    public static javax.swing.JDialog currencyformat;
    private javax.swing.JFrame date;
    private javax.swing.ButtonGroup date_group;
    public static javax.swing.JDialog dateformat;
    public static javax.swing.JRadioButton dateformat1;
    public static javax.swing.JRadioButton dateformat2;
    public static javax.swing.JRadioButton dateformat3;
    public static javax.swing.JRadioButton dateformat4;
    private javax.swing.JRadioButton dateformat5;
    private javax.swing.JRadioButton dateformat6;
    private javax.swing.JRadioButton dateformat7;
    private javax.swing.JRadioButton dateformat8;
    public static javax.swing.JRadioButton decimals1;
    public static javax.swing.JRadioButton decimals2;
    public static javax.swing.JRadioButton decimals3;
    private javax.swing.ButtonGroup decimals_group;
    public static javax.swing.JDialog decimalsformat;
    public static javax.swing.JRadioButton dolar;
    public static javax.swing.JRadioButton dummieoff;
    public static javax.swing.JRadioButton dummieon;
    private javax.swing.ButtonGroup dummies_group;
    public static javax.swing.JDialog dummiesactivate;
    public static javax.swing.JRadioButton english;
    public static javax.swing.JRadioButton euro;
    public static javax.swing.JDialog fileformat;
    private javax.swing.ButtonGroup formatfile_group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JRadioButton json;
    private javax.swing.ButtonGroup language_group;
    public static javax.swing.JDialog languageformat;
    public static javax.swing.JRadioButton libra;
    public static javax.swing.JRadioButton metal;
    public static javax.swing.JRadioButton motif;
    public static javax.swing.JRadioButton nimbus;
    public static javax.swing.JButton return_main;
    private javax.swing.ButtonGroup theme_group;
    public static javax.swing.JDialog themeformat;
    public static javax.swing.JRadioButton txt;
    public static javax.swing.JRadioButton valencia;
    public static javax.swing.JRadioButton windows;
    public static javax.swing.JRadioButton xml;
    // End of variables declaration//GEN-END:variables
}
