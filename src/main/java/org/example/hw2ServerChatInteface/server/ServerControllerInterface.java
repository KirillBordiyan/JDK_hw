package org.example.hw2ServerChatInteface.server;

import org.example.hw2ServerChatInteface.client.ClientInterface;

public interface ServerControllerInterface {
    void start();
    void stop();
    void log(String message);
    boolean isRunning();
    boolean isStopped();
    void addClient(ClientInterface client);
    void removeClient(ClientInterface client);
    void cast(String message, ClientInterface client);
}
