package org.privatechat.app;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSide extends Thread{
    private Socket client;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private String ip;
    private boolean connected = false, kill = false, connection = false;
    private int port, killcount = 0;
    private JTextArea textArea;

    ClientSide(String ip, int port, JTextArea textArea){
        this.ip = ip;
        this.port = port;
        this.textArea = textArea;
    }
    @Override
    public void run(){
        try {
            while(!kill) {
                try {
                    client = new Socket(ip, port);
                    if(client.isConnected()) break;
                }catch (IOException ignored) {
                }
            }
            if (!kill) {
                connected = true;
                dataOutputStream = new DataOutputStream(client.getOutputStream());
                dataInputStream = new DataInputStream(client.getInputStream());
            }
            while (!kill) {
                try {
                    String out = dataInputStream.readUTF();
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
                dataOutputStream.writeUTF(name+": "+msg);
                if (msg.equalsIgnoreCase("Exit"))
                    kill(false);
            } catch (IOException e) {
                kill(false);
            }
        }
    }
    void kill(boolean flag) {
        killcount++;
        connection = true;
        kill = true;
        if(killcount == 1 && !flag)
            textArea.append("Connection Lost\nSet Again!\n");
        if(killcount == 1 && flag)
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
