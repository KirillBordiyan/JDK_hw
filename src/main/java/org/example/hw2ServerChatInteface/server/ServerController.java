package org.example.hw2ServerChatInteface.server;

import org.example.hw2ServerChatInteface.client.ClientController;
import org.example.hw2ServerChatInteface.client.ClientInterface;

public class ServerController implements ServerControllerInterface {

    private final ServerView serverView;
    private final ServerRepository serverRepository;
    private boolean isServerWorking;
    private boolean isServerStopped;

    public ServerController(ServerView serverView, ServerRepository repository) {
        this.serverView = serverView;
        this.serverRepository = repository;
        this.serverView.setController(this);
        this.isServerStopped = false;
        this.isServerWorking = false;
    }

    @Override
    public void start() {
        if (isRunning()) {
            serverView.answer("Сервер уже запущен");
        } else {
            isServerWorking = true;
            isServerStopped = false;
            serverView.answer("Сервер запущен");
            serverView.enableStopButton(true);
        }
    }

    @Override
    public void stop() {
        if (isServerStopped) {
            serverView.answer("Сервер уже остановлен\n");
        } else {
            isServerStopped = true;
            isServerWorking = false;
            for (ClientInterface client : serverRepository.getConnectedClients()) {
                client.disconnect();
            }
            serverView.answer("Сервер остановлен. Все клиенты отключены\n");
            serverRepository.logR("Сервер остановлен. Все клиенты отключены");
        }
    }

    @Override
    public void log(String message) {
        serverView.answer(message + "\n");
        serverRepository.saveLogToFile(message);
    }

    @Override
    public boolean isRunning() {
        return isServerWorking;
    }

    @Override
    public boolean isStopped() {
        return isServerStopped;
    }

    @Override
    public void addClient(ClientInterface client) {
        serverRepository.addClientR(client);
    }

    @Override
    public void removeClient(ClientInterface client) {
        serverRepository.removeClientR(client);
    }

    @Override
    public void cast(String message, ClientInterface client) {
        serverView.answer(message + "\n");
        for (ClientInterface current : serverRepository.getConnectedClients()) {
            if (current != client) {
                current.receiveMessage(message);
            }
        }
        serverRepository.saveLogToFile(message);
    }
}
