package session.initializer;

import session.player.AIBot;
import session.player.Human;
import session.player.Player;
import session.player.bot.AIEasy;
import session.player.bot.AIHard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayersInitializer {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Player firstPlayer;
    Player secondPlayer;

    public Player getFirstPlayer() {
        return firstPlayer;
    }

    public Player getSecondPlayer() {
        return secondPlayer;
    }

    public void initialize() {
        firstPlayer = new Human("Player 1");
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Choose number of players:");
            System.out.println("1.One Player\n2.Two Players");
            try {
                NumberOfPlayers players = NumberOfPlayers.valueOf(Integer.parseInt(reader.readLine()));
                switch (players) {
                    case ONE_PLAYER -> secondPlayer = selectAIDiffuculty();
                    case TWO_PLAYERS -> secondPlayer = new Human("Player 2");
                }
                isExit = true;
            } catch (NumberFormatException e) {
                System.out.println("Enter incorrect command. Enter a number from list.\n");
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private AIBot selectAIDiffuculty() throws IOException {
        System.out.println("Choose game difficulty:");
        System.out.println("1.Easy\n2.Hard");
        AIdifficulty difficulty = AIdifficulty.valueOf(Integer.parseInt(reader.readLine()));
        switch (difficulty) {
            case EASY -> {
                return new AIEasy("Player 2");
            }
            case HARD -> {
                return new AIHard("Player 2");
            }
        }
        return null;
    }
}