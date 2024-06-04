package org.example.hw2ServerChatInteface.server;

import org.example.hw2ServerChatInteface.client.ClientController;
import org.example.hw2ServerChatInteface.client.ClientInterface;

import java.util.List;

public interface ServerRepositoryInterface {
    void logR(String message);

    void addClientR(ClientInterface client);

    void removeClientR(ClientInterface client);

    void saveLogToFile(String message);

    List<ClientInterface> getConnectedClients();
}

