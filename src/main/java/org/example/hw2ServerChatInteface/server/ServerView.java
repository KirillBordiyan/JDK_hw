package org.example.hw2ServerChatInteface.server;

public interface ServerView {
    void answer(String message);
    void setController(ServerController controller);
    void enableStopButton(boolean enable);

}
