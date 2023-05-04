package com.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-16 10:17
 */
public class TestNotify {
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

    public class Client {
        public void startClient() throws IOException {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to the server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            String message = "";
            while (!message.equals("exit")) {
                System.out.print("Enter message: ");
                message = keyboard.readLine();
                output.println(message);
                System.out.println(input.readLine());
            }

            System.out.println("Closing connection");
            socket.close();
        }
    }

    public static void main(String[] args) {
    }
}
