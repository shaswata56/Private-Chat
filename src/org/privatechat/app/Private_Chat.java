package org.privatechat.app;

import javax.swing.*;

public class Private_Chat extends javax.swing.JFrame {

    private Private_Chat(String title) {
        this.setTitle(title);
        initComponents();
    }

    private void initComponents() {

        JPanel jPanel1 = new JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        JLabel jLabel1 = new JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        server = true; isSet = false;
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        JLabel jLabel3 = new JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextArea1 = new javax.swing.JTextArea();
        JScrollPane jScrollPane1 = new JScrollPane();

        jTextField4 = new javax.swing.JTextField();
        JButton jButton1 = new JButton();
        Box.Filler filler1 = new Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        JButton jButton2 = new JButton();
        Box.Filler filler2 = new Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(9999, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Server");
        jRadioButton1.addActionListener(this::jRadioButton1ActionPerformed);

        jRadioButton2.setText("Client");
        jRadioButton2.addActionListener(this::jRadioButton2ActionPerformed);

        jLabel1.setText("Name");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel2.setText("IP");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Port");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addActionListener(this::jTextField3ActionPerformed);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addActionListener(this::jTextField4ActionPerformed);

        jButton1.setText("Send");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Set");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jRadioButton2)
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addGap(4, 4, 4)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(filler2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3)
                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel3)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jRadioButton2)
                                                                .addComponent(jRadioButton1)
                                                                .addComponent(jButton2))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(15, 15, 15)))
                                                .addGap(7, 7, 7))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        name = jTextField1.getText().trim();
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabel2.setVisible(true);
        jTextField2.setVisible(true);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
        server = false;
    }

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        jLabel2.setVisible(false);
        jTextField2.setVisible(false);
        jRadioButton2.setSelected(false);
        jRadioButton1.setSelected(true);
        server = true;
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        msg = jTextField4.getText().trim();
        jTextField4.setText("");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        msg = jTextField4.getText().trim();
        jTextField4.setText("");
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        if(jTextField3.getText().trim().equals("")) {
            port = "1234";
            jTextField3.setText(port);
        } else {
            port = jTextField3.getText().trim();
        }
    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        ip = jTextField2.getText().trim();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        name = jTextField1.getText().trim();
        ip = jTextField2.getText().trim();
        if (jTextField3.getText().trim().equals("")) {
            port = "1234";
            jTextField3.setText(port);
        } else {
            port = jTextField3.getText().trim();
        }
        server = jRadioButton1.isSelected();
        isSet = true;
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Private_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        Private_Chat app = new Private_Chat("Private Chat");
        app.setVisible(true);
        app.setResizable(false);
        app.jLabel2.setVisible(false);
        app.jTextField2.setVisible(false);
        app.jTextField2.setVisible(false);

        while(true) {
            if(app.isSet) {
                if(app.server) {
                    ServerListener serverListener = new ServerListener(Integer.parseInt(app.port), app.jTextArea1);
                    serverListener.start();
                    app.jTextArea1.append("Server Started\n");
                    app.isSet = false;
                    while (true) {
                        if (app.isSet) {
                            serverListener.kill();
                            break;
                        }
                        if (!app.msg.equals("")) {
                            //app.msg += '\n';
                            serverListener.OutputStrem(app.msg, app.name);
                            app.jTextArea1.append(app.msg);
                            app.msg = "";
                        }
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else{
                    ClientSide clientSide = new ClientSide(app.ip, Integer.parseInt(app.port), app.jTextArea1);
                    clientSide.start();
                    app.jTextArea1.append("Client Started\n");
                    app.isSet = false;
                    while (true) {
                        if (app.isSet) {
                            clientSide.kill();
                            break;
                        }
                        if (!app.msg.equals("")) {
                            //app.msg += '\n';
                            clientSide.OutputStream(app.msg, app.name);
                            app.jTextArea1.append(app.msg);
                            app.msg = "";
                        }
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private javax.swing.JLabel jLabel2;
    private String ip, name, port;
    private String msg = "";
    private boolean server, isSet;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
}
