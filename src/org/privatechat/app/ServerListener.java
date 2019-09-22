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
    private boolean kill;
    private int port;

    ServerListener(int port, JTextArea textArea) {
        this.port = port;
        this.kill = false;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        try {
            //textArea.append("Exchanging Keys...\n");
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            sock = serverSocket.accept();
            dataInputStream = new DataInputStream(sock.getInputStream());
            dataOutputStream = new DataOutputStream(sock.getOutputStream());
           // dataOutputStream = new

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
               // textArea.append("works");
                String out = dataInputStream.readUTF();
                textArea.append(out);
                if(out.equals("Exit") || kill) {
                    sock.close();
                    break;
                }
            } catch (IOException e) {
                break;
            }
        }
    }
    public void OutputStrem(String mssg, String name){
        if(mssg != null){
            try {
                dataOutputStream.writeUTF(name+" : "+mssg);
                if(mssg.equals("Exit")){
                    sock.close();
                    System.exit(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void kill() {
        kill = true;
    }
}
