package session.gameplay;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board implements Cloneable {
    private Sign[][] table = new Sign[3][3];

    public Board() {
        Arrays.stream(table).forEach(x -> Arrays.fill(x, Sign.SIGN_EMPTY));
    }

    public void setSign(Position pos, Sign sign) {
        table[pos.getRow()][pos.getColumn()] = sign;
    }

    public Sign getSign(Position pos) {
        return table[pos.getRow()][pos.getColumn()];
    }

    public Sign[][] getTable() {
        return table;
    }

    public int getCountEmpty() {
        return (int) Arrays.stream(table)
                .flatMap(Arrays::stream)
                .filter(sign -> sign == Sign.SIGN_EMPTY)
                .count();
    }

    public void printTable() {
        IntStream.range(0, table.length)
                .mapToObj(row -> IntStream.range(0, table[row].length)
                        .mapToObj(column -> getPrintableSign(row, column))
                        .collect(Collectors.joining(" ")))
                .forEach(System.out::println);
    }

    public boolean checkWin(Position pos) {
        if (table[pos.getRow()][0] == table[pos.getRow()][1] && table[pos.getRow()][0] == table[pos.getRow()][2]) {
            return true;
        }
        if (table[0][pos.getColumn()] == table[1][pos.getColumn()] && table[0][pos.getColumn()] == table[2][pos.getColumn()]) {
            return true;
        }
        if ((pos.getRow() + pos.getColumn()) % 2 != 0) {
            return false;
        }
        if (pos.getRow() == pos.getColumn()) {
            if (table[0][0] == table[1][1] && table[0][0] == table[2][2]) {
                return true;
            }
            if (pos.getRow() != 1 && pos.getColumn() != 1) {
                return false;
            }
        }
        return table[2][0] == table[1][1] && table[1][1] == table[0][2];
    }

    private String getPrintableSign(int row, int column) {
        if (table[row][column] == Sign.SIGN_EMPTY) {
            return "(" + (row * table.length + column + 1) + ")";
        } else {
            return " " + table[row][column].getValue() + " ";
        }
    }

    @Override
    public Board clone() {
        try {
            Board clone = (Board) super.clone();
            clone.table = Arrays.stream(this.table)
                    .map(Sign[]::clone)
                    .toArray(Sign[][]::new);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}