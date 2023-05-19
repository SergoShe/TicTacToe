import session.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeApp {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Session session;
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter mode number:");
            System.out.println("1.New game\n0.Exit");
            try {
                UserGameMode gameMode = UserGameMode.valueOf(Integer.parseInt(reader.readLine()));
                switch (gameMode) {
                    case START -> {
                        session = new Session();
                        session.startSession();
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
}