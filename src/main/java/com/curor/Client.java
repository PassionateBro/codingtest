package com.curor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @describtion:
 * @author: CaiJm
 * @Date: 2023-03-20 17:26
 */
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
