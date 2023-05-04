package com.curor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-20 17:26
 */
public class Server {
    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started. Listening to the port 5000");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected: " + socket.getInetAddress().getHostName());

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        String message = "";
        while (!message.equals("exit")) {
            message = input.readLine();
            System.out.println("Client: " + message);
            output.println("Server received: " + message);
        }

        System.out.println("Closing connection");
        socket.close();
        serverSocket.close();
    }
}
