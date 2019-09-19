package org.privatechat.app;

import org.privatechat.security.RSA;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Private_Chat extends JFrame {


    private Private_Chat() throws UnknownHostException {
        initComponents();
    }

    private String ip, name, port, msg;
    private static Private_Chat app;

    private void initComponents() throws UnknownHostException {

        JPanel jPanel3 = new JPanel();
        JLabel jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        JLabel jLabel2 = new JLabel();
        jTextField2 = new JTextField();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jTextField3 = new JTextField();
        JButton jButton1 = new JButton();
        JLabel jLabel3 = new JLabel();
        jTextField4 = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new Color(104, 107, 109));

        jLabel1.setText("IP");

        String[] host = String.valueOf(InetAddress.getLocalHost()).split("/");
        jTextField1.setText(host[1]);
        jTextField1.addActionListener(this::jTextField1ActionPerformed);

        jLabel2.setText("Port");

        jTextField2.setText("1234");
        jTextField2.addActionListener(this::jTextField2ActionPerformed);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Monospaced", Font.PLAIN, 14));
        jTextArea1.setForeground(new Color(74, 246, 38));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField3.setBackground(new Color(0, 0, 0));
        jTextField3.setFont(new Font("Tahoma", Font.PLAIN, 14)); // NOI18N
        jTextField3.setForeground(new Color(74, 246, 38));
        jTextField3.setText("");
        jTextField3.addActionListener(this::jTextField3ActionPerformed);

        jButton1.setBackground(new Color(104, 107, 109));
        jButton1.setText("Send");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jLabel3.setText("Name");

        jTextField4.setText("anonymous");
        jTextField4.addActionListener(this::jTextField4ActionPerformed);

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(11, 11, 11)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
                                                .addGap(62, 62, 62)
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3))
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        app.ip = app.jTextField1.getText();
    }
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        app.port = app.jTextField2.getText();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        msg = jTextField3.getText();
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        msg = jTextField3.getText();
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        app.name = app.jTextField4.getText();
    }


    public static void main(String[] args) throws IOException {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Private_Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        app = new Private_Chat();
        app.setResizable(false);
        app.ip = "localhost";
        app.port = app.jTextField2.getText();
        app.msg = app.jTextField3.getText();
        app.name = app.jTextField4.getText().trim();
        RSA.generateKeys();

        EventQueue.invokeLater(() -> app.setVisible(true));

        InetAddress ip = InetAddress.getByName("192.168.31.56");
        Socket socket = new Socket(ip, Integer.parseInt(app.port));

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        AtomicBoolean attached = new AtomicBoolean(false);
        Thread Sender  = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if(!"".equals(app.msg.trim()) && attached.get()) {
                        app.msg = app.name.trim()+ ": " +app.msg.trim()+ "\n";
                        try {
                            dataOutputStream.writeUTF(Objects.requireNonNull(RSA.encrypt(app.msg, app.publicKey)));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(!attached.get()) {
                        try {
                            dataOutputStream.writeUTF(
                                    Base64.getEncoder().encodeToString(
                                            RSA.getPublicKey().getEncoded()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    super.notify();
                    try {
                        super.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread Listener = new Thread(new Runnable() {
            Boolean keyReceived = false;
            @Override
            public void run() {
                while (true) {
                    try {
                        if(!attached.get() && keyReceived) {
                            dataOutputStream.writeByte(0x80);
                            byte b = dataInputStream.readByte();
                            if(b == (byte) 0x80)
                                attached.set(true);
                        } else app.jTextArea1.append(RSA.decrypt(dataInputStream.readUTF()));
                        if(!keyReceived) {
                            app.publicKey = RSA.decodePublicKey(dataInputStream.readUTF());
                            app.jTextArea1.append("Public Key Received!!!\n");
                        }
                    } catch (GeneralSecurityException | IOException e) {
                        e.printStackTrace();
                    }
                    super.notify();
                    try {
                        super.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Sender.start();
        Listener.start();
    }

    private JTextArea jTextArea1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private PublicKey publicKey;
}