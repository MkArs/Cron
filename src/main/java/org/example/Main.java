package org.example;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final int PORT = 1234;
    private static final String HOST_NAME = "localhost";
    private static final String ENTER_COMMAND_STR = "Enter your command: ";
    private static final String EXIT_STR = "exit";

    public static void main(String[] args) {
        Socket clientSocket;

        try {
            clientSocket = new Socket(HOST_NAME, PORT);

            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            readUserInput(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readUserInput(PrintWriter output){
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.print(ENTER_COMMAND_STR);
            input = scanner.nextLine();
            output.println(input);
            if (input.equalsIgnoreCase(EXIT_STR)) {
                break;
            }
        }
        scanner.close();
    }
}