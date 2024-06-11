package org.example.hw6mvn;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, Boolean> stats = new HashMap<>();
        Random rnd = new Random();
        int winDoor, playerPickDoor;
        int tryCount = 1000;

        for (int i = 1; i <= tryCount; i++) {
            winDoor = rnd.nextInt(3) + 1;
            playerPickDoor = rnd.nextInt(3) + 1;
            int openDoor;
            do {
                openDoor = rnd.nextInt(3) + 1;
            } while (openDoor == winDoor || openDoor == playerPickDoor);


            for (int j = 1; j <= 3; j++) {
                if (j != playerPickDoor && j != openDoor) {
                    playerPickDoor = j;
                    break;
                }
            }

            boolean win = (playerPickDoor == winDoor);
            stats.put(i, win);
        }

        int winAll = stats.values().stream().filter(result -> result).toList().size();
        int loseAll = stats.values().stream().filter(result -> !result).toList().size();

        System.out.println("Побед: " + winAll);
        System.out.println("Поражений: " + loseAll);


        //если хотим поменять или никогда не меняем - 1/2
        //если всегда меняем - 2/3
    }
}
