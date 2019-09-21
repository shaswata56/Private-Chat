package org.privatechat.app;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerListener extends Thread {

    private ServerSocket serverSocket;
    private DataInputStream dataInputStream;
    private JTextArea textArea;
    private Socket sock;
    private boolean kill;

    ServerListener(int port, JTextArea textArea) {
        try {
            kill = false;
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            sock = serverSocket.accept();
            this.textArea = textArea;
            textArea.append("Exchanging Keys...\n");
            dataInputStream = new DataInputStream(sock.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                textArea.append("works");
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

    public void kill() {
        kill = true;
    }
}
