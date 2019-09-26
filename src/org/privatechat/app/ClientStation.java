package org.privatechat.app;

import org.privatechat.security.RSA;
import org.privatechat.security.RSAKeyGen;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Base64;

public class ClientStation extends Thread{
    private Socket client;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private String ip;
    private boolean connected = false, kill = false, connection = false, exchanged = false, get = false;
    private int port, killCount = 0;
    private JTextArea textArea;
    private PublicKey publicKey;
    private RSA rsaUtil;

    ClientStation(String ip, int port, JTextArea textArea){
        this.ip = ip;
        this.port = port;
        this.textArea = textArea;
        rsaUtil = new RSA();
    }
    @Override
    public void run(){
        try {
            while(!kill) {
                try {
                    RSAKeyGen keyGen = new RSAKeyGen();
                    keyGen.generate();
                    client = new Socket(ip, port);
                    if(client.isConnected()) break;
                }catch (IOException ignored) {
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            }
            if (!kill) {
                connected = true;
                dataOutputStream = new DataOutputStream(client.getOutputStream());
                dataInputStream = new DataInputStream(client.getInputStream());
            }
            textArea.append("Exchanging Keys");
            if (!exchanged) {
                try {
                    if(!get) {
                        dataOutputStream.write(Base64.getEncoder().encode(rsaUtil.getPublicKey().getEncoded()));
                        String key = dataInputStream.readUTF();
                        publicKey = rsaUtil.decodePublicKey(Base64.getDecoder().decode(key));
                        get = true;
                        textArea.append("\tdone");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GeneralSecurityException e) {
                    System.out.println("Some problem with receiving keys!");
                }
            }
            textArea.append("\t\t\t\t done\n");
            while (!kill) {
                try {
                    String out = rsaUtil.decrypt(dataInputStream.readUTF());
                    textArea.append(out);
                    String[] word = out.split(":");
                    if(word[1].trim().equalsIgnoreCase("Exit"))
                        kill(false);
                } catch (IOException e) {
                    kill(false);
                    break;
                }
            }

        } catch (IOException ignored) {
            kill(false);
        }
    }

    void OutputStream(String msg, String name) {
        if(connected){
            try {
                dataOutputStream.writeUTF(rsaUtil.encrypt(name+": "+msg, publicKey));
                if (msg.equalsIgnoreCase("Exit"))
                    kill(false);
            } catch (IOException e) {
                kill(false);
            }
        }
    }
    void kill(boolean flag) {
        killCount++;
        connection = true;
        kill = true;
        if(killCount == 1 && !flag)
            textArea.append("Connection Lost\nSet Again!\n");
        if(killCount == 1 && flag)
            textArea.append("Resetting\n");
        try {
            if(dataOutputStream != null)
                dataOutputStream.close();
            if(dataInputStream != null)
                dataInputStream.close();
            if(client != null)
                client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    boolean checkMsg(){
        return connection;
    }
}
