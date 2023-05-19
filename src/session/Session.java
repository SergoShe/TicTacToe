package session;

import session.gameplay.Gameplay;
import session.initializer.Initializer;
import session.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Session {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Initializer init = new Initializer();
    Score score = new Score();
    Player firstPlayer;
    Player secondPlayer;
    Gameplay gameplay;

    public void startSession() throws IOException {
        initPlayers();
        gameplay = new Gameplay(firstPlayer, secondPlayer);
        boolean isEndSession = false;
        while (!isEndSession) {
            score.incrementScore(gameplay.startGame());
            score.showScore();
            isEndSession = selectAfterGame();
        }
    }

    private void initPlayers() {
        init.initialize();
        firstPlayer = init.getFirstPlayer();
        secondPlayer = init.getSecondPlayer();
    }

    private boolean selectAfterGame() throws IOException {
        boolean isEnd = false;
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("Make a choice:");
            System.out.println("1.Continue game\n0.Exit");
            try {
                GameMode mode = GameMode.valueOf(Integer.parseInt(reader.readLine()));
                switch (mode) {
                    case CONTINUE -> {
                        if (score.getTotal() % 2 == 0) {
                            gameplay = new Gameplay(firstPlayer, secondPlayer);
                        } else {
                            gameplay = new Gameplay(secondPlayer, firstPlayer);
                        }
                        isContinue = false;
                    }
                    case EXIT -> {
                        isEnd = true;
                        isContinue = false;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Enter incorrect command. Try again");
            }
        }
        return isEnd;
    }
}