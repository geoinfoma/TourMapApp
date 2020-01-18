/**
 * @author geoinfomat
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainWindow extends javax.swing.JFrame {

    LoginApp.DB db;
    String queryString;
    int columns = 2;
    boolean isCheck = true;
    ArrayList<Trip> list = new ArrayList<Trip>();
    Trip a;
    ServiceImpl service = new ServiceImpl();

    public MainWindow() {
        initComponents();
        table.getTableHeader().setReorderingAllowed(false);
    }

    public void refresh() {
        int quantityOfLines = 0;
        try {
            queryString = "select ID, PlaceOfTrip, Latitude, Longitude, Description from Trip WHERE ID>="
                    + Integer.parseInt(fromID.getValue().toString()) + " and ID<"
                    + Integer.parseInt(toID.getValue().toString()) + "";

            ResultSet rs = db.statement.executeQuery(queryString);

            for (int i = 0; rs.next(); i++) {
                quantityOfLines++;
                a = new Trip();
                a.setId(Integer.parseInt(rs.getString("ID")));
                a.setPlaceOfTrip(rs.getString("PlaceOfTrip"));
                a.setLatitude(rs.getString("Latitude"));
                a.setLongitude(rs.getString("Longitude"));
                a.setDescription(rs.getString("Description"));
                list.add(a);
            }

            table.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[quantityOfLines][6],
                    new String[]{
                        "No", "Check", "ID", "Place Of Trip", "Latitude", "Longitude", "Description"
                    }
            ) {
                Class[] types = new Class[]{
                    java.lang.Object.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    true, true, false, true, true, true, true
                };

                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            for (int i = 0; i < quantityOfLines; i++) {

                table.getModel().setValueAt(i + 1, i, columns - 2);
                table.getModel().setValueAt(list.get(i).getId(), i, columns);
                table.getModel().setValueAt(list.get(i).getPlaceOfTrip(), i, columns + 1);
                table.getModel().setValueAt(list.get(i).getLatitude(), i, columns + 2);
                table.getModel().setValueAt(list.get(i).getLongitude(), i, columns + 3);
                table.getModel().setValueAt(list.get(i).getDescription(), i, columns + 4);

            }
            list.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertWindow = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        insertTable = new javax.swing.JTable();
        saveButon = new javax.swing.JButton();
        alertWrongData = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        logText = new javax.swing.JTextArea();
        jMenuItem6 = new javax.swing.JMenuItem();
        tablePopMenu = new javax.swing.JPopupMenu();
        refreshPop = new javax.swing.JMenuItem();
        insertDataPop = new javax.swing.JMenuItem();
        deletePop = new javax.swing.JMenuItem();
        editPop = new javax.swing.JMenuItem();
        slider = new javax.swing.JSlider();
        quantityID = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        refresh_buton = new javax.swing.JButton();
        insertData = new javax.swing.JButton();
        deleteButon = new javax.swing.JButton();
        editBoton = new javax.swing.JButton();
        fromID = new javax.swing.JSpinner();
        toID = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        showMap = new javax.swing.JButton();
        attractions = new java.awt.Button();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        refresh = new javax.swing.JMenuItem();
        insert_data = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenuItem();

        insertWindow.setSize(new java.awt.Dimension(400, 200));

        insertTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "PlaceOfTrip", "Latitude", "Longitude", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(insertTable);

        saveButon.setText("Save");
        saveButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout insertWindowLayout = new javax.swing.GroupLayout(insertWindow.getContentPane());
        insertWindow.getContentPane().setLayout(insertWindowLayout);
        insertWindowLayout.setHorizontalGroup(
            insertWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertWindowLayout.createSequentialGroup()
                .addGroup(insertWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(insertWindowLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(insertWindowLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(saveButon)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        insertWindowLayout.setVerticalGroup(
            insertWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(insertWindowLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(saveButon)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        alertWrongData.setMinimumSize(new java.awt.Dimension(450, 400));

        logText.setEditable(false);
        logText.setColumns(20);
        logText.setRows(5);
        logText.setMinimumSize(new java.awt.Dimension(400, 200));
        logText.setPreferredSize(new java.awt.Dimension(350, 150));
        jScrollPane3.setViewportView(logText);

        javax.swing.GroupLayout alertWrongDataLayout = new javax.swing.GroupLayout(alertWrongData.getContentPane());
        alertWrongData.getContentPane().setLayout(alertWrongDataLayout);
        alertWrongDataLayout.setHorizontalGroup(
            alertWrongDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, alertWrongDataLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        alertWrongDataLayout.setVerticalGroup(
            alertWrongDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(alertWrongDataLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jMenuItem6.setText("jMenuItem6");

        refreshPop.setText("Refresh");
        refreshPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshPopActionPerformed(evt);
            }
        });
        tablePopMenu.add(refreshPop);

        insertDataPop.setText("insert Data");
        insertDataPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertDataPopActionPerformed(evt);
            }
        });
        tablePopMenu.add(insertDataPop);

        deletePop.setText("Delete");
        deletePop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePopActionPerformed(evt);
            }
        });
        tablePopMenu.add(deletePop);

        editPop.setText("Edit");
        editPop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPopActionPerformed(evt);
            }
        });
        tablePopMenu.add(editPop);

        slider.setValue(0);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        quantityID.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20" }));
        quantityID.setSelectedIndex(3);
        quantityID.setToolTipText("");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 515));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 402));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Check", "ID", "Place Of Trip", "Latitude", "Longitude", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setComponentPopupMenu(tablePopMenu);
        table.setMinimumSize(new java.awt.Dimension(65, 64));
        table.setPreferredSize(new java.awt.Dimension(500, 200));
        table.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tableComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        refresh_buton.setText("Refresh");
        refresh_buton.setPreferredSize(new java.awt.Dimension(200, 30));
        refresh_buton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_butonActionPerformed(evt);
            }
        });

        insertData.setText("Insert data");
        insertData.setPreferredSize(new java.awt.Dimension(200, 30));
        insertData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertDataActionPerformed(evt);
            }
        });

        deleteButon.setText("Delete");
        deleteButon.setPreferredSize(new java.awt.Dimension(200, 30));
        deleteButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButonActionPerformed(evt);
            }
        });

        editBoton.setText("Edit");
        editBoton.setPreferredSize(new java.awt.Dimension(200, 30));
        editBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBotonActionPerformed(evt);
            }
        });

        fromID.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fromIDStateChanged(evt);
            }
        });

        jLabel1.setText("From  ID");

        jLabel2.setText("To ID");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setText("List of attractive tourist destinations in Lesser Poland");

        showMap.setText("Show on map");
        showMap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMapActionPerformed(evt);
            }
        });

        attractions.setLabel("Map of tourist attractions in Poland");
        attractions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attractionsActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        logout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jMenu1.add(exit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        refresh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jMenu2.add(refresh);

        insert_data.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        insert_data.setText("Insert");
        insert_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_dataActionPerformed(evt);
            }
        });
        jMenu2.add(insert_data);

        delete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jMenu2.add(delete);

        edit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jMenu2.add(edit);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fromID, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toID, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(228, 228, 228)
                                .addComponent(attractions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(refresh_buton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(insertData, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(deleteButon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(editBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(showMap, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fromID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(attractions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refresh_buton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showMap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh_butonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_butonActionPerformed
        this.refresh();
    }//GEN-LAST:event_refresh_butonActionPerformed

    private void saveButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButonActionPerformed
        isCheck = true;
        logText.append("Mistakes \n");

        if (insertTable.getModel().getValueAt(0, 0) == null) {
            isCheck = false;
            logText.append("The \"place of trip\" isn\'t written!\n");
        }
        if (insertTable.getModel().getValueAt(0, 1) == null) {
            isCheck = false;
            logText.append("The latitude isn\'t written!\n");
        }
        if (insertTable.getModel().getValueAt(0, 2) == null) {
            isCheck = false;
            logText.append("The longitude isn\'t written!\n");
        }
        if (insertTable.getModel().getValueAt(0, 3) == null) {
            isCheck = false;
            logText.append("The description isn\'t written!\n");
        }
        if (isCheck) {
            service.add(db, insertTable.getModel().getValueAt(0, 0).toString(), insertTable.getModel().getValueAt(0, 1).toString(), insertTable.getModel().getValueAt(0, 2).toString(), insertTable.getModel().getValueAt(0, 3).toString());

            this.setEnabled(true);
            insertWindow.dispose();
            this.refresh();

        } else {
            alertWrongData.setVisible(true);
            //insertData.setEnabled(false);
            this.setEnabled(false);
        }
    }//GEN-LAST:event_saveButonActionPerformed

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        fromID.setValue(slider.getValue());
    }//GEN-LAST:event_sliderStateChanged

    private void fromIDStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fromIDStateChanged

    }//GEN-LAST:event_fromIDStateChanged

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        LoginApp a;
        a = new LoginApp();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void insert_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_dataActionPerformed
        insertData.doClick();
    }//GEN-LAST:event_insert_dataActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        refresh_buton.doClick();
    }//GEN-LAST:event_refreshActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        editBoton.doClick();
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        deleteButon.doClick();
    }//GEN-LAST:event_deleteActionPerformed

    private void refreshPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshPopActionPerformed
        refresh_buton.doClick();
    }//GEN-LAST:event_refreshPopActionPerformed

    private void insertDataPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertDataPopActionPerformed
        insertData.doClick();
    }//GEN-LAST:event_insertDataPopActionPerformed

    private void deletePopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePopActionPerformed
        deleteButon.doClick();
    }//GEN-LAST:event_deletePopActionPerformed

    private void editPopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPopActionPerformed
        editBoton.doClick();
    }//GEN-LAST:event_editPopActionPerformed

    private void tableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tableComponentAdded
        if (table.isColumnSelected(columns + 1) || table.isColumnSelected(columns + 2) || table.isColumnSelected(columns + 3) || table.isColumnSelected(columns + 4)) {
            for (int i = 0; i < table.getRowCount(); i++) {
                if (table.getModel().getValueAt(1, columns) != null) {
                    if (table.isRowSelected(i)) {
                        table.getModel().setValueAt(true, i, columns - 1);
                    }
                }
            }
        }
    }//GEN-LAST:event_tableComponentAdded

    private void attractionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attractionsActionPerformed

        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getModel().getValueAt(i, 1) != null) {

                Object lat = table.getModel().getValueAt(i, 4);
                Object lng = table.getModel().getValueAt(i, 5);

                String www = "http://mapa.polskaniezwykla.pl/frame.aspx?lat=" + lat + "&lng=" + lng + "&zoom=13";
                try {
                    String URL = www;
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        this.refresh();

    }//GEN-LAST:event_attractionsActionPerformed

    private void showMapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMapActionPerformed

        for (int i = 0; i < table.getRowCount(); i++) {
            if (table.getModel().getValueAt(i, 1) != null) {

                Object lat = table.getModel().getValueAt(i, 4);
                Object lng = table.getModel().getValueAt(i, 5);

                String www = "http://www.google.com/maps/@" + lat + "," + lng + ",14z";
                try {
                    String URL = www;
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(URL));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        this.refresh();
    }//GEN-LAST:event_showMapActionPerformed

    private void editBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBotonActionPerformed
        for (int i = 0; i < table.getRowCount(); i++) {
            if ((table.getModel().getValueAt(i, columns - 1) != null) && (table.getModel().getValueAt(i, columns - 2) != null)) {
                service.edit(db, Integer.parseInt(table.getModel().getValueAt(i, columns).toString()), table.getModel().getValueAt(i, columns + 1).toString(), table.getModel().getValueAt(i, columns + 2).toString(), table.getModel().getValueAt(i, columns + 3).toString(), table.getModel().getValueAt(i, columns + 4).toString());
            }
            table.getModel().setValueAt(false, i, 0);
        }
        this.refresh();
    }//GEN-LAST:event_editBotonActionPerformed

    private void deleteButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButonActionPerformed
        String catchMe = "";
        int countTrue = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            if ((table.getModel().getValueAt(i, columns - 1) != null) && (table.getModel().getValueAt(i, columns) != null)) {
                if (table.getModel().getValueAt(i, columns - 1).toString() == "true") {
                    countTrue++;
                    if (countTrue == 1) {
                        catchMe = table.getModel().getValueAt(i, columns).toString();
                    } else {
                        catchMe = catchMe + " or ID=" + table.getModel().getValueAt(i, columns).toString();
                    }
                }
            }
            table.getModel().setValueAt(false, i, columns - 1);

        }

        for (int i = 0; i < table.getRowCount(); i++) {
            table.getModel().setValueAt(null, i, columns);
            table.getModel().setValueAt(null, i, columns + 1);
            table.getModel().setValueAt(null, i, columns + 2);
            table.getModel().setValueAt(null, i, columns + 3);
            table.getModel().setValueAt(null, i, columns + 4);
        }

        if (countTrue > 0) {
            service.delete(db, catchMe);
            this.refresh();
        }
    }//GEN-LAST:event_deleteButonActionPerformed

    private void insertDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertDataActionPerformed
        insertWindow.setVisible(true);
        // this.setEnabled(false);
        insertTable.getModel().setValueAt(null, 0, 0);
        insertTable.getModel().setValueAt(null, 0, 1);
        insertTable.getModel().setValueAt(null, 0, 2);
        insertTable.getModel().setValueAt(null, 0, 3);
    }//GEN-LAST:event_insertDataActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame alertWrongData;
    private java.awt.Button attractions;
    private javax.swing.JMenuItem delete;
    private javax.swing.JButton deleteButon;
    private javax.swing.JMenuItem deletePop;
    private javax.swing.JMenuItem edit;
    private javax.swing.JButton editBoton;
    private javax.swing.JMenuItem editPop;
    private javax.swing.JMenuItem exit;
    private javax.swing.JSpinner fromID;
    private javax.swing.JButton insertData;
    private javax.swing.JMenuItem insertDataPop;
    private javax.swing.JTable insertTable;
    private javax.swing.JFrame insertWindow;
    private javax.swing.JMenuItem insert_data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextArea logText;
    private javax.swing.JMenuItem logout;
    private javax.swing.JComboBox quantityID;
    private javax.swing.JMenuItem refresh;
    private javax.swing.JMenuItem refreshPop;
    private javax.swing.JButton refresh_buton;
    private javax.swing.JButton saveButon;
    private javax.swing.JButton showMap;
    private javax.swing.JSlider slider;
    private javax.swing.JTable table;
    private javax.swing.JPopupMenu tablePopMenu;
    private javax.swing.JSpinner toID;
    // End of variables declaration//GEN-END:variables
}
