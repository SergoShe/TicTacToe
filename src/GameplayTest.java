public class GameplayTest {

    @org.junit.Test
    public void testStartGame() {
        Board board = new Board();
        board.initTable();
        board.printTable();
        System.out.println(board.getCountEmpty());
        board.setSign(new Position(1),Sign.SIGN_O);
        board.printTable();
        System.out.println(board.getCountEmpty());
        board.setSign(new Position(6),Sign.SIGN_X);
        board.printTable();
        System.out.println(board.getCountEmpty());
        board.initTable();
        board.printTable();
    }
}