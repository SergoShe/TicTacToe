package session.player;

import session.gameplay.Board;
import session.gameplay.Position;
import session.gameplay.Sign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    @Override
    public Position move(Board board, Sign sign) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean isCorrect = false;
        Position position = null;
        int dot;
        while (!isCorrect) {
            System.out.println("Enter number (1-9): ");
            try {
                dot = Integer.parseInt(reader.readLine());
                if (dot < 1 || dot > 9) {
                    System.out.println("\nWrong cell's number. Enter a number of free cell.");
                    System.out.println("Turn: " + getName() + " (" + sign.getValue() + ")");
                    System.out.println("Current:");
                    board.printTable();
                } else {
                    position = new Position(dot);
                    if (board.getSign(position) == Sign.SIGN_EMPTY) {
                        isCorrect = true;
                    } else {
                        System.out.println("\nChoose free cell's number.");
                        System.out.println("Turn: " + getName() + " (" + sign.getValue() + ")");
                        System.out.println("Current:");
                        board.printTable();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nEnter incorrect command. Enter a number of free cell.");
                System.out.println("Turn: " + getName() + " (" + sign.getValue() + ")");
                System.out.println("Current:");
                board.printTable();
            }
        }
        return position;
    }
}