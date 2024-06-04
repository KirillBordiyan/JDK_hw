package org.example.hw2ServerChatInteface.server;

import org.example.hw2ServerChatInteface.client.ClientController;
import org.example.hw2ServerChatInteface.client.ClientInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerRepository implements ServerRepositoryInterface {
    private final List<ClientInterface> connectedClients = new ArrayList<>();


    @Override
    public void logR(String message) {
        saveLogToFile(message);
    }

    @Override
    public void addClientR(ClientInterface client) {
        connectedClients.add(client);
    }

    @Override
    public void removeClientR(ClientInterface client) {
        connectedClients.remove(client);
    }

    @Override
    public void saveLogToFile(String message) {
        String path = "src/main/java/org/example/hw2ServerChatInteface/log.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(message);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл лога: " + e.getMessage());
        }
    }

    @Override
    public List<ClientInterface> getConnectedClients() {
        return new ArrayList<>(connectedClients);
    }
}
