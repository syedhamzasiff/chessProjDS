import board.Board;
import gui.Table;

public class Main {
    public static void main(String[] args) {

        Board board = Board.createStandardBoard();

        System.out.println(board);

        Table table = new Table();
    }
}
