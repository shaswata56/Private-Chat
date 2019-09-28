package org.privatechat.app;

import org.privatechat.security.RSA;
import org.privatechat.security.RSAKeyGen;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

public class ClientStation extends Thread{
    private Socket client;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private String ip;
    private boolean connected = false;
    private boolean kill = false;
    private boolean connection = false;
    private boolean exchanged = false;
    private int port, killCount = 0;
    private JTextArea textArea;
    private PublicKey publicKey;
    private RSAKeyGen keyGen;
    private RSA rsaUtil;

    ClientStation(String ip, int port, JTextArea textArea){
        this.ip = ip;
        this.port = port;
        this.textArea = textArea;
    }
    @Override
    public void run(){
        try {
            while(!kill) {
                try {
                    keyGen = new RSAKeyGen();
                    client = new Socket(ip, port);
                    if(client.isConnected()) break;
                }catch (IOException ignored) {
                }
            }
            if (!kill) {
                connected = true;
                rsaUtil = new RSA(keyGen);
                dataOutputStream = new DataOutputStream(client.getOutputStream());
                dataInputStream = new DataInputStream(client.getInputStream());
            }
            while (!kill) {
                try {
                    String[] word;
                    if(exchanged)
                    {
                        String out = rsaUtil.decrypt(dataInputStream.readUTF());
                        textArea.append(out);
                        word = out.split(":");
                    } else {
                        byte[] out = Base64.getEncoder().encode(rsaUtil.getPublicKey().getEncoded());
                        dataOutputStream.write(out);
                        dataInputStream.readFully(out);
                        publicKey = rsaUtil.decodePublicKey(Base64.getDecoder().decode(out));
                        textArea.append(Base64.getEncoder().encodeToString(publicKey.getEncoded()) + "\n");
                        textArea.append("Key Exchanged!\nAll communication is currently encrypted by RSA 2048 bit Public Key!\n");
                        word = Arrays.toString(out).split(":");
                        exchanged = true;
                    }
                    if(word.length == 2)
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
            textArea.append("Connection Terminated\nSet Again!\n");
        if(killCount == 1 && flag)
            textArea.append("Connection Reestablishing\n");
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
