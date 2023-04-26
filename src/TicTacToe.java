import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        work();
    }

    private void work() {
        boolean isExit = false;
        while (!isExit) {
            Gameplay gameplay;
            System.out.println("Enter mode number:");
            System.out.println("1.New game\n0.Exit");
            try {
                UserGameMode gameMode = UserGameMode.valueOf(Integer.parseInt(reader.readLine()));
                switch (gameMode) {
                    case START -> {
                        gameplay = new Gameplay(selectNumberOfPlayers());
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

    private PlayerDifficulty selectNumberOfPlayers() throws IOException {
        System.out.println("Choose number of players:");
        System.out.println("1.One Player\n2.Two Players");
        NumberPlayers players = NumberPlayers.valueOf(Integer.parseInt(reader.readLine()));
        switch (players) {
            case ONE_PLAYER -> {
                return selectGameDiffuculty();
            }
            case TWO_PLAYERS -> {
                return PlayerDifficulty.HUMAN;
            }
        }
        return null;
    }

    private PlayerDifficulty selectGameDiffuculty() throws IOException {
        System.out.println("Choose game difficulty:");
        System.out.println("1.Easy\n2.Hard");
        AIdifficulty difficulty = AIdifficulty.valueOf(Integer.parseInt(reader.readLine()));
        switch (difficulty) {
            case EASY -> {
                return PlayerDifficulty.BOT_EASY;
            }
            case HARD -> {
                return PlayerDifficulty.BOT_HARD;
            }
        }
        return null;
    }
}