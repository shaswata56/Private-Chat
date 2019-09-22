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
    private boolean kill = false, connected = false;
    private int port;

    ServerListener(int port, JTextArea textArea) {
        this.port = port;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            textArea.append("Exchanging Keys...\n");
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
                    if(out.equals("Exit") || !sock.isConnected())
                        kill();
                } catch (IOException e) {
                    kill();
                }
            }
        } catch (IOException ignored) {
        }
    }

    void OutputStrem(String msg, String name){
        if(connected){
            try {
                dataOutputStream.writeUTF(msg);
                if(msg.equals("Exit"))
                    kill();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void kill() {
        kill = true;
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
}
