package org.example.hw2ServerChatInteface.client;

import org.example.hw2ServerChatInteface.server.ServerController;

public class ClientController implements ClientInterface {

    private final ServerController serverController;
    private final ClientView clientView;
    private boolean isConnected;
    private final String clientName;


    public ClientController(ServerController serverController, ClientView clientView, String clientName) {
        this.serverController = serverController;
        this.clientView = clientView;
        this.clientName = clientName;
        this.clientView.setController(this);
        this.isConnected = false;
    }

    @Override
    public void connect() {
        if (isConnected) {
            clientView.answer("Уже подключены\n");
            return;
        }
        if (serverController.isRunning()) {
            clientView.answer("Вы успешно подключились\n");
            serverController.log(clientName + " подключился");
            serverController.addClient(this);
            isConnected = true;
        } else {
            clientView.answer("Безуспешное подключение");
        }
    }

    @Override
    public void sendMessage(String message) {
        if (isConnected && !serverController.isStopped()) {
            StringBuilder fullMessage = new StringBuilder(clientName + ":" + message);
            clientView.answer(fullMessage + "\n");
            serverController.cast(fullMessage.toString(), this);

        }
    }

    @Override
    public void receiveMessage(String message) {
        clientView.answer(message + "\n");
    }

    @Override
    public void disconnect() {
        if (!isConnected) {
            clientView.answer("Уже отключены");
            return;
        }
        serverController.removeClient(this);
        isConnected = false;
        clientView.answer("Вы отключены");
        serverController.log(clientName + " отключился");
    }
}
