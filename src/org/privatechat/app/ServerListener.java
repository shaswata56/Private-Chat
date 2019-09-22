package org.privatechat.app;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerListener extends Thread {

    private ServerSocket serverSocket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private JTextArea textArea;
    private Socket sock;
    private boolean kill = false, connected = false, connection = false;
    private int port, killcount = 0;

    ServerListener(int port, JTextArea textArea) {
        this.port = port;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            //textArea.append("Exchanging Keys...\n");
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(100000);
            sock = serverSocket.accept();
            if(!kill) {
                connected = true;
                dataInputStream = new DataInputStream(sock.getInputStream());
                dataOutputStream = new DataOutputStream(sock.getOutputStream());
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
                }
            }
        } catch (IOException ignored) {
            kill(false);
        }
    }

    void OutputStream(String msg, String name){
        if(connected){
            try {
                dataOutputStream.writeUTF(name+": "+msg);
                if(msg.equalsIgnoreCase("Exit") || serverSocket.isClosed())
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
            if(!serverSocket.isClosed())
                serverSocket.close();
            if(sock != null)
                sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    boolean checkMsg(){
        return connection;
    }
}
