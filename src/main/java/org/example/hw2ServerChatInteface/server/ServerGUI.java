package org.example.hw2ServerChatInteface.server;

import javax.swing.*;
import java.awt.*;

public class ServerGUI extends JFrame implements ServerView {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Запуск");
    private final JButton btnStop = new JButton("Остановить");
    private final JTextArea log = new JTextArea();
    private ServerController serverController;

    public ServerGUI() {
        btnStop.setEnabled(false);

        btnStop.addActionListener(listener -> serverController.stop());
        btnStart.addActionListener(listener -> serverController.start());

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Чат");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(btnStart);
        topPanel.add(btnStop);
        add(topPanel, BorderLayout.NORTH);

        log.setEditable(true);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void answer(String message) {
        log.append(message + "\n");
    }

    @Override
    public void setController(ServerController controller) {
        this.serverController = controller;
    }

    @Override
    public void enableStopButton(boolean enable) {
        btnStop.setEnabled(enable);
    }
}
