package com.curor;

import java.io.IOException;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-20 17:27
 */
public class Test {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client();

        Thread serverThread = new Thread(() -> {
            try {
                server.startServer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Thread clientThread = new Thread(() -> {
            try {
                client.startClient();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        serverThread.start();
        clientThread.start();
    }
}
