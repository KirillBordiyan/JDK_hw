package org.example.hw2ServerChatInteface.client;

public interface ClientInterface {
    void connect();
    void sendMessage(String message);
    void receiveMessage(String message);
    void disconnect();
}
