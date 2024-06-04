package org.example.hw2ServerChatInteface;

import org.example.hw2ServerChatInteface.client.ClientController;
import org.example.hw2ServerChatInteface.client.ClientGUI;
import org.example.hw2ServerChatInteface.server.ServerController;
import org.example.hw2ServerChatInteface.server.ServerGUI;
import org.example.hw2ServerChatInteface.server.ServerRepository;

public class Main {
    public static void main(String[] args) {
        ServerRepository serverRepository = new ServerRepository();
        ServerGUI serverGUI = new ServerGUI();
        ServerController serverController = new ServerController(serverGUI, serverRepository);

        ClientGUI clientGUI1 = new ClientGUI("пользователь 1");
        ClientController clientController1 = new ClientController(serverController, clientGUI1, "пользователь 1");

        ClientGUI clientGUI2 = new ClientGUI("пользователь 2");
        ClientController clientController2 = new ClientController(serverController, clientGUI2, "пользователь 2");

        System.out.println("close");
    }
}
