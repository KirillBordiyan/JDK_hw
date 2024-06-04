package org.example.hw1ServerChat;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServerWindow extends JFrame {

    public static final int POS_X = 500;
    public static final int POS_Y = 550;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    //    private final JButton btnStart = new JButton("Start");
    private JButton btnStart, btnStop;
    private JTextArea log;

    public static final String LOG_PATH = "src/main/java/org/example/log.txt";

    ArrayList<ClientGUI> clientGUIList;

    boolean isServerWork;


    public ServerWindow() {
        clientGUIList = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }


    private void appendLog(String text) {
        log.append(text + "\n");
    }

    public boolean connectUser(ClientGUI clientGUI){
        if (!isServerWork){
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    public void disconnetUser(ClientGUI clientGUI) {
        clientGUIList.remove(clientGUI);
        if(clientGUI != null){
            clientGUI.disconnectFromServer();
        }
    }

    public void message(String text){
        if (!isServerWork){
            return;
        }
        text += "";
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text){
        for (ClientGUI clientGUI: clientGUIList){
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public String getLog() {
        return readLog();
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try(FileReader reader = new FileReader(LOG_PATH)){
            int symbol;

            while((symbol = reader.read()) != -1){
                stringBuilder.append((char) symbol);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(listener -> {
            if (isServerWork) {
                appendLog("Сервер уже был запущен");
            } else {
                isServerWork = true;
                appendLog("Сервер запущен");
            }
        });

        btnStop.addActionListener(listener -> {
            if (!isServerWork) {
                appendLog("Сервер уже остановлен");
            } else {
                isServerWork = false;
                while (!clientGUIList.isEmpty()) {
                    disconnetUser(clientGUIList.get(clientGUIList.size() - 1));
                }
                appendLog("Сервер остановлен");
            }

        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }










}
