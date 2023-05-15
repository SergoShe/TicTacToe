package initializer;

import gameplay.Gameplay;
import gameplay.Sign;
import initializer.player.bot.AIEasy;
import initializer.player.bot.AIHard;
import initializer.player.Human;
import initializer.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeInitializer {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        work();
    }

    private void work() {
        boolean isExit = false;
        while (!isExit) {
            Gameplay gameplay;
            Player firstPlayer = new Human("Player 1", Sign.SIGN_X);
            Player secondPlayer;
            System.out.println("Enter mode number:");
            System.out.println("1.New game\n0.Exit");
            try {
                UserGameMode gameMode = UserGameMode.valueOf(Integer.parseInt(reader.readLine()));
                switch (gameMode) {
                    case START -> {
                        secondPlayer = selectNumberOfPlayers();
                        gameplay = new Gameplay(firstPlayer, secondPlayer);
                        gameplay.startGame();
                    }
                    case EXIT -> isExit = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter incorrect command. Enter a number from list.\n");
            } catch (IllegalArgumentException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Player selectNumberOfPlayers() throws IOException {
        System.out.println("Choose number of players:");
        System.out.println("1.One Player\n2.Two Players");
        NumberPlayers players = NumberPlayers.valueOf(Integer.parseInt(reader.readLine()));
        switch (players) {
            case ONE_PLAYER -> {
                return selectAIDiffuculty();
            }
            case TWO_PLAYERS -> {
                return new Human("Player 2", Sign.SIGN_O);
            }
        }
        return null;
    }

    private Player selectAIDiffuculty() throws IOException {
        System.out.println("Choose game difficulty:");
        System.out.println("1.Easy\n2.Hard");
        AIdifficulty difficulty = AIdifficulty.valueOf(Integer.parseInt(reader.readLine()));
        switch (difficulty) {
            case EASY -> {
                return new AIEasy("Player 2", Sign.SIGN_O);
            }
            case HARD -> {
                return new AIHard("Player 2", Sign.SIGN_O);
            }
        }
        return null;
    }
}